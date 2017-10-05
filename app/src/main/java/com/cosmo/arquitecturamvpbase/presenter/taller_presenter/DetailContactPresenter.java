package com.cosmo.arquitecturamvpbase.presenter.taller_presenter;

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
}
