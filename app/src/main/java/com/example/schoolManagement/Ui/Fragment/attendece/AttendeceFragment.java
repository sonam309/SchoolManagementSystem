package com.example.schoolManagement.Ui.Fragment.attendece;

import android.app.DatePickerDialog;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.schoolManagement.R;
import com.example.schoolManagement.Ui.Activity.MainActivity;
import com.example.schoolManagement.utility.KeyClass;
import com.example.schoolManagement.utility.Utils;

import java.util.Calendar;
import java.util.Date;


public class AttendeceFragment extends Fragment implements View.OnClickListener {
    private View mview;
    private Context mctx;
    private Spinner spinner_select_class, spinner_attendence_date;
    private CardView view_btn_cardview;
    private Button view_btn;
    private String Class[] = {"Class1", "Class2", "Class3", "Class4", "Class5", "class6", "Class7",
            "Class8", "Class9", "Class10", "Class11", "Class12"};
    private TextView txt_date;
    private ImageView date_iv;
    private RelativeLayout attendece_datepicker_rl;
    private Date attendanceDate;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (mview == null) {
            mctx = getActivity();
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

        //Spinner
        spinner_select_class = mview.findViewById(R.id.spinner_select_class);

        //Textview
        txt_date = mview.findViewById(R.id.txt_date);

        //Imageview
        date_iv=mview.findViewById(R.id.date_iv);

        //cardview button
        view_btn_cardview = mview.findViewById(R.id.view_btn_cardview);

        //button On click
        view_btn = mview.findViewById(R.id.view_btn);

        //RelativeLayout
        attendece_datepicker_rl=mview.findViewById(R.id.attendece_datepicker_rl);

    }

    private void viewsetup() {

        //cardview OnClick
        view_btn_cardview.setOnClickListener(this);

        //button On click
        view_btn.setOnClickListener(this);


        //Relative Onclick
        attendece_datepicker_rl.setOnClickListener(this);

        //ArrayAdapter1
        ArrayAdapter adapter= new ArrayAdapter(mctx,android.R.layout.simple_spinner_item,Class);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);



        //Adaptersetup
        spinner_select_class.setAdapter(adapter);
        spinnerItemclick();


    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.view_btn_cardview:
            case R.id.view_btn:

                ((MainActivity) getActivity()).replaceFragment(new ViewattendeceDataFragment(), true,
                        KeyClass.FRAGMENT_VIEW_ATTENDECE_DATA, KeyClass.FRAGMENT_VIEW_ATTENDECE_DATA);

                break;

            case R.id.attendece_datepicker_rl:

                openDatePickerDialog();

                break;

        }

    }


    public void spinnerItemclick(){
        spinner_select_class.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

//                if(position==0){
//
//                }else {
//
//                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }


    private void openDatePickerDialog() {
        // Get Current Date
        final Calendar calendar = Calendar.getInstance();


        int mYear = (calendar.get(Calendar.YEAR));
        int mMonth = calendar.get(Calendar.MONTH);
        int mDay = calendar.get(Calendar.DAY_OF_MONTH);

        final DatePickerDialog datePickerDialog = new DatePickerDialog(txt_date.getContext(),
                new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {
                        Calendar calendarSelected = Calendar.getInstance();

                        calendarSelected.set(year, monthOfYear, dayOfMonth);

                         attendanceDate = calendarSelected.getTime();
                        txt_date.setText(Utils.getStringFromDate(attendanceDate, KeyClass.DATE_MMM_dd));


                    }
                }, mYear, mMonth, mDay);
        Calendar calendar1 = Calendar.getInstance();
        calendar1.set(Calendar.MONTH, mMonth - 1);
        calendar1.set(Calendar.DAY_OF_MONTH, mDay);
        calendar1.set(Calendar.YEAR, mYear - 120);
        datePickerDialog.getDatePicker().setMinDate(calendar1.getTimeInMillis());
        datePickerDialog.getDatePicker().setMaxDate(new Date().getTime());


        datePickerDialog.show();


    }
}