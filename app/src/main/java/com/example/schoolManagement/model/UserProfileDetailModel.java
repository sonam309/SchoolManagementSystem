package com.example.schoolManagement.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserProfileDetailModel {


    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("roll_number")
    @Expose
    private String rollNumber;
    @SerializedName("first_name")
    @Expose
    private String firstName;
    @SerializedName("middle_name")
    @Expose
    private String middleName;
    @SerializedName("last_name")
    @Expose
    private String lastName;
    @SerializedName("father_name")
    @Expose
    private String fatherName;
    @SerializedName("mother_name")
    @Expose
    private String motherName;
    @SerializedName("gender")
    @Expose
    private String gender;
    @SerializedName("date_of_birth")
    @Expose
    private String dateOfBirth;
    @SerializedName("marital_status")
    @Expose
    private String maritalStatus;
    @SerializedName("category")
    @Expose
    private String category;
    @SerializedName("qualification")
    @Expose
    private Object qualification;
    @SerializedName("aadhar_card_number")
    @Expose
    private String aadharCardNumber;
    @SerializedName("about")
    @Expose
    private Object about;
    @SerializedName("profile_pic")
    @Expose
    private String profilePic;
    @SerializedName("mobile_number")
    @Expose
    private long mobileNumber;
    @SerializedName("address_line_1")
    @Expose
    private String addressLine1;
    @SerializedName("address_line_2")
    @Expose
    private String addressLine2;
    @SerializedName("city")
    @Expose
    private String city;
    @SerializedName("pin_code")
    @Expose
    private String pinCode;
    @SerializedName("facebook_link")
    @Expose
    private String facebookLink;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("class_promotion_status")
    @Expose
    private String classPromotionStatus;
    @SerializedName("class_current_year")
    @Expose
    private String classCurrentYear;
    @SerializedName("class_next_year")
    @Expose
    private String classNextYear;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("user")
    @Expose
    private Integer user;
    @SerializedName("institute")
    @Expose
    private Integer institute;
    @SerializedName("designation")
    @Expose
    private Integer designation;
    @SerializedName("Class")
    @Expose
    private Integer _class;
    @SerializedName("state")
    @Expose
    private Integer state;


    public UserProfileDetailModel(Integer id, String rollNumber, String firstName, String middleName, String lastName, String fatherName, String motherName, String gender, String dateOfBirth, String maritalStatus, String category, Object qualification, String aadharCardNumber, Object about, String profilePic, Integer mobileNumber, String addressLine1, String addressLine2, String city, String pinCode, String facebookLink, String status, String classPromotionStatus, String classCurrentYear, String classNextYear, String createdAt, String updatedAt, Integer user, Integer institute, Integer designation, Integer _class, Integer state) {
        this.id = id;
        this.rollNumber = rollNumber;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.fatherName = fatherName;
        this.motherName = motherName;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.maritalStatus = maritalStatus;
        this.category = category;
        this.qualification = qualification;
        this.aadharCardNumber = aadharCardNumber;
        this.about = about;
        this.profilePic = profilePic;
        this.mobileNumber = mobileNumber;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.city = city;
        this.pinCode = pinCode;
        this.facebookLink = facebookLink;
        this.status = status;
        this.classPromotionStatus = classPromotionStatus;
        this.classCurrentYear = classCurrentYear;
        this.classNextYear = classNextYear;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.user = user;
        this.institute = institute;
        this.designation = designation;
        this._class = _class;
        this.state = state;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Object getQualification() {
        return qualification;
    }

    public void setQualification(Object qualification) {
        this.qualification = qualification;
    }

    public String getAadharCardNumber() {
        return aadharCardNumber;
    }

    public void setAadharCardNumber(String aadharCardNumber) {
        this.aadharCardNumber = aadharCardNumber;
    }

    public Object getAbout() {
        return about;
    }

    public void setAbout(Object about) {
        this.about = about;
    }

    public String getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
    }

    public long getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(Integer mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public String getFacebookLink() {
        return facebookLink;
    }

    public void setFacebookLink(String facebookLink) {
        this.facebookLink = facebookLink;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getClassPromotionStatus() {
        return classPromotionStatus;
    }

    public void setClassPromotionStatus(String classPromotionStatus) {
        this.classPromotionStatus = classPromotionStatus;
    }

    public String getClassCurrentYear() {
        return classCurrentYear;
    }

    public void setClassCurrentYear(String classCurrentYear) {
        this.classCurrentYear = classCurrentYear;
    }

    public String getClassNextYear() {
        return classNextYear;
    }

    public void setClassNextYear(String classNextYear) {
        this.classNextYear = classNextYear;
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

    public Integer getUser() {
        return user;
    }

    public void setUser(Integer user) {
        this.user = user;
    }

    public Integer getInstitute() {
        return institute;
    }

    public void setInstitute(Integer institute) {
        this.institute = institute;
    }

    public Integer getDesignation() {
        return designation;
    }

    public void setDesignation(Integer designation) {
        this.designation = designation;
    }

    public Integer get_class() {
        return _class;
    }

    public void set_class(Integer _class) {
        this._class = _class;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
