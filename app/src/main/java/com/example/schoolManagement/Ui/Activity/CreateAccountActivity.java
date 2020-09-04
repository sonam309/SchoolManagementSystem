package com.example.schoolManagement.Ui.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.schoolManagement.R;
import com.google.android.material.textfield.TextInputLayout;

public class CreateAccountActivity extends AppCompatActivity implements View.OnClickListener {

    private TextInputLayout textField_username,textField_useremail,textField_userpassword,textField_user_cnfpassword;
    private Button register_btn;
    private TextView txt_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);


        bindView();
        viewModelSetup();
        viewsetup();
    }

    private void bindView() {

        //TextInputLayouts.
        textField_username=findViewById(R.id.textField_username);
        textField_useremail=findViewById(R.id.textField_useremail);
        textField_userpassword=findViewById(R.id.textField_userpassword);
        textField_user_cnfpassword=findViewById(R.id.textField_user_cnfpassword);

        //Buttons
        register_btn=findViewById(R.id.register_btn);

    }

    private void viewModelSetup() {

    }

    private void viewsetup() {

        register_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.register_btn:

                Intent register= new Intent(this,MainActivity.class);
                startActivity(register);

                break;

            case R.id.txt_login:

                Intent login= new Intent(this,LoginActivity.class);
                startActivity(login);

                break;
        }

    }
}