package com.cosmo.arquitecturamvpbase.views.taller;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.cosmo.arquitecturamvpbase.R;
import com.cosmo.arquitecturamvpbase.model.taller_model.Contact_Model;
import com.cosmo.arquitecturamvpbase.presenter.taller_presenter.Contact_Presenter;
import com.cosmo.arquitecturamvpbase.views.BaseActivity;
import com.cosmo.arquitecturamvpbase.views.activities.adapter.ContactAdapter;

import java.util.ArrayList;

public class ContactActivity extends BaseActivity<Contact_Presenter> implements IContactView {

    private ListView contactListView;
    private ContactAdapter contactAdapter;
    private ContentLoadingProgressBar progress;
    private FloatingActionButton buttonLaunchCreate;

    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_list);
        setPresenter(new Contact_Presenter());
        getPresenter().inject(this, getValidateInternet());
        createProgressDialog();
        contactListView = (ListView) findViewById(R.id.contact_listView);
 //       progress = (ContentLoadingProgressBar) findViewById(R.id.progress);
//        progress.show();
        getPresenter().createContactThread();
        loadEvents();
        //UpdateProduct();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        getPresenter().createContactThread();
    }

    private void loadEvents() {
        buttonLaunchCreate = (FloatingActionButton) findViewById(R.id.createContact);
        buttonLaunchCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ContactActivity.this, CreateContactActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
//        progress.show();
        getPresenter().createContactThread();
    }

    @Override
    public void showContactList(final ArrayList<Contact_Model> customers) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
//                progress.hide();
                //metodo clase adapter
                callAdapter(customers);
            }
        });
    }


    public void showUpdateProduct(final ArrayList<Contact_Model> productArrayList) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                progress.hide();
                //updateContact(productArrayList);
            }
        });
    }

    @Override
    public void showAlertDialogInternet(final int title, final int message) {
        showAlertDialog(title, getResources().getString(message));

    }

    private void showAlertDialog(final int title, final String message) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                getShowAlertDialog().showAlertDialog(title, message, false, R.string.accept, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        getPresenter().createContactThread();
                    }
                }, R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
            }
        });
    }

    @Override
    public void showAlertError(int title, String message) {
        showAlertDialog(title, message);
    }

    private void callAdapter(final ArrayList<Contact_Model> customers) {
        contactAdapter =  new ContactAdapter(this, R.id.contact_listView, customers);
        contactListView.setAdapter(contactAdapter);
        contactListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Intent intent = new Intent(ContactActivity.this, Contact_Detail.class);
                //intent.putExtra(Constants.ITEM_CONTACT,customers.get(position));
                //startActivity(intent);
                Toast.makeText(ContactActivity.this,"Pendiente por hacer",Toast.LENGTH_SHORT).show();
            }
        });
    }

    /*private void updateContact(final ArrayList<Contact_Model> contactArrayList){
        contactAdapter =  new ContactAdapter(this, R.id.contact_listView, contactArrayList);
        contactListView.setAdapter(contactAdapter);
        contactListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(ContactActivity.this, UpdateProductActivity.class);
                intent.putExtra(Constants.ITEM_PRODUCT,contactArrayList.get(position));
                startActivity(intent);
                return false;
            }
        });
    }*/


}
