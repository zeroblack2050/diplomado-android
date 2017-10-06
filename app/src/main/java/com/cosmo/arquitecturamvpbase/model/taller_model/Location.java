package com.cosmo.arquitecturamvpbase.model.taller_model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Superadmin1 on 03/10/2017.
 */

public class Location implements Serializable{

    @SerializedName("typelocation")
    @Expose
    private String typelocation;


    @SerializedName("coordinateslocation")
    @Expose
    private Double [] coordinateslocation;

    public String getTypelocation() {
        return typelocation;
    }

    public void setTypelocation(String typelocation) {
        this.typelocation = typelocation;
    }

    public Double[] getCoordinateslocation() {
        return coordinateslocation;
    }

    public void setCoordinateslocation(Double[] coordinateslocation) {
        this.coordinateslocation = coordinateslocation;
    }
}
