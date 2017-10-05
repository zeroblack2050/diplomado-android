package com.cosmo.arquitecturamvpbase.repository.taller_repository;

import com.cosmo.arquitecturamvpbase.model.taller_model.Contact_Model;
import java.util.ArrayList;

/**
 * Created by Superadmin1 on 03/10/2017.
 */

public interface ContactRepository_interface {

    ArrayList<Contact_Model> getContactList();

    Contact_Model CreateContact(Contact_Model contact_model);

}
