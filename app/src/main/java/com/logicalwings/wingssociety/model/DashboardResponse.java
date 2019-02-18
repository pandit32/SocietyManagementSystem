package com.logicalwings.wingssociety.model;

import com.google.gson.annotations.SerializedName;

public class DashboardResponse extends BaseModel {

    @SerializedName("Data")
    private Dashboard data;

    public Dashboard getData() {
        return data;
    }

    public void setData(Dashboard data) {
        this.data = data;
    }
}
