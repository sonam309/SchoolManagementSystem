package com.example.schoolManagement.Ui.Fragment.login;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.schoolManagement.R;
import com.example.schoolManagement.Ui.Activity.CreateAccountActivity;
import com.example.schoolManagement.Ui.Activity.LoginActivity;
import com.example.schoolManagement.Ui.Activity.MainActivity;
import com.example.schoolManagement.utility.KeyClass;
import com.google.android.material.textfield.TextInputLayout;


public class LoginFragment extends Fragment implements View.OnClickListener {
    private View mview;
    private Context mctx;
    private TextView txt_create_account, txt_forgetpassword;
    private TextInputLayout textField_email, textField_password;
    private Button sigin_btn;

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
        viewsetup();

    }

    private void bindview() {

        //textview
        txt_create_account = mview.findViewById(R.id.txt_create_account);
        txt_forgetpassword = mview.findViewById(R.id.txt_forgetpassword);
        textField_password = mview.findViewById(R.id.textField_password);
        textField_email = mview.findViewById(R.id.textField_email);
        sigin_btn = mview.findViewById(R.id.sigin_btn);

    }

    private void viewsetup() {

        txt_create_account.setOnClickListener(this);
        txt_forgetpassword.setOnClickListener(this);
        sigin_btn.setOnClickListener(this);

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

                if (TextUtils.isEmpty(textField_email.toString())) {
                    textField_email.setError("Required email");
                } else if (TextUtils.isEmpty(textField_password.toString())) {
                    textField_password.setError("Required password");
                } else {

                    Intent login = new Intent(mctx, MainActivity.class);
                    startActivity(login);

                }


                break;
        }


    }
}