package com.cosmo.arquitecturamvpbase.repository.taller_repository;

import com.cosmo.arquitecturamvpbase.helper.ServicesFactory;
import com.cosmo.arquitecturamvpbase.model.taller_model.Contact_Model;
import com.cosmo.arquitecturamvpbase.services.taller_services.Contact_Services_interface;
import java.util.ArrayList;

/**
 * Created by Superadmin1 on 03/10/2017.
 */

public class Contact_Repository implements ContactRepository_interface {

    private ContactRepository_interface contactRepository_interface;

    public Contact_Repository() {
        ServicesFactory servicesFactory = new ServicesFactory();
        contactRepository_interface = (ContactRepository_interface)
                servicesFactory.getInstance(Contact_Services_interface.class);
    }

    @Override
    public ArrayList<Contact_Model> getContactList(){
        ArrayList<Contact_Model> getContacts = contactRepository_interface.getContactList();
        return getContacts;
    }

    @Override
    public Contact_Model CreateContact(Contact_Model contact_model) {
        Contact_Model createContact = contactRepository_interface.CreateContact(contact_model);
        return createContact;
    }
}
