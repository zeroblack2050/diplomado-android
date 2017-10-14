package com.cosmo.arquitecturamvpbase.views.taller;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;
import android.widget.Toast;

import com.cosmo.arquitecturamvpbase.R;
import com.cosmo.arquitecturamvpbase.helper.Constants;
import com.cosmo.arquitecturamvpbase.model.taller_model.ContactModel;
import com.cosmo.arquitecturamvpbase.model.taller_model.Locationj;
import com.cosmo.arquitecturamvpbase.model.taller_model.PhoneList;
import com.cosmo.arquitecturamvpbase.presenter.taller_presenter.DetailContactPresenter;
import com.cosmo.arquitecturamvpbase.repository.taller_repository.Contact_Repository;
import com.cosmo.arquitecturamvpbase.views.BaseActivity;

import java.util.ArrayList;

/**
 * Created by jasmany on 4/10/2017.
 */

public class Contact_Detail extends BaseActivity<DetailContactPresenter> implements IDetailContactView {

    private TextView contactname, contactsurname;
    private TextView phonedescription, phonenumber;
    private TextView locationtype , locationcordinate;
    private ContactModel contact_model;
    private ArrayList<PhoneList> getPhone;
    private Locationj locationj;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceStat) {
        super.onCreate(savedInstanceStat);
        setContentView(R.layout.activity_contact_detail);
        setPresenter(new DetailContactPresenter(new Contact_Repository()));
        getPresenter().inject(this, getValidateInternet());
        createProgressDialog();
        loadView();
        contact_model = (ContactModel) getIntent().getSerializableExtra(Constants.ITEM_CONTACT);
        setDataItem();

    }

    private void setDataItem() {

        contactname.setText(contact_model.getName());
        contactsurname.setText(contact_model.getUserName());
        getPhone = contact_model.getPhoneList();
        phonenumber.setText(getPhone.get(0).getNumber().toString());

        locationj = getPhone.get(1).getLocation();

        Double[] testpersonal = new Double[2];
        testpersonal = getPhone.get(0).getLocation().getCoordinateslocation();

        locationtype.setText(locationj.getTypelocation().toString());
        String loca = ""+testpersonal[0]+","+testpersonal[1];
        locationcordinate.setText(loca);
    }

    private void loadView() {

        contactname = (TextView) findViewById(R.id.consult_contact_name);
        contactsurname =(TextView) findViewById(R.id.consult_contact_username);
        phonenumber = (TextView) findViewById(R.id.consult_contact_number);
        locationtype =(TextView) findViewById(R.id.consult_contact_type);
        locationcordinate = (TextView) findViewById(R.id.consult_contact_cordinates);



    }


    @Override
    public void showToast(final int message) {

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(Contact_Detail.this, message, Toast.LENGTH_SHORT).show();
                finish();
            }
        });

    }

    @Override
    public void showToast(final String message) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(Contact_Detail.this, message, Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }


    /*public void deleteContactOne(View view){
        getPresenter().deleteContactOne(contact_model.getId());
    }*/
}
