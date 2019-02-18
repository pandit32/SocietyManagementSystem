package com.logicalwings.wingssociety.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserResponseData extends BaseModel {

    @SerializedName("data")
    @Expose
    private User data;

    public User getData() {
        return data;
    }

    public void setData(User data) {
        this.data = data;
    }
}
