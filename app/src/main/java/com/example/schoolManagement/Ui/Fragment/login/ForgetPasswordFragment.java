package com.example.schoolManagement.Ui.Fragment.login;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.schoolManagement.R;
import com.example.schoolManagement.Ui.Activity.LoginActivity;
import com.example.schoolManagement.utility.KeyClass;
import com.google.android.material.textfield.TextInputLayout;


public class ForgetPasswordFragment extends Fragment implements View.OnClickListener {
    private View mview;
    private Context mctx;
    private TextInputLayout textField_forget_email;
    private Button send_link_btn;
    private EditText txt_forget_email;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (mview == null) {
            mctx = getActivity();
            // Inflate the layout for this fragment
            mview = inflater.inflate(R.layout.fragment_forget_password, container, false);
        }
        return mview;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        bindView();
        viewModelSetup();
        viewSetup();

    }

    private void bindView() {

        //TextInputLayout
        textField_forget_email = mview.findViewById(R.id.textField_forget_email);

        //Button
        send_link_btn = mview.findViewById(R.id.send_link_btn);

        //EditText
        txt_forget_email=mview.findViewById(R.id.txt_forget_email);

    }

    private void viewModelSetup() {

    }

    private void viewSetup() {

        send_link_btn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.send_link_btn:

                if(TextUtils.isEmpty(txt_forget_email.getText().toString())){

                    Toast.makeText(mctx, "Can't be empty", Toast.LENGTH_SHORT).show();
                }else {
                    ((LoginActivity) getActivity()).replaceFragment(new SendLinkConfirmationFragment(), true,
                            KeyClass.FRAGMENT_SEND_LINK_CONFIRMATION, KeyClass.FRAGMENT_SEND_LINK_CONFIRMATION);
                }

                break;
        }

    }
}