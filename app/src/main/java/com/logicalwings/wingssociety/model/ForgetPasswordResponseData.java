package com.logicalwings.wingssociety.model;

import com.google.gson.annotations.SerializedName;

public class ForgetPasswordResponseData extends BaseModel{
    @SerializedName("Data")
    private ForgetPassword data;

    public ForgetPassword getData() {
        return data;
    }

    public void setData(ForgetPassword data) {
        this.data = data;
    }
}
