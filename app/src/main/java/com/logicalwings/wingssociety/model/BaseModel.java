package com.logicalwings.wingssociety.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BaseModel {

    @SerializedName("Success")
    @Expose
    private int success;

    @SerializedName("Message")
    @Expose
    private String message;

    public int getStatuscode() {
        return success;
    }

    public void setStatuscode(int statuscode) {
        this.success = statuscode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
