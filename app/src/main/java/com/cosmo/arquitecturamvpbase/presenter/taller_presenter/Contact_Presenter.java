package com.cosmo.arquitecturamvpbase.presenter.taller_presenter;

import com.cosmo.arquitecturamvpbase.model.taller_model.ContactModel;
import com.cosmo.arquitecturamvpbase.presenter.BasePresenter;
import com.cosmo.arquitecturamvpbase.repository.taller_repository.ContactRepository_interface;
import com.cosmo.arquitecturamvpbase.repository.taller_repository.Contact_Repository;
import com.cosmo.arquitecturamvpbase.views.taller.IContactView;

import java.util.ArrayList;

import retrofit.RetrofitError;

/**
 * Created by Superadmin1 on 03/10/2017.
 */

public class Contact_Presenter extends BasePresenter<IContactView> {

    private ContactRepository_interface contact_repository;

    public Contact_Presenter() {
        contact_repository = new Contact_Repository();
    }



    public void PresConsultContact() {
        //if (getValidateInternet().isConnected()) {
            createThreadConsultContact();
        //} else {
            //getView().showAlertDialogInternet(R.string.error, R.string.validate_internet);
        //}
    }

    public void createThreadConsultContact() {
        //getView().showProgress(R.string.loading_message);
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                getContactList();
            }
        });
        thread.start();
    }

    public void getContactList() {

        try {
            //Log.e("Error","Entro aqui");
            ArrayList<ContactModel> customers = contact_repository.getContactList();
            getView().showContactList(customers);

        } catch (RetrofitError retrofitError) {
                retrofitError.printStackTrace();
            //RepositoryError repositoryError = MapperError.convertRetrofitErrorToRepositoryError(retrofitError);
            //getView().showAlertError(R.string.error, repositoryError.getMessage());

        }/*finally {
            getView().hideProgress();
        }*/
    }
}
