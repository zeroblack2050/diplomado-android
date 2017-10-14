package com.cosmo.arquitecturamvpbase.presenter.taller_presenter;

import com.cosmo.arquitecturamvpbase.helper.IValidateInternet;
import com.cosmo.arquitecturamvpbase.model.taller_model.ContactModel;
import com.cosmo.arquitecturamvpbase.model.taller_model.Locationj;
import com.cosmo.arquitecturamvpbase.model.taller_model.PhoneList;
import com.cosmo.arquitecturamvpbase.repository.taller_repository.ContactRepository_interface;
import com.cosmo.arquitecturamvpbase.repository.taller_repository.Contact_Repository;
import com.cosmo.arquitecturamvpbase.views.taller.IDetailContactView;

import org.junit.Before;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;

import static org.mockito.Mockito.verify;

/**
 * Created by jasmany on 7/10/2017.
 */
public class DetailContactPresenterTest {

    @Mock
    private ContactModel contact_model;
    @Mock   private DetailContactPresenter detailContactPresenter;
    @Mock   private IDetailContactView iDetailContactView;
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

    private ContactModel contact_model(){
        ContactModel contact_model = new ContactModel();
        contact_model.setName("jas");
        contact_model.setUserName("jasmany");
        contact_model.setPhoneList(arrayList);
        return contact_model;
    }

    @Before
    public void SetUp(){

        detailContactPresenter= Mockito.spy(new DetailContactPresenter(new Contact_Repository()));
        detailContactPresenter.inject(iDetailContactView,iValidateInternet);
    }

    /*@Test
    public void shouldCallMethodDeleteContactWhenInterneIsOn(){
        String id = "sdad5d5as5";
        when(iValidateInternet.isConnected()).thenReturn(true);
        detailContactPresenter.deleteContactOne(id);
        //verify(detailContactPresenter).createThreadDeleteContact(id);
        //verify(iDetailContactView, never()).showToast(R.string.validate_internet);
    }*/

}