package com.cosmo.arquitecturamvpbase.views.taller;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.cosmo.arquitecturamvpbase.R;
import com.cosmo.arquitecturamvpbase.model.taller_model.Contact_Model;
import com.cosmo.arquitecturamvpbase.model.taller_model.Location;
import com.cosmo.arquitecturamvpbase.model.taller_model.PhoneList;
import com.cosmo.arquitecturamvpbase.presenter.taller_presenter.CreateContactPresenter;
import com.cosmo.arquitecturamvpbase.views.BaseActivity;

import java.util.ArrayList;

/**
 * Created by jersonsuaza on 9/19/17.
 */

public class CreateContactActivity extends BaseActivity<CreateContactPresenter> implements ICreateContactView, TextWatcher {


    private EditText contactName, contacSurname, contactDescription, contactNumero, contactTipo,contactLatitud, contactAltitud;
    private Button product_btnCreate;
    private ContentLoadingProgressBar progress;
    private Location locationprueba;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contactcreate);
        setPresenter(new CreateContactPresenter());
        getPresenter().inject(this, getValidateInternet());
        progress = (ContentLoadingProgressBar) findViewById(R.id.contactcreate_progress);
        progress.hide();
        loadViews();
        loadEvents();
    }

    private void loadViews() {
        contactName = (EditText) findViewById(R.id.contactcreate_name_editex);
        contactName.addTextChangedListener(this);
        contacSurname = (EditText) findViewById(R.id.contactcreate_username_edittex);
        contacSurname.addTextChangedListener(this);


        contactDescription = (EditText) findViewById(R.id.contactcreate_description_edittex);
        contactDescription.addTextChangedListener(this);
        contactNumero = (EditText) findViewById(R.id.contactcreate_number_edittex);
        contactNumero.addTextChangedListener(this);
        contactTipo = (EditText) findViewById(R.id.contactcreate_type_edittex);
        contactTipo.addTextChangedListener(this);

        contactLatitud = (EditText) findViewById(R.id.contactcreate_cordinates_altitud);
        contactLatitud.addTextChangedListener(this);
        contactAltitud = (EditText) findViewById(R.id.contactcreate_cordinates_latitud);
        contactAltitud.addTextChangedListener(this);


        product_btnCreate = (Button) findViewById(R.id.contactcreate_button);
        product_btnCreate.addTextChangedListener(this);
    }

    private void loadEvents(){
        progress.show();
        product_btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Contact_Model contact_model = new Contact_Model();
                contact_model.setName(contactName.getText().toString());
                contact_model.setUserName(contacSurname.getText().toString());

                String descri = contactDescription.getText().toString();
                String nume = contactNumero.getText().toString();
                String tipo = contactTipo.getText().toString();

                String locationlatitud = contactLatitud.getText().toString();
                String locationaltitud = contactAltitud.getText().toString();

                Location loca= new Location();


                //contact_model.setUserName(contactLatitud.getText().toString());
                //contact_model.setUserName(contactAltitud.getText().toString());

                getPresenter().createNewContact(contact_model);
            }
        });
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        if (!contactName.getText().toString().trim().isEmpty() &&
                !contacSurname.getText().toString().trim().isEmpty() &&
                !contactDescription.getText().toString().trim().isEmpty() &&
                !contactNumero.getText().toString().trim().isEmpty() &&
                !contactTipo.getText().toString().trim().isEmpty()&&
                !contactLatitud.getText().toString().trim().isEmpty()&&
                !contactAltitud.getText().toString().trim().isEmpty()) {

            product_btnCreate.setBackgroundResource(R.color.colorPrimary);
            product_btnCreate.setEnabled(true);

        }else{

            product_btnCreate.setBackgroundResource(R.color.colorGray);
            product_btnCreate.setEnabled(false);

        }
    }

    @Override
    public void showResultCreateNewContact(final boolean isCreated) {

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                progress.hide();
                if(isCreated){
                    Toast.makeText(CreateContactActivity.this, getResources().getString(R.string.okResponseCreateProduct), Toast.LENGTH_LONG).show();
                    finish();
                }else{
                    Toast.makeText(CreateContactActivity.this, getResources().getString(R.string.errResponseCreateProduct), Toast.LENGTH_LONG).show();
                }

            }
        });
    }

    @Override
    public void showAlertInternet(final int title, final int message) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(CreateContactActivity.this, R.string.validate_internet, Toast.LENGTH_SHORT).show();
            }
        });
    }

}
