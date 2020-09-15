package com.example.schoolManagement.model;

import androidx.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ClassDataModel {


    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("class_stage")
    @Expose
    private String classStage;
    @SerializedName("institute")
    @Expose
    private Integer institute;
    @SerializedName("class_teacher")
    @Expose
    private Object classTeacher;


    public ClassDataModel(Integer id, String name, String createdAt, String updatedAt, String classStage, Integer institute, Object classTeacher) {
        this.id = id;
        this.name = name;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.classStage = classStage;
        this.institute = institute;
        this.classTeacher = classTeacher;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getClassStage() {
        return classStage;
    }

    public void setClassStage(String classStage) {
        this.classStage = classStage;
    }

    public Integer getInstitute() {
        return institute;
    }

    public void setInstitute(Integer institute) {
        this.institute = institute;
    }

    public Object getClassTeacher() {
        return classTeacher;
    }

    public void setClassTeacher(Object classTeacher) {
        this.classTeacher = classTeacher;
    }


    @NonNull
    @Override
    public String toString() {

        return this.name;

    }
}
