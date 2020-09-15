package com.example.schoolManagement.Ui.Fragment.attendece;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.schoolManagement.R;


public class ViewattendeceDataFragment extends Fragment implements View.OnClickListener {

    private View mview;
    private Context mctx;
    private Spinner spinner_status;
    private String selectStatus[] = {" --select-- "," Present ", " Absent ", " Leave "};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (mview == null) {
            mctx = getActivity();
            // Inflate the layout for this fragment
            mview = inflater.inflate(R.layout.fragment_viewattendece_data, container, false);
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

        spinner_status = mview.findViewById(R.id.spinner_status);


    }

    private void viewsetup() {


        spinner_status.setAdapter(new SpinnerItemAdapter(mctx, R.layout.attendece_status_spinner_item,
                selectStatus));


    }

    @Override
    public void onClick(View v) {

    }


    public class SpinnerItemAdapter extends ArrayAdapter {

        public SpinnerItemAdapter(Context context, int textViewResourceId,
                                  String[] objects) {
            super(context, textViewResourceId, objects);
        }

        public View getCustomView(int position, View convertView,
                                  ViewGroup parent) {


            LayoutInflater inflater = LayoutInflater.from(getContext());
            View layout = inflater.inflate(R.layout.attendece_status_spinner_item, parent, false);


            TextView textView = layout.findViewById(R.id.text);
            CheckBox checkBox = layout.findViewById(R.id.checkbox);


            textView.setText(selectStatus[position]);


            return layout;
        }

        @Override
        public View getDropDownView(int position, View convertView,
                                    ViewGroup parent) {
            return getCustomView(position, convertView, parent);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            return getCustomView(position, convertView, parent);
        }
    }
}