package com.cosmo.arquitecturamvpbase.model.taller_model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Superadmin1 on 03/10/2017.
 */

public class Location implements Serializable{

    @SerializedName("type")
    @Expose
    private String type;


    @SerializedName("coordinates")
    @Expose
    private Double [] coordinates;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double[] getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Double[] coordinates) {
        this.coordinates = coordinates;
    }
}
