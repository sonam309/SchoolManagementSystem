package com.example.schoolManagement.Ui.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.schoolManagement.R;
import com.example.schoolManagement.Ui.Fragment.login.LoginFragment;
import com.example.schoolManagement.utility.KeyClass;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class CreateAccountActivity extends AppCompatActivity implements View.OnClickListener, TextView.OnEditorActionListener {

    private TextInputLayout textField_username, textField_useremail, textField_userpassword, textField_user_cnfpassword;
    private Button register_btn;
    private TextView txt_login;
    private EditText txt_username_et, txt_user_email_et, txt_user_password_et, txt_user_cnf_password;
    private String password, cnfpassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);


        bindView();
//        viewModelSetup();
        viewsetup();
    }

    private void bindView() {

        //TextInputLayouts.
        textField_username = findViewById(R.id.textField_username);
        textField_useremail = findViewById(R.id.textField_useremail);
        textField_userpassword = findViewById(R.id.textField_userpassword);
        textField_user_cnfpassword = findViewById(R.id.textField_user_cnfpassword);

        //Buttons
        register_btn = findViewById(R.id.register_btn);
        txt_login = findViewById(R.id.txt_login);

        //TextInputEditText
        txt_username_et = findViewById(R.id.txt_username_et);
        txt_user_email_et = findViewById(R.id.txt_user_email_et);
        txt_user_password_et = findViewById(R.id.txt_user_password_et);
        txt_user_cnf_password = findViewById(R.id.txt_user_cnf_password);

    }


    private void viewsetup() {

        register_btn.setOnClickListener(this);
        txt_login.setOnClickListener(this);


    }


    private void viewModelSetup() {

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.register_btn:

                password = txt_user_password_et.getText().toString();
                cnfpassword = txt_user_cnf_password.getText().toString();

                if (TextUtils.isEmpty(txt_username_et.getText().toString())) {

                    Toast.makeText(this, "User name can't empty", Toast.LENGTH_SHORT).show();

                } else if (TextUtils.isEmpty(txt_user_email_et.getText().toString())) {

                    Toast.makeText(this, "Email can't empty", Toast.LENGTH_SHORT).show();

                } else if (TextUtils.isEmpty(password)) {

                    Toast.makeText(this, "Password can't empty", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(cnfpassword)) {

                    Toast.makeText(this, "Confirm password can't empty", Toast.LENGTH_SHORT).show();

                } else if (password.equalsIgnoreCase(cnfpassword)) {

                    Intent register = new Intent(this, MainActivity.class);
                    startActivity(register);

                } else {

                    Toast.makeText(this, "Confirm Password didn't match", Toast.LENGTH_SHORT).show();

                }

                break;

            case R.id.txt_login:

                Intent login = new Intent(this, LoginActivity.class);
                startActivity(login);

//                replaceFragment(new LoginFragment(),true, KeyClass.FRAGMENT_LOGIN,KeyClass.FRAGMENT_LOGIN);

                break;
        }

    }


    //    Switch Fragment Method
    public void replaceFragment(Fragment fragment, boolean addToBackStack, String transactionName, String tag) {
        try {
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
//            fragmentTransaction.setCustomAnimations(R.animator.slid_up, 0, 0, R.animator.slide_down);
            fragmentTransaction.replace(MainActivity.container.getId(), fragment, tag);
            if (addToBackStack)
                fragmentTransaction.addToBackStack(transactionName);
            fragmentTransaction.commitAllowingStateLoss();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {

        switch (v.getId()) {

            case R.id.txt_user_cnf_password:

                if (actionId == EditorInfo.IME_ACTION_DONE) {

                    onClick(register_btn);
                }

                break;
        }

        return false;
    }
}