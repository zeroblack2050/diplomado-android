package com.cosmo.arquitecturamvpbase.views.activities.adapter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.cosmo.arquitecturamvpbase.R;
import com.cosmo.arquitecturamvpbase.model.taller_model.Contact_Model;

import java.util.ArrayList;

/**
 * Created by leidyzulu on 16/09/17.
 */

public class ContactAdapter extends ArrayAdapter<Contact_Model> {

    private ArrayList<Contact_Model> customers;
    private Activity context;
    private Contact_Model customer;
    private TextView name, username;


    public ContactAdapter(Activity context, int resource, ArrayList<Contact_Model> customers) {
        super(context, resource, customers);
        this.context = context;
        this.customers = customers;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_contact_item, parent, false);
        this.customer = this.customers.get(position);

        Log.d("getContactList", "Size customers::" + customers.size());
        Log.d("getContactList", "Customer::" + customer.getName());
//
//        if (customers.size()>0) {
//            for(Contact_Model test: customers){
//                Log.d("getContactList", "Name::" + test.getName());
//            }
//        }

        loadView(convertView);
        name.setText(customer.getName());
        username.setText(customer.getUserName());
        return convertView;
    }

    private void loadView(View convertView){
        name = (TextView) convertView.findViewById(R.id.item_name_contact);
        username = (TextView) convertView.findViewById(R.id.item_username_contact);
    }
}
