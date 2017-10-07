package com.cosmo.arquitecturamvpbase.presenter.taller_presenter;

import com.cosmo.arquitecturamvpbase.R;
import com.cosmo.arquitecturamvpbase.helper.IValidateInternet;
import com.cosmo.arquitecturamvpbase.model.taller_model.Contact_Model;
import com.cosmo.arquitecturamvpbase.repository.taller_repository.ContactRepository_interface;
import com.cosmo.arquitecturamvpbase.repository.taller_repository.Contact_Repository;
import com.cosmo.arquitecturamvpbase.views.taller.ContactActivity;
import com.cosmo.arquitecturamvpbase.views.taller.IContactView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by Superadmin1 on 03/10/2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class Contact_PresenterTest {

    @Mock   private Contact_Model contact_model;
    @Mock   private Contact_Presenter contact_presenter;
    @Mock   private IContactView iContactView;
    @Mock   private IValidateInternet iValidateInternet;
    @Mock   private ContactRepository_interface contactRepository_interface;

    @Before public void SetUp(){

        contact_presenter = Mockito.spy(new Contact_Presenter());
        contact_presenter.inject(iContactView,iValidateInternet);

    }

    @Test   public void shouldCallCreateContactThreadWhenInternetIsOn(){
        when(iValidateInternet.isConnected()).thenReturn(true);
        contact_presenter.PresConsultContact();
        verify(contact_presenter).createThreadConsultContact();
        verify(iContactView, never()).showAlertDialogInternet(R.string.error, R.string.validate_internet);

    }

    @Test   public void shouldCallCreateContactThreadWhenInternetIsOff(){
        when(iValidateInternet.isConnected()).thenReturn(false);
        contact_presenter.PresConsultContact();
        verify(iContactView).showAlertDialogInternet(R.string.error, R.string.validate_internet);
        verify(contact_presenter, never()).createThreadConsultContact();
    }

    @Test   public void shouldCallMethodGetListWhenCreateThreadConsultIsCalled(){
        contact_presenter.createThreadConsultContact();
        verify(contact_presenter).getContactList();
    }


}