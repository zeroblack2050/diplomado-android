package com.cosmo.arquitecturamvpbase.views.activities.adapter;

import com.cosmo.arquitecturamvpbase.views.IBaseView;

/**
 * Created by jersonsuaza on 9/19/17.
 */

public interface ICreateContactView extends IBaseView {

    void showResultCreateNewProduct(boolean isCreated);

    void showAlertInternet(int title, int message);
}
