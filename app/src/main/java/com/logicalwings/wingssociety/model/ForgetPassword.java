package com.logicalwings.wingssociety.model;

import com.google.gson.annotations.SerializedName;

public class ForgetPassword {

	@SerializedName("EffectiveMonthandYear")
	private Object effectiveMonthandYear;

	@SerializedName("IsDeleted")
	private boolean isDeleted;

	@SerializedName("Email")
	private String email;

	@SerializedName("CreatedBy")
	private int createdBy;

	@SerializedName("IsHide")
	private boolean isHide;

	@SerializedName("FirstName")
	private Object firstName;

	@SerializedName("FlatId")
	private int flatId;

	@SerializedName("IsActive")
	private boolean isActive;

	@SerializedName("EffectiveMaintanenceMonthandYear")
	private Object effectiveMaintanenceMonthandYear;

	@SerializedName("AdultCountabove18")
	private Object adultCountabove18;

	@SerializedName("ChildCountbelow5")
	private Object childCountbelow5;

	@SerializedName("Gender")
	private Object gender;

	@SerializedName("ChildCountabove5")
	private Object childCountabove5;

	@SerializedName("MobileNumber")
	private Object mobileNumber;

	@SerializedName("Remarks")
	private Object remarks;

	@SerializedName("ModifyDate")
	private Object modifyDate;

	@SerializedName("Flat")
	private Object flat;

	@SerializedName("CreatedDate")
	private String createdDate;

	@SerializedName("LastName")
	private Object lastName;

	@SerializedName("Id")
	private int id;

	@SerializedName("ModifyBy")
	private Object modifyBy;

	@SerializedName("ForgotPasswordVerificationTokan")
	private int forgotPasswordVerificationTokan;

	@SerializedName("Password")
	private Object password;

	public void setEffectiveMonthandYear(Object effectiveMonthandYear){
		this.effectiveMonthandYear = effectiveMonthandYear;
	}

	public Object getEffectiveMonthandYear(){
		return effectiveMonthandYear;
	}

	public void setIsDeleted(boolean isDeleted){
		this.isDeleted = isDeleted;
	}

	public boolean isIsDeleted(){
		return isDeleted;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getEmail(){
		return email;
	}

	public void setCreatedBy(int createdBy){
		this.createdBy = createdBy;
	}

	public int getCreatedBy(){
		return createdBy;
	}

	public void setIsHide(boolean isHide){
		this.isHide = isHide;
	}

	public boolean isIsHide(){
		return isHide;
	}

	public void setFirstName(Object firstName){
		this.firstName = firstName;
	}

	public Object getFirstName(){
		return firstName;
	}

	public void setFlatId(int flatId){
		this.flatId = flatId;
	}

	public int getFlatId(){
		return flatId;
	}

	public void setIsActive(boolean isActive){
		this.isActive = isActive;
	}

	public boolean isIsActive(){
		return isActive;
	}

	public void setEffectiveMaintanenceMonthandYear(Object effectiveMaintanenceMonthandYear){
		this.effectiveMaintanenceMonthandYear = effectiveMaintanenceMonthandYear;
	}

	public Object getEffectiveMaintanenceMonthandYear(){
		return effectiveMaintanenceMonthandYear;
	}

	public void setAdultCountabove18(Object adultCountabove18){
		this.adultCountabove18 = adultCountabove18;
	}

	public Object getAdultCountabove18(){
		return adultCountabove18;
	}

	public void setChildCountbelow5(Object childCountbelow5){
		this.childCountbelow5 = childCountbelow5;
	}

	public Object getChildCountbelow5(){
		return childCountbelow5;
	}

	public void setGender(Object gender){
		this.gender = gender;
	}

	public Object getGender(){
		return gender;
	}

	public void setChildCountabove5(Object childCountabove5){
		this.childCountabove5 = childCountabove5;
	}

	public Object getChildCountabove5(){
		return childCountabove5;
	}

	public void setMobileNumber(Object mobileNumber){
		this.mobileNumber = mobileNumber;
	}

	public Object getMobileNumber(){
		return mobileNumber;
	}

	public void setRemarks(Object remarks){
		this.remarks = remarks;
	}

	public Object getRemarks(){
		return remarks;
	}

	public void setModifyDate(Object modifyDate){
		this.modifyDate = modifyDate;
	}

	public Object getModifyDate(){
		return modifyDate;
	}

	public void setFlat(Object flat){
		this.flat = flat;
	}

	public Object getFlat(){
		return flat;
	}

	public void setCreatedDate(String createdDate){
		this.createdDate = createdDate;
	}

	public String getCreatedDate(){
		return createdDate;
	}

	public void setLastName(Object lastName){
		this.lastName = lastName;
	}

	public Object getLastName(){
		return lastName;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setModifyBy(Object modifyBy){
		this.modifyBy = modifyBy;
	}

	public Object getModifyBy(){
		return modifyBy;
	}

	public void setForgotPasswordVerificationTokan(int forgotPasswordVerificationTokan){
		this.forgotPasswordVerificationTokan = forgotPasswordVerificationTokan;
	}

	public int getForgotPasswordVerificationTokan(){
		return forgotPasswordVerificationTokan;
	}

	public void setPassword(Object password){
		this.password = password;
	}

	public Object getPassword(){
		return password;
	}

	@Override
 	public String toString(){
		return 
			"ForgetPassword{" + 
			"effectiveMonthandYear = '" + effectiveMonthandYear + '\'' + 
			",isDeleted = '" + isDeleted + '\'' + 
			",email = '" + email + '\'' + 
			",createdBy = '" + createdBy + '\'' + 
			",isHide = '" + isHide + '\'' + 
			",firstName = '" + firstName + '\'' + 
			",flatId = '" + flatId + '\'' + 
			",isActive = '" + isActive + '\'' + 
			",effectiveMaintanenceMonthandYear = '" + effectiveMaintanenceMonthandYear + '\'' + 
			",adultCountabove18 = '" + adultCountabove18 + '\'' + 
			",childCountbelow5 = '" + childCountbelow5 + '\'' + 
			",gender = '" + gender + '\'' + 
			",childCountabove5 = '" + childCountabove5 + '\'' + 
			",mobileNumber = '" + mobileNumber + '\'' + 
			",remarks = '" + remarks + '\'' + 
			",modifyDate = '" + modifyDate + '\'' + 
			",flat = '" + flat + '\'' + 
			",createdDate = '" + createdDate + '\'' + 
			",lastName = '" + lastName + '\'' + 
			",id = '" + id + '\'' + 
			",modifyBy = '" + modifyBy + '\'' + 
			",forgotPasswordVerificationTokan = '" + forgotPasswordVerificationTokan + '\'' + 
			",password = '" + password + '\'' + 
			"}";
		}
}