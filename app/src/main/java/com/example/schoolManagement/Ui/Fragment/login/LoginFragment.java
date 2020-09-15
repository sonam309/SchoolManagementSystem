package com.example.schoolManagement.Ui.Fragment.login;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.schoolManagement.R;
import com.example.schoolManagement.Ui.Activity.CreateAccountActivity;
import com.example.schoolManagement.Ui.Activity.LoginActivity;
import com.example.schoolManagement.Ui.Activity.MainActivity;
import com.example.schoolManagement.Ui.viewModel.LoginViewModel;
import com.example.schoolManagement.model.User;
import com.example.schoolManagement.model.UserLoginDetailModel;
import com.example.schoolManagement.network.ApiClient;
import com.example.schoolManagement.utility.KeyClass;
import com.google.android.material.textfield.TextInputLayout;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class LoginFragment extends Fragment implements View.OnClickListener, Observer<User> {
    private View mview;
    private Context mctx;
    private TextView txt_create_account, txt_forgetpassword;
    private TextInputLayout textField_email, textField_password;
    private Button sigin_btn;
    private LoginViewModel loginData;
    private String user_email, email, user_name, user_id;
    private EditText user_email_et, user_password_et;
    private  boolean isFound = false;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (mview == null) {
            mctx = getActivity();
            // Inflate the layout for this fragment
            mview = inflater.inflate(R.layout.fragment_login, container, false);
        }
        return mview;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        bindview();
        viewModelSetup();
        viewsetup();

    }


    private void bindview() {

        //textview
        txt_create_account = mview.findViewById(R.id.txt_create_account);
        txt_forgetpassword = mview.findViewById(R.id.txt_forgetpassword);
        textField_password = mview.findViewById(R.id.textField_password);
        textField_email = mview.findViewById(R.id.textField_email);
        sigin_btn = mview.findViewById(R.id.sigin_btn);
        user_email_et = mview.findViewById(R.id.user_email_et);
        user_password_et = mview.findViewById(R.id.user_password_et);

    }


    private void viewsetup() {

        txt_create_account.setOnClickListener(this);
        txt_forgetpassword.setOnClickListener(this);
        sigin_btn.setOnClickListener(this);

    }

    private void viewModelSetup() {


        loginData = new ViewModelProvider(this).get(LoginViewModel.class);
        loginData.logIn.observe(getViewLifecycleOwner(), this);


    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.txt_forgetpassword:

                ((LoginActivity) getActivity()).replaceFragment(new ForgetPasswordFragment(), true,
                        KeyClass.FRAGMENT_FORGET_PASSWORD, KeyClass.FRAGMENT_FORGET_PASSWORD);

                break;
            case R.id.txt_create_account:

                Intent register = new Intent(mctx, CreateAccountActivity.class);
                startActivity(register);

                break;
            case R.id.sigin_btn:

                if (TextUtils.isEmpty(user_email_et.getText().toString()) && TextUtils.isEmpty(user_password_et.getText().toString())) {

                    Toast.makeText(mctx, "fields can't be empty", Toast.LENGTH_SHORT).show();
                } else {


                    userDetail();

                }

                break;
        }


    }


    @Override
    public void onChanged(User user) {

        Intent login = new Intent(mctx, MainActivity.class);
        startActivity(login);
        getActivity().finish();

        Toast.makeText(getActivity(), user.getToken(), Toast.LENGTH_SHORT).show();


    }



    private void userDetail() {
        user_email = user_email_et.getText().toString();
        ApiClient.getBaseApiMethods().userLogindetail().enqueue(new Callback<List<UserLoginDetailModel>>() {
            @Override
            public void onResponse(Call<List<UserLoginDetailModel>> call, Response<List<UserLoginDetailModel>> response) {
                List<UserLoginDetailModel> list = response.body();
                for (int i = 0; i < list.size(); i++) {
                    email = list.get(i).getEmail();
                    if (email.equals(user_email)) {
                        user_name = list.get(i).getUsername();
                        user_id = String.valueOf(list.get(i).getId());
                        isFound = true;
                        break;
                    }
                }
                if (isFound)
                    loginData.loginFun(user_name, user_password_et.getText().toString());
                else
                    Toast.makeText(mctx, "User not found", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Call<List<UserLoginDetailModel>> call, Throwable t) {
                Log.e("okokokok", t.getMessage());
                Toast.makeText(mctx, "User not found", Toast.LENGTH_SHORT).show();

            }
        });


    }


}