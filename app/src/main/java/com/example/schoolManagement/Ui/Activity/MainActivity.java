package com.example.schoolManagement.Ui.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.schoolManagement.R;
import com.example.schoolManagement.Ui.Fragment.attendece.AttendeceFragment;
import com.example.schoolManagement.Ui.Fragment.DashboardFragment;
import com.example.schoolManagement.utility.KeyClass;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements  View.OnClickListener, NavigationView.OnNavigationItemSelectedListener {

    public static FrameLayout container;
    public static Context context;
    private NavigationView navigationview;
    private ActionBarDrawerToggle toggleButton;
    private DrawerLayout drawer_layout;
    private Toolbar toolbar;
    private RelativeLayout nav_menue_dashboard_rl, navigation_My_Profile_rl, navigation_institute_profile_rl, navigation_notifications_rl,
            navigation_fee_setup_rl, navigation_holiday_list_rl, navigation_Schedule_rl, navigation_approvals_rl, navigation_attendece_rl,
            navigation_class_student_rl, navigation_examinations_rl;
    private ImageView close_iv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        bindView();
        viewSetup();

    }

    private void bindView() {

        //Fragment Container
        container = findViewById(R.id.container);

        //navigatio drwaer
        navigationview = findViewById(R.id.navigationview);

        //drawe main view
        drawer_layout = findViewById(R.id.drawer_layout);

        //toolbar
        toolbar = findViewById(R.id.toolbar);

        //Image view
        close_iv = findViewById(R.id.close_iv);


        //Relative Layout
        nav_menue_dashboard_rl = findViewById(R.id.nav_menue_dashboard_rl);
        navigation_My_Profile_rl = findViewById(R.id.navigation_My_Profile_rl);
        navigation_institute_profile_rl = findViewById(R.id.navigation_institute_profile_rl);
        navigation_notifications_rl = findViewById(R.id.navigation_notifications_rl);
        navigation_fee_setup_rl = findViewById(R.id.navigation_fee_setup_rl);
        navigation_holiday_list_rl = findViewById(R.id.navigation_holiday_list_rl);
        navigation_Schedule_rl = findViewById(R.id.navigation_Schedule_rl);
        navigation_approvals_rl = findViewById(R.id.navigation_approvals_rl);
        navigation_attendece_rl = findViewById(R.id.navigation_attendece_rl);
        navigation_class_student_rl = findViewById(R.id.navigation_class_student_rl);
        navigation_examinations_rl = findViewById(R.id.navigation_examinations_rl);

    }

    private void viewSetup() {

        //fullscree
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //switchFragment
        replaceFragment(new AttendeceFragment(), false, KeyClass.FRAGMENT_ATTENDENCE, KeyClass.FRAGMENT_ATTENDENCE);

        //RelativeLayout On click
        nav_menue_dashboard_rl.setOnClickListener(this);
        navigation_My_Profile_rl.setOnClickListener(this);
        navigation_institute_profile_rl.setOnClickListener(this);
        navigation_notifications_rl.setOnClickListener(this);
        navigation_fee_setup_rl.setOnClickListener(this);
        navigation_holiday_list_rl.setOnClickListener(this);
        navigation_Schedule_rl.setOnClickListener(this);
        navigation_approvals_rl.setOnClickListener(this);
        navigation_attendece_rl.setOnClickListener(this);
        navigation_class_student_rl.setOnClickListener(this);
        navigation_examinations_rl.setOnClickListener(this);

        //Image Onclick
        close_iv.setOnClickListener(this);

        //navigation On click
        navigationview.setNavigationItemSelectedListener(this);

//        toolbat/toggle button setup
        setSupportActionBar(toolbar);
        toggleButton = new ActionBarDrawerToggle(this, drawer_layout, toolbar, R.string.open, R.string.close);
        drawer_layout.addDrawerListener(toggleButton);
        toggleButton.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.white));
        toggleButton.syncState();
        getSupportActionBar().setTitle(null);


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
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.close_iv:

                drawer_layout.closeDrawer(GravityCompat.START);

                break;
            case R.id.nav_menue_dashboard_rl:

                replaceFragment(new DashboardFragment(), false, KeyClass.FRAGMENT_DASHBORD, KeyClass.FRAGMENT_DASHBORD);
                closemethod("Dashboard");


                break;

            case R.id.navigation_My_Profile_rl:

                closemethod("my profile");

                break;
            case R.id.navigation_institute_profile_rl:

                closemethod("institute profile");

                break;
            case R.id.navigation_notifications_rl:

                closemethod("notifications");

                break;
            case R.id.navigation_fee_setup_rl:

                closemethod("fee setup");

                break;
            case R.id.navigation_holiday_list_rl:

                closemethod("holiday list");

                break;
            case R.id.navigation_Schedule_rl:

                closemethod("schedule");

                break;
            case R.id.navigation_approvals_rl:

                closemethod("approval");

                break;
            case R.id.navigation_attendece_rl:

                closemethod("attendence");
                replaceFragment(new AttendeceFragment(), true, KeyClass.FRAGMENT_ATTENDENCE, KeyClass.FRAGMENT_ATTENDENCE);


                break;
            case R.id.navigation_class_student_rl:

                closemethod("class students");

                break;
            case R.id.navigation_examinations_rl:

                closemethod("Examination");


                break;
        }

    }


    public void closemethod(String msg) {

        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        drawer_layout.closeDrawer(GravityCompat.START);

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        return true;
    }


}