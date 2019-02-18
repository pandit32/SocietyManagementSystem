package com.logicalwings.wingssociety.model;

import com.google.gson.annotations.SerializedName;

public class LoginRequest{

	@SerializedName("password")
	private int password;

	@SerializedName("mobileDeviceId")
	private Object mobileDeviceId;

	@SerializedName("deviceNotificationToken")
	private Object deviceNotificationToken;

	@SerializedName("grant_type")
	private String grantType;

	@SerializedName("logintype")
	private int logintype;

	@SerializedName("deviceOSType")
	private int deviceOSType;

	@SerializedName("Imei")
	private Object imei;

	@SerializedName("client_id")
	private int clientId;

	@SerializedName("username")
	private String username;

	@SerializedName("mError_description")
	public String errorMessage;

	public void setPassword(int password){
		this.password = password;
	}

	public int getPassword(){
		return password;
	}

	public void setMobileDeviceId(Object mobileDeviceId){
		this.mobileDeviceId = mobileDeviceId;
	}

	public Object getMobileDeviceId(){
		return mobileDeviceId;
	}

	public void setDeviceNotificationToken(Object deviceNotificationToken){
		this.deviceNotificationToken = deviceNotificationToken;
	}

	public Object getDeviceNotificationToken(){
		return deviceNotificationToken;
	}

	public void setGrantType(String grantType){
		this.grantType = grantType;
	}

	public String getGrantType(){
		return grantType;
	}

	public void setLogintype(int logintype){
		this.logintype = logintype;
	}

	public int getLogintype(){
		return logintype;
	}

	public void setDeviceOSType(int deviceOSType){
		this.deviceOSType = deviceOSType;
	}

	public int getDeviceOSType(){
		return deviceOSType;
	}

	public void setImei(Object imei){
		this.imei = imei;
	}

	public Object getImei(){
		return imei;
	}

	public void setClientId(int clientId){
		this.clientId = clientId;
	}

	public int getClientId(){
		return clientId;
	}

	public void setUsername(String username){
		this.username = username;
	}

	public String getUsername(){
		return username;
	}

	@Override
 	public String toString(){
		return 
			"LoginRequest{" + 
			"password = '" + password + '\'' + 
			",mobileDeviceId = '" + mobileDeviceId + '\'' + 
			",deviceNotificationToken = '" + deviceNotificationToken + '\'' + 
			",grant_type = '" + grantType + '\'' + 
			",logintype = '" + logintype + '\'' + 
			",deviceOSType = '" + deviceOSType + '\'' + 
			",imei = '" + imei + '\'' + 
			",client_id = '" + clientId + '\'' + 
			",username = '" + username + '\'' + 
			"}";
		}
}