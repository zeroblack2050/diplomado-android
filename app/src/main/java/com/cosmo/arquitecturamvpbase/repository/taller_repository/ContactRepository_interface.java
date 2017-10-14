package com.cosmo.arquitecturamvpbase.repository.taller_repository;

import com.cosmo.arquitecturamvpbase.model.taller_model.ContactModel;

import java.util.ArrayList;

/**
 * Created by Superadmin1 on 03/10/2017.
 */

public interface ContactRepository_interface {

    ArrayList<ContactModel> getContactList();

    ContactModel createContact(ContactModel contact_model);

}
