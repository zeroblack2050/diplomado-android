package com.cosmo.arquitecturamvpbase.model.taller_model;

import android.location.Location;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Superadmin1 on 03/10/2017.
 */

public class PhoneList implements Serializable{

    @SerializedName("description")
    @Expose
    private String description;


    @SerializedName("number")
    @Expose
    private String number;

    @SerializedName("location")
    @Expose
    private Location location;


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
