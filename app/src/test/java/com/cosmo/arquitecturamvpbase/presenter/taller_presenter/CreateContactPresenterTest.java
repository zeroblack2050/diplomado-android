package com.cosmo.arquitecturamvpbase.presenter.taller_presenter;

import com.cosmo.arquitecturamvpbase.R;
import com.cosmo.arquitecturamvpbase.helper.IValidateInternet;
import com.cosmo.arquitecturamvpbase.model.taller_model.Contact_Model;
import com.cosmo.arquitecturamvpbase.model.taller_model.Locationj;
import com.cosmo.arquitecturamvpbase.model.taller_model.PhoneList;
import com.cosmo.arquitecturamvpbase.repository.taller_repository.ContactRepository_interface;
import com.cosmo.arquitecturamvpbase.views.taller.ICreateContactView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;

import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by jasmany on 6/10/2017.
 */

@RunWith(MockitoJUnitRunner.class)
public class CreateContactPresenterTest {

    @Mock   private Contact_Model contact_model;
    @Mock   private CreateContactPresenter createContactPresenter;
    @Mock   private ICreateContactView iCreateContactView;
    @Mock   private IValidateInternet iValidateInternet;
    @Mock   private ContactRepository_interface contactRepository_interface;


    private Locationj locationj(){
        Locationj locationj = new Locationj();
        locationj.setTypelocation("Point");
        locationj.setCoordinateslocation(new Double[]{25D,36D});
        return locationj;
    }

    private PhoneList phoneList(){
        PhoneList phoneList = new PhoneList();
        phoneList.setNumber("300709");
        phoneList.setLocation(locationj());
        return phoneList;
    }
    private ArrayList<PhoneList> arrayList = new ArrayList<>();

    private Contact_Model contact_model(){
        Contact_Model contact_model = new Contact_Model();
        contact_model.setName("jas");
        contact_model.setUserName("jasmany");
        contact_model.setPhoneList(arrayList);
        return contact_model;
    }


    @Before
    public void SetUp(){

        createContactPresenter= Mockito.spy(new CreateContactPresenter());
        createContactPresenter.inject(iCreateContactView,iValidateInternet);
    }

    @Test   public void shouldCallMethodCreateThreadCreateContactWhenInterneIsOn(){
        when(iValidateInternet.isConnected()).thenReturn(true);
        Contact_Model  contact_model = contact_model();
        createContactPresenter.createNewContact(contact_model);
        verify(createContactPresenter).createThreadCreateContact(contact_model);
        verify(iCreateContactView, never()).showAlertInternet(R.string.error, R.string.validate_internet);
    }

    @Test   public void shouldCallMethodcreateThreadCreateContactWhenInternetIsOn(){
        Contact_Model  contact_model = contact_model();
        createContactPresenter.createThreadCreateContact(contact_model);
        verify(createContactPresenter).createNewContactService(contact_model);
    }

}