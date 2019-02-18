package com.logicalwings.wingssociety.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Dashboard{

	@SerializedName("AvailableFlatCount")
	private int availableFlatCount;

	@SerializedName("FlatId")
	private int flatId;

	@SerializedName("UserCount")
	private int userCount;

	@SerializedName("MeetingList")
	private List<MeetingListItem> meetingList;

	@SerializedName("NextEffectiveAmount")
	private int nextEffectiveAmount;

	@SerializedName("LastPaymentMonth")
	private String lastPaymentMonth;

	@SerializedName("DueCharges")
	private int dueCharges;

	@SerializedName("ComplaintCount")
	private int complaintCount;

	@SerializedName("PaymentDetail")
	private Object paymentDetail;

	@SerializedName("WingCount")
	private int wingCount;

	@SerializedName("WingId")
	private int wingId;

	@SerializedName("NextEffectiveMonth")
	private String nextEffectiveMonth;

	@SerializedName("FlatCount")
	private int flatCount;

	public void setAvailableFlatCount(int availableFlatCount){
		this.availableFlatCount = availableFlatCount;
	}

	public int getAvailableFlatCount(){
		return availableFlatCount;
	}

	public void setFlatId(int flatId){
		this.flatId = flatId;
	}

	public int getFlatId(){
		return flatId;
	}

	public void setUserCount(int userCount){
		this.userCount = userCount;
	}

	public int getUserCount(){
		return userCount;
	}

	public void setMeetingList(List<MeetingListItem> meetingList){
		this.meetingList = meetingList;
	}

	public List<MeetingListItem> getMeetingList(){
		return meetingList;
	}

	public void setNextEffectiveAmount(int nextEffectiveAmount){
		this.nextEffectiveAmount = nextEffectiveAmount;
	}

	public int getNextEffectiveAmount(){
		return nextEffectiveAmount;
	}

	public void setLastPaymentMonth(String lastPaymentMonth){
		this.lastPaymentMonth = lastPaymentMonth;
	}

	public String getLastPaymentMonth(){
		return lastPaymentMonth;
	}

	public void setDueCharges(int dueCharges){
		this.dueCharges = dueCharges;
	}

	public int getDueCharges(){
		return dueCharges;
	}

	public void setComplaintCount(int complaintCount){
		this.complaintCount = complaintCount;
	}

	public int getComplaintCount(){
		return complaintCount;
	}

	public void setPaymentDetail(Object paymentDetail){
		this.paymentDetail = paymentDetail;
	}

	public Object getPaymentDetail(){
		return paymentDetail;
	}

	public void setWingCount(int wingCount){
		this.wingCount = wingCount;
	}

	public int getWingCount(){
		return wingCount;
	}

	public void setWingId(int wingId){
		this.wingId = wingId;
	}

	public int getWingId(){
		return wingId;
	}

	public void setNextEffectiveMonth(String nextEffectiveMonth){
		this.nextEffectiveMonth = nextEffectiveMonth;
	}

	public String getNextEffectiveMonth(){
		return nextEffectiveMonth;
	}

	public void setFlatCount(int flatCount){
		this.flatCount = flatCount;
	}

	public int getFlatCount(){
		return flatCount;
	}

	@Override
 	public String toString(){
		return 
			"Dashboard{" + 
			"availableFlatCount = '" + availableFlatCount + '\'' + 
			",flatId = '" + flatId + '\'' + 
			",userCount = '" + userCount + '\'' + 
			",meetingList = '" + meetingList + '\'' + 
			",nextEffectiveAmount = '" + nextEffectiveAmount + '\'' + 
			",lastPaymentMonth = '" + lastPaymentMonth + '\'' + 
			",dueCharges = '" + dueCharges + '\'' + 
			",complaintCount = '" + complaintCount + '\'' + 
			",paymentDetail = '" + paymentDetail + '\'' + 
			",wingCount = '" + wingCount + '\'' + 
			",wingId = '" + wingId + '\'' + 
			",nextEffectiveMonth = '" + nextEffectiveMonth + '\'' + 
			",flatCount = '" + flatCount + '\'' + 
			"}";
		}
}