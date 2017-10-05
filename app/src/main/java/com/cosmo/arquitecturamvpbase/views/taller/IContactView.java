package com.cosmo.arquitecturamvpbase.views.taller;

import com.cosmo.arquitecturamvpbase.model.Product;
import com.cosmo.arquitecturamvpbase.model.taller_model.Contact_Model;
import com.cosmo.arquitecturamvpbase.views.IBaseView;

import java.util.ArrayList;

/**
 * Created by jasmany on 4/10/2017.
 */

public interface IContactView extends IBaseView{

    void showContactList(ArrayList<Contact_Model> productArrayList);

    void showAlertDialogInternet(int title, int message);

    void showAlertError(int title, String message);
}
