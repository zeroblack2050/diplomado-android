package com.cosmo.arquitecturamvpbase.model.taller_model;

import android.location.Location;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

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
    private ArrayList phoneList;

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

    public ArrayList getPhoneList() {
        return phoneList;
    }

    public void setPhoneList(ArrayList phoneList) {
        this.phoneList = phoneList;
    }
}
