package com.example.schoolManagement.Ui.Fragment.login;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.schoolManagement.R;
import com.example.schoolManagement.Ui.Activity.LoginActivity;
import com.example.schoolManagement.utility.KeyClass;


public class SendLinkConfirmationFragment extends Fragment implements View.OnClickListener {
    private View mview;
    private Context mctx;
    private TextView txt_login;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (mview == null) {
            mctx = getActivity();
            // Inflate the layout for this fragment
            mview = inflater.inflate(R.layout.fragment_send_link_confirmation, container, false);
        }
        return mview;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        bindView();
        viewSetup();

    }

    private void bindView() {

        txt_login = mview.findViewById(R.id.txt_login);

    }

    private void viewSetup() {

        txt_login.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.txt_login) {

            ((LoginActivity) getActivity()).replaceFragment(new LoginFragment(), false, KeyClass.FRAGMENT_LOGIN, KeyClass.FRAGMENT_LOGIN);
        }

    }
}