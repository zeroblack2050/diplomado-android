package com.cosmo.arquitecturamvpbase.views.taller;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.cosmo.arquitecturamvpbase.R;
import com.cosmo.arquitecturamvpbase.helper.Constants;
import com.cosmo.arquitecturamvpbase.model.Product;
import com.cosmo.arquitecturamvpbase.model.taller_model.Contact_Model;
import com.cosmo.arquitecturamvpbase.model.taller_model.Location;
import com.cosmo.arquitecturamvpbase.model.taller_model.PhoneList;
import com.cosmo.arquitecturamvpbase.presenter.taller_presenter.DetailContactPresenter;
import com.cosmo.arquitecturamvpbase.repository.taller_repository.Contact_Repository;
import com.cosmo.arquitecturamvpbase.views.BaseActivity;
import com.cosmo.arquitecturamvpbase.views.activities.DetailActivity;

/**
 * Created by jasmany on 4/10/2017.
 */

public class Contact_Detail extends BaseActivity<DetailContactPresenter> implements IDetailContactView {

    private TextView contactname, contactusername;
    private TextView phonedescription, phonenumber;
    private TextView locationtype , locationcordinate;
    //private Double [] locationcordinate;
    private Contact_Model contact_model;
    private PhoneList phoneList;
    private Location location;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceStat) {
        super.onCreate(savedInstanceStat);
        setContentView(R.layout.activity_product_detail);
        setPresenter(new DetailContactPresenter(new Contact_Repository()));
        getPresenter().inject(this, getValidateInternet());
        createProgressDialog();
        loadView();
        contact_model = (Contact_Model) getIntent().getSerializableExtra(Constants.ITEM_CONTACT);
        phoneList = (PhoneList) getIntent().getSerializableExtra(Constants.ITEM_CONTACT);
        location = (Location) getIntent().getSerializableExtra(Constants.ITEM_CONTACT);
        setDataItem();

    }

    private void setDataItem() {
        contactname.setText(contact_model.getName());
        contactusername.setText(contact_model.getUserName());

        //phonedescription.setText(phoneList.getDescription());
        //phonenumber.setText(phoneList.getNumber());

        //locationtype.setText(location.getType());
        //locationcordinate.setText(location.getCoordinates().toString());
    }

    private void loadView() {


        contactname = (TextView) findViewById(R.id.product_detail_name_value);
        contactusername =(TextView) findViewById(R.id.product_detail_name_value);
        phonedescription = (TextView) findViewById(R.id.product_detail_name_value);
        phonenumber = (TextView) findViewById(R.id.product_detail_name_value);
        locationtype =(TextView) findViewById(R.id.product_detail_name_value);
        locationcordinate = (TextView) findViewById(R.id.product_detail_name_value);



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


    /*public void deleteProduct(View view){
        getPresenter().deleteProduct(contact_model.getId());
    }*/
}
