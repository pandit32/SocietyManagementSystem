package com.logicalwings.wingssociety.model;

import com.google.gson.annotations.SerializedName;

public class MeetingListItem{

	@SerializedName("IsDeleted")
	private boolean isDeleted;

	@SerializedName("IsActive1")
	private boolean isActive1;

	@SerializedName("CreatedBy")
	private int createdBy;

	@SerializedName("IsActive")
	private boolean isActive;

	@SerializedName("CreatedBy1")
	private int createdBy1;

	@SerializedName("IsDeleted1")
	private boolean isDeleted1;

	@SerializedName("ModifyBy1")
	private int modifyBy1;

	@SerializedName("RoleId")
	private int roleId;

	@SerializedName("DateTime")
	private String dateTime;

	@SerializedName("CreatedDate1")
	private String createdDate1;

	@SerializedName("ModifyDate1")
	private String modifyDate1;

	@SerializedName("Remarks")
	private String remarks;

	@SerializedName("ModifyDate")
	private String modifyDate;

	@SerializedName("Id1")
	private int id1;

	@SerializedName("CreatedDate")
	private String createdDate;

	@SerializedName("MeetingId")
	private int meetingId;

	@SerializedName("MeetingTypeId")
	private int meetingTypeId;

	@SerializedName("Id")
	private int id;

	@SerializedName("ModifyBy")
	private int modifyBy;

	@SerializedName("Topic")
	private String topic;

	@SerializedName("Remarks1")
	private Object remarks1;

	public void setIsDeleted(boolean isDeleted){
		this.isDeleted = isDeleted;
	}

	public boolean isIsDeleted(){
		return isDeleted;
	}

	public void setIsActive1(boolean isActive1){
		this.isActive1 = isActive1;
	}

	public boolean isIsActive1(){
		return isActive1;
	}

	public void setCreatedBy(int createdBy){
		this.createdBy = createdBy;
	}

	public int getCreatedBy(){
		return createdBy;
	}

	public void setIsActive(boolean isActive){
		this.isActive = isActive;
	}

	public boolean isIsActive(){
		return isActive;
	}

	public void setCreatedBy1(int createdBy1){
		this.createdBy1 = createdBy1;
	}

	public int getCreatedBy1(){
		return createdBy1;
	}

	public void setIsDeleted1(boolean isDeleted1){
		this.isDeleted1 = isDeleted1;
	}

	public boolean isIsDeleted1(){
		return isDeleted1;
	}

	public void setModifyBy1(int modifyBy1){
		this.modifyBy1 = modifyBy1;
	}

	public int getModifyBy1(){
		return modifyBy1;
	}

	public void setRoleId(int roleId){
		this.roleId = roleId;
	}

	public int getRoleId(){
		return roleId;
	}

	public void setDateTime(String dateTime){
		this.dateTime = dateTime;
	}

	public String getDateTime(){
		return dateTime;
	}

	public void setCreatedDate1(String createdDate1){
		this.createdDate1 = createdDate1;
	}

	public String getCreatedDate1(){
		return createdDate1;
	}

	public void setModifyDate1(String modifyDate1){
		this.modifyDate1 = modifyDate1;
	}

	public String getModifyDate1(){
		return modifyDate1;
	}

	public void setRemarks(String remarks){
		this.remarks = remarks;
	}

	public String getRemarks(){
		return remarks;
	}

	public void setModifyDate(String modifyDate){
		this.modifyDate = modifyDate;
	}

	public String getModifyDate(){
		return modifyDate;
	}

	public void setId1(int id1){
		this.id1 = id1;
	}

	public int getId1(){
		return id1;
	}

	public void setCreatedDate(String createdDate){
		this.createdDate = createdDate;
	}

	public String getCreatedDate(){
		return createdDate;
	}

	public void setMeetingId(int meetingId){
		this.meetingId = meetingId;
	}

	public int getMeetingId(){
		return meetingId;
	}

	public void setMeetingTypeId(int meetingTypeId){
		this.meetingTypeId = meetingTypeId;
	}

	public int getMeetingTypeId(){
		return meetingTypeId;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setModifyBy(int modifyBy){
		this.modifyBy = modifyBy;
	}

	public int getModifyBy(){
		return modifyBy;
	}

	public void setTopic(String topic){
		this.topic = topic;
	}

	public String getTopic(){
		return topic;
	}

	public void setRemarks1(Object remarks1){
		this.remarks1 = remarks1;
	}

	public Object getRemarks1(){
		return remarks1;
	}

	@Override
 	public String toString(){
		return 
			"MeetingListItem{" + 
			"isDeleted = '" + isDeleted + '\'' + 
			",isActive1 = '" + isActive1 + '\'' + 
			",createdBy = '" + createdBy + '\'' + 
			",isActive = '" + isActive + '\'' + 
			",createdBy1 = '" + createdBy1 + '\'' + 
			",isDeleted1 = '" + isDeleted1 + '\'' + 
			",modifyBy1 = '" + modifyBy1 + '\'' + 
			",roleId = '" + roleId + '\'' + 
			",dateTime = '" + dateTime + '\'' + 
			",createdDate1 = '" + createdDate1 + '\'' + 
			",modifyDate1 = '" + modifyDate1 + '\'' + 
			",remarks = '" + remarks + '\'' + 
			",modifyDate = '" + modifyDate + '\'' + 
			",id1 = '" + id1 + '\'' + 
			",createdDate = '" + createdDate + '\'' + 
			",meetingId = '" + meetingId + '\'' + 
			",meetingTypeId = '" + meetingTypeId + '\'' + 
			",id = '" + id + '\'' + 
			",modifyBy = '" + modifyBy + '\'' + 
			",topic = '" + topic + '\'' + 
			",remarks1 = '" + remarks1 + '\'' + 
			"}";
		}
}