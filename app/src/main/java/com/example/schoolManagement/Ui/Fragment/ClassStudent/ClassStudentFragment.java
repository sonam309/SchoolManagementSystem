package com.example.schoolManagement.Ui.Fragment.ClassStudent;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.schoolManagement.R;
import com.example.schoolManagement.Ui.viewModel.ClassesViewModel;
import com.example.schoolManagement.Ui.viewModel.UserProfileDetailViewModel;
import com.example.schoolManagement.adapter.StudentDataRecyclerAdapter;
import com.example.schoolManagement.model.ClassDataModel;
import com.example.schoolManagement.model.UserProfileDetailModel;

import java.util.ArrayList;
import java.util.List;


public class ClassStudentFragment extends Fragment implements View.OnClickListener, Observer<List<UserProfileDetailModel>>{
    private Context mctx;
    private View mview;
    private ImageView institute_icon;
    private TextView institute_name,txt_class_attendece,txt_student_class;
    private Spinner spinner_select_class;
    private Button view_btn;
    private RecyclerView student_data_recycler;
    private StudentDataRecyclerAdapter studentDataRecyclerAdapter;
    private List<UserProfileDetailModel> userProfileDetailModel;
    private UserProfileDetailViewModel userProfileDetailVM;
    private ClassesViewModel classesViewModel;
    private List<ClassDataModel> classDataModel;
    private ArrayAdapter spinnerAdapter;


    private String Class[] = {"Class 1", "Class 2", "Class 3", "Class 4", "Class 5", "class 6", "Class 7",
            "Class 8", "Class 9", "Class 10", "Class 11", "Class 12"};


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if(mview==null) {
            mctx=getActivity();
            // Inflate the layout for this fragment
            mview = inflater.inflate(R.layout.fragment_class_student, container, false);
        }
        return mview;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        bindView();
        viewModelSetup();
        viewSetup();
        userProfileDetail();
    }



    private void bindView() {

        institute_icon=mview.findViewById(R.id.institute_icon);
        institute_name=mview.findViewById(R.id.institute_name);
        txt_class_attendece=mview.findViewById(R.id.txt_class_attendece);
        spinner_select_class=mview.findViewById(R.id.spinner_select_class);
        view_btn=mview.findViewById(R.id.view_btn);
        txt_student_class=mview.findViewById(R.id.txt_student_class);
        student_data_recycler=mview.findViewById(R.id.student_data_recycler);


    }

    private void viewModelSetup() {

        userProfileDetailVM=new ViewModelProvider(this).get(UserProfileDetailViewModel.class);
        userProfileDetailVM.userProfileDetail.observe(getViewLifecycleOwner(),this);
        classesViewModel= new ViewModelProvider(this).get(ClassesViewModel.class);
        classesViewModel.classesData.observe(getViewLifecycleOwner(),classDataModelobserver);



    }

    private void viewSetup() {

        adapterSetup();

        view_btn.setOnClickListener(this);

        classesViewModel.classData();


    }
    private void adapterSetup(){

        spinnerItemclick();

        userProfileDetailModel = new ArrayList<>();
        studentDataRecyclerAdapter=new StudentDataRecyclerAdapter(userProfileDetailModel,mctx);
        student_data_recycler.setAdapter(studentDataRecyclerAdapter);

    }


    public void spinnerItemclick(){
        spinner_select_class.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

//                String className= parent.getItemAtPosition(position).toString();
//                Log.e("ccccccc",className);


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.view_btn:

                txt_student_class.setText(spinner_select_class.getSelectedItem().toString());

                break;
        }

    }

    @Override
    public void onChanged(List<UserProfileDetailModel> userProfileDetailModels) {

        userProfileDetailModel.addAll(userProfileDetailModels);
        studentDataRecyclerAdapter.notifyDataSetChanged();

    }

    private final Observer<List<ClassDataModel>> classDataModelobserver= new Observer<List<ClassDataModel>>() {
        @Override
        public void onChanged(List<ClassDataModel> classDataModels) {

            classDataModel.addAll(classDataModels);
//            classDataModel= new ArrayList<>();
            spinnerAdapter= new ArrayAdapter(mctx,android.R.layout.simple_spinner_item,classDataModel);
            spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner_select_class.setAdapter(spinnerAdapter);

        }
    };


    private void userProfileDetail(){

        userProfileDetailVM.userProfileDetail(mctx);

    }
}