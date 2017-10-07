package com.cosmo.arquitecturamvpbase.presenter.taller_presenter;

import com.cosmo.arquitecturamvpbase.R;
import com.cosmo.arquitecturamvpbase.presenter.BasePresenter;
import com.cosmo.arquitecturamvpbase.repository.taller_repository.ContactRepository_interface;
import com.cosmo.arquitecturamvpbase.views.taller.IDetailContactView;

/**
 * Created by jasmany on 4/10/2017.
 */

public class DetailContactPresenter extends BasePresenter<IDetailContactView> {

    private ContactRepository_interface contactRepository_interface;

    public DetailContactPresenter(ContactRepository_interface contactRepository_interface) {
        this.contactRepository_interface = contactRepository_interface;
    }

    public void deleteContactOne(String id) {
        if(getValidateInternet().isConnected()){
            createThreadDeleteContact(id);
        }else{
            getView().showToast(R.string.validate_internet);
        }
    }

    public void createThreadDeleteContact(final String id) {
        //getView().showProgress(R.string.loading_message);
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                //deleteProductRepository(id);
            }
        });
        thread.start();
    }

    /*public void deleteProductRepository(String id) {

        try{
            DeleteResponse deleteResponse = productRepository.deleteContactOne(id);
            if(deleteResponse.isStatus()){
                getView().showToast(R.string.correct);
            }else{
                getView().showToast(R.string.error_delete_product);
            }

        }catch (RepositoryError repositoryError){
            getView().showToast(repositoryError.getMessage());
        }finally {
            getView().hideProgress();
        }

    }*/
}
