package com.logicalwings.wingssociety.model;

import com.google.gson.annotations.SerializedName;

public class User{

	@SerializedName("gender")
	private String gender;

	@SerializedName("userFullName")
	private String userFullName;

	@SerializedName("IsAllowLoginAsUser")
	private String isAllowLoginAsUser;

	@SerializedName(".expires")
	private String expires;

	@SerializedName("token_type")
	private String tokenType;

	@SerializedName("userid")
	private String userid;

	@SerializedName("wingId")
	private String wingId;

	@SerializedName(".issued")
	private String issued;

	@SerializedName("access_token")
	private String accessToken;

	@SerializedName("isRedirectToDashboard")
	private String isRedirectToDashboard;

	@SerializedName("dateTimeFormat")
	private String dateTimeFormat;

	@SerializedName("flatNo")
	private String flatNo;

	@SerializedName("flatId")
	private String flatId;

	@SerializedName("LoginType")
	private String loginType;

	@SerializedName("expires_in")
	private int expiresIn;

	public void setGender(String gender){
		this.gender = gender;
	}

	public String getGender(){
		return gender;
	}

	public void setUserFullName(String userFullName){
		this.userFullName = userFullName;
	}

	public String getUserFullName(){
		return userFullName;
	}

	public void setIsAllowLoginAsUser(String isAllowLoginAsUser){
		this.isAllowLoginAsUser = isAllowLoginAsUser;
	}

	public String getIsAllowLoginAsUser(){
		return isAllowLoginAsUser;
	}

	public void setExpires(String expires){
		this.expires = expires;
	}

	public String getExpires(){
		return expires;
	}

	public void setTokenType(String tokenType){
		this.tokenType = tokenType;
	}

	public String getTokenType(){
		return tokenType;
	}

	public void setUserid(String userid){
		this.userid = userid;
	}

	public String getUserid(){
		return userid;
	}

	public void setWingId(String wingId){
		this.wingId = wingId;
	}

	public String getWingId(){
		return wingId;
	}

	public void setIssued(String issued){
		this.issued = issued;
	}

	public String getIssued(){
		return issued;
	}

	public void setAccessToken(String accessToken){
		this.accessToken = accessToken;
	}

	public String getAccessToken(){
		return accessToken;
	}

	public void setIsRedirectToDashboard(String isRedirectToDashboard){
		this.isRedirectToDashboard = isRedirectToDashboard;
	}

	public String getIsRedirectToDashboard(){
		return isRedirectToDashboard;
	}

	public void setDateTimeFormat(String dateTimeFormat){
		this.dateTimeFormat = dateTimeFormat;
	}

	public String getDateTimeFormat(){
		return dateTimeFormat;
	}

	public void setFlatNo(String flatNo){
		this.flatNo = flatNo;
	}

	public String getFlatNo(){
		return flatNo;
	}

	public void setFlatId(String flatId){
		this.flatId = flatId;
	}

	public String getFlatId(){
		return flatId;
	}

	public void setLoginType(String loginType){
		this.loginType = loginType;
	}

	public String getLoginType(){
		return loginType;
	}

	public void setExpiresIn(int expiresIn){
		this.expiresIn = expiresIn;
	}

	public int getExpiresIn(){
		return expiresIn;
	}

	@Override
 	public String toString(){
		return 
			"User{" + 
			"gender = '" + gender + '\'' + 
			",userFullName = '" + userFullName + '\'' + 
			",isAllowLoginAsUser = '" + isAllowLoginAsUser + '\'' + 
			",.expires = '" + expires + '\'' + 
			",token_type = '" + tokenType + '\'' + 
			",userid = '" + userid + '\'' + 
			",wingId = '" + wingId + '\'' + 
			",.issued = '" + issued + '\'' + 
			",access_token = '" + accessToken + '\'' + 
			",isRedirectToDashboard = '" + isRedirectToDashboard + '\'' + 
			",dateTimeFormat = '" + dateTimeFormat + '\'' + 
			",flatNo = '" + flatNo + '\'' + 
			",flatId = '" + flatId + '\'' + 
			",loginType = '" + loginType + '\'' + 
			",expires_in = '" + expiresIn + '\'' + 
			"}";
		}
}