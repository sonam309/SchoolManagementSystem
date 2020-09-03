package com.example.schoolManagement.Ui.Fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.schoolManagement.R;


public class AttendeceFragment extends Fragment implements View.OnClickListener {
    private View mview;
    private Context mctx;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if(mview==null) {
            mctx=getActivity();
            // Inflate the layout for this fragment
            mview = inflater.inflate(R.layout.fragment_attendece, container, false);
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

    }

    private void viewsetup() {

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

        }

    }
}