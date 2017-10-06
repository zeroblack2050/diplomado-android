package com.cosmo.arquitecturamvpbase.views.taller;

import com.cosmo.arquitecturamvpbase.views.IBaseView;

/**
 * Created by jersonsuaza on 9/19/17.
 */

public interface ICreateContactView extends IBaseView {

    void showResultCreateNewContact(boolean isCreated);

    void showAlertInternet(int title, int message);
}
