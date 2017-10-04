package com.cosmo.arquitecturamvpbase.model.taller_model;

import android.location.Location;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Superadmin1 on 03/10/2017.
 */

public class Contact_Model implements Serializable{

    @SerializedName("name")
    @Expose
    private String name;


    @SerializedName("username")
    @Expose
    private String userName;


    @SerializedName("phoneList")
    @Expose
    private String [] phoneList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String[] getPhoneList() {
        return phoneList;
    }

    public void setPhoneList(String[] phoneList) {
        this.phoneList = phoneList;
    }
}
