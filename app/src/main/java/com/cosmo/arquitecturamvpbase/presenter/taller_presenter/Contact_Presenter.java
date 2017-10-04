package com.cosmo.arquitecturamvpbase.presenter.taller_presenter;

import com.cosmo.arquitecturamvpbase.R;
import com.cosmo.arquitecturamvpbase.model.Product;
import com.cosmo.arquitecturamvpbase.model.taller_model.Contact_Model;
import com.cosmo.arquitecturamvpbase.presenter.BasePresenter;
import com.cosmo.arquitecturamvpbase.repository.MapperError;
import com.cosmo.arquitecturamvpbase.repository.RepositoryError;
import com.cosmo.arquitecturamvpbase.repository.taller_repository.Contact_Repository;
import com.cosmo.arquitecturamvpbase.views.activities.IProductView;
import com.cosmo.arquitecturamvpbase.views.taller.ContactActivity_View;
import com.cosmo.arquitecturamvpbase.views.taller.ContactActivity_interface;

import java.util.ArrayList;

import retrofit.RetrofitError;

/**
 * Created by Superadmin1 on 03/10/2017.
 */

public class Contact_Presenter extends BasePresenter<IProductView> {

    private Contact_Repository contact_repository;

    public Contact_Presenter() {
        contact_repository = new Contact_Repository();
    }

    public void getListProduct() {
        if (getValidateInternet().isConnected()) {
            createThreadProduct();
        } else {
            getView().showAlertDialogInternet(R.string.error, R.string.validate_internet);
        }
    }

    private void createThreadProduct() {
        // getView().showProgress(R.string.loading_message);
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                getProductList();
            }
        });
        thread.start();
    }

    private void getProductList() {

        try {
            ArrayList<Product> productArrayList = productRepository.getProductList();
            getView().showProductList(productArrayList);

        } catch (RetrofitError retrofitError) {

            RepositoryError repositoryError = MapperError.convertRetrofitErrorToRepositoryError(retrofitError);
            getView().showAlertError(R.string.error, repositoryError.getMessage());

        }/*finally {
            getView().hideProgress();
        }*/
    }
}
