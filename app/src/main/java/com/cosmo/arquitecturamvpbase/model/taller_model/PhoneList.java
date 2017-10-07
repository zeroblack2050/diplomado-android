package com.cosmo.arquitecturamvpbase.model.taller_model;

import android.location.Location;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Superadmin1 on 03/10/2017.
 */

public class PhoneList implements Serializable{


    @SerializedName("number")
    @Expose
    private String number;



    @SerializedName("location")
    @Expose
    private Locationj location;



    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }


    public Locationj getLocation() {
        return location;
    }

    public void setLocation(Locationj location) {
        this.location = location;
    }
}
