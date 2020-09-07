package com.example.schoolManagement.Ui.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;

import com.example.schoolManagement.R;
import com.example.schoolManagement.Ui.Fragment.login.LoginFragment;
import com.example.schoolManagement.utility.KeyClass;
import com.example.schoolManagement.utility.constant;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    public static FrameLayout FragmentContainer;
    public static Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        bindview();
        viewModelSetup();
        viewsetup();

    }



    private void bindview() {

        FragmentContainer=findViewById(R.id.FragmentContainer);


    }

    private void viewModelSetup() {



    }

    private void viewsetup() {

        //fullscree
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        LoginFragment loginFragment = new LoginFragment();
        if (getIntent().getExtras()!=null){
            Bundle b=new Bundle();
            b.putString(constant.StringConstants.DATA,getIntent().getExtras().getString(constant.StringConstants.DATA));
            loginFragment.setArguments(b);
        }
        replaceFragment(loginFragment, false, KeyClass.FRAGMENT_LOGIN, KeyClass.FRAGMENT_LOGIN);
    }




    @Override
    public void onClick(View v) {

    }

    //    Switch Fragment Method
    public void replaceFragment(Fragment fragment, boolean addToBackStack, String transactionName, String tag) {
        try {
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
//            fragmentTransaction.setCustomAnimations(R.animator.slid_up, 0, 0, R.animator.slide_down);
            fragmentTransaction.replace(LoginActivity.FragmentContainer.getId(), fragment, tag);
            if (addToBackStack)
                fragmentTransaction.addToBackStack(transactionName);
            fragmentTransaction.commitAllowingStateLoss();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}