package com.cosmo.arquitecturamvpbase.presenter.taller_presenter;

import com.cosmo.arquitecturamvpbase.model.taller_model.Contact_Model;
import com.cosmo.arquitecturamvpbase.views.taller.ContactActivity_View;
import com.cosmo.arquitecturamvpbase.views.taller.ContactActivity_interface;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;

/**
 * Created by Superadmin1 on 03/10/2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class Contact_PresenterTest {

    @Mock   private Contact_Model contact_model;
    @Mock   private ContactPresenter_interface contact_presenter;
    @Mock   private ContactActivity_interface contactActivity_view;

    @Before public void SetUp(){

    }


}