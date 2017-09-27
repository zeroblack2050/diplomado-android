package com.cosmo.arquitecturamvpbase.views.activities;

import com.cosmo.arquitecturamvpbase.model.Product;
import com.cosmo.arquitecturamvpbase.views.IBaseView;

import java.util.ArrayList;

/**
 * Created by jersonsuaza on 9/19/17.
 */

public interface IUpdateProductView extends IBaseView {

    void showProductUpdate(ArrayList<Product> productArrayList);

    void showResultUpdateNewProduct(boolean isCreated);

    void showAlertInternet(int title, int message);
}
