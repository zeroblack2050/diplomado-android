package com.cosmo.arquitecturamvpbase.repository.taller_repository;

import com.cosmo.arquitecturamvpbase.helper.ServicesFactory;
import com.cosmo.arquitecturamvpbase.model.taller_model.ContactModel;
import com.cosmo.arquitecturamvpbase.services.taller_services.Contact_Services_interface;
import java.util.ArrayList;

/**
 * Created by Superadmin1 on 03/10/2017.
 */

public class Contact_Repository implements ContactRepository_interface {

    private Contact_Services_interface contact_services_interface;

    public Contact_Repository() {
        ServicesFactory servicesFactory = new ServicesFactory();
        contact_services_interface = (Contact_Services_interface)
                servicesFactory.getInstance(Contact_Services_interface.class);
    }

    @Override
    public ArrayList<ContactModel> getContactList(){
        ArrayList<ContactModel> getContacts = contact_services_interface.getContactList();
        return getContacts;
    }

    @Override
    public ContactModel createContact(ContactModel contact_model) {
        ContactModel createContact = contact_services_interface.createContact(contact_model);
        return createContact;
    }
}
