package com.cosmo.arquitecturamvpbase.services.taller_services;

import com.cosmo.arquitecturamvpbase.model.taller_model.ContactModel;

import java.util.ArrayList;

import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;

/**
 * Created by Superadmin1 on 03/10/2017.
 */

public interface Contact_Services_interface{

    @GET("/customers")
    ArrayList<ContactModel> getContactList();

    @POST("/customers")
    ContactModel createContact(@Body ContactModel contact_model);
}
