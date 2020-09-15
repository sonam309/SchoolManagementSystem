package com.example.schoolManagement.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.schoolManagement.R;
import com.example.schoolManagement.model.UserProfileDetailModel;
import com.example.schoolManagement.utility.Utils;

import java.util.List;

public class StudentDataRecyclerAdapter extends RecyclerView.Adapter<StudentDataRecyclerAdapter.StudentDataRecyclerViewHolder> {

    private List<UserProfileDetailModel> userProfileDetailModel;
    private Context context;


    public StudentDataRecyclerAdapter(List<UserProfileDetailModel> userProfileDetailModel, Context context) {
        this.userProfileDetailModel = userProfileDetailModel;
        this.context = context;
    }

    public StudentDataRecyclerAdapter() {

    }




    @NonNull
    @Override
    public StudentDataRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.student_data_recycler_item, parent, false);
        return new StudentDataRecyclerViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull StudentDataRecyclerViewHolder holder, int position) {

        holder.serialNo.setText(userProfileDetailModel.get(position).getId()+"");
        holder.txt_Studentname.setText(userProfileDetailModel.get(position).getFirstName() +" "+ userProfileDetailModel.get(position).getLastName());
        holder.studentFatherName.setText(userProfileDetailModel.get(position).getFatherName());
        holder.studentMotherName.setText(userProfileDetailModel.get(position).getMotherName());
        Utils.loadImage(holder.studentPrifileImg,context,userProfileDetailModel.get(position).getProfilePic());


    }

    @Override
    public int getItemCount() {
        return userProfileDetailModel.size();
    }

    class StudentDataRecyclerViewHolder extends RecyclerView.ViewHolder {

        TextView serialNo, txt_Studentname, studentRollno, studentFatherName, studentMotherName;
        ImageView studentPrifileImg;

        public StudentDataRecyclerViewHolder(@NonNull View itemView) {
            super(itemView);

            bindView();
            viewSetup();
        }

        private void bindView() {
            serialNo = itemView.findViewById(R.id.serialNo);
            txt_Studentname = itemView.findViewById(R.id.txt_Studentname);
            studentRollno = itemView.findViewById(R.id.studentRollno);
            studentFatherName = itemView.findViewById(R.id.studentFatherName);
            studentMotherName = itemView.findViewById(R.id.studentMotherName);


            studentPrifileImg = itemView.findViewById(R.id.studentPrifileImg);
        }

        private void viewSetup() {
        }
    }
}
