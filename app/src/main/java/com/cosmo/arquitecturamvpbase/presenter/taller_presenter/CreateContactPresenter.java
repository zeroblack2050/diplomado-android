package com.cosmo.arquitecturamvpbase.presenter.taller_presenter;

import com.cosmo.arquitecturamvpbase.R;
import com.cosmo.arquitecturamvpbase.model.taller_model.ContactModel;
import com.cosmo.arquitecturamvpbase.presenter.BasePresenter;
import com.cosmo.arquitecturamvpbase.repository.taller_repository.Contact_Repository;
import com.cosmo.arquitecturamvpbase.views.taller.ICreateContactView;

import retrofit.RetrofitError;

/**
 * Created by jersonsuaza on 9/19/17.
 */

public class CreateContactPresenter extends BasePresenter<ICreateContactView> {

    private Contact_Repository contact_repository;

    public CreateContactPresenter(){
        contact_repository = new Contact_Repository();
    }

    public void createNewContact(ContactModel contact_model) {
        if (getValidateInternet().isConnected()){
            createThreadCreateContact(contact_model);
        }else{
            getView().showAlertInternet(R.string.error, R.string.validate_internet);
        }
    }

    public void createThreadCreateContact(final ContactModel contact_model) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                createNewContactService(contact_model);
            }
        });
        thread.start();
    }

    public void createNewContactService(ContactModel contact_model){
        try{
            contact_repository.createContact(contact_model);
            getView().showResultCreateNewContact(true);
        }catch (RetrofitError retrofitError){
            getView().showResultCreateNewContact(false);
        }
    }

}
