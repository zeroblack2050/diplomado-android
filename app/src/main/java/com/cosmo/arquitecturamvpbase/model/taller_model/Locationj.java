package com.cosmo.arquitecturamvpbase.model.taller_model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Superadmin1 on 03/10/2017.
 */

public class Locationj implements Serializable{

    @SerializedName("type")
    @Expose
    private String typelocation;


    @SerializedName("coordinates")
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
