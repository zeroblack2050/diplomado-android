package com.cosmo.arquitecturamvpbase.views.activities.adapter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.cosmo.arquitecturamvpbase.R;
import com.cosmo.arquitecturamvpbase.model.Product;
import com.cosmo.arquitecturamvpbase.model.taller_model.Contact_Model;

import java.util.ArrayList;

/**
 * Created by leidyzulu on 16/09/17.
 */

public class ContactAdapter extends ArrayAdapter<Contact_Model> {

    private ArrayList<Contact_Model> contact_model_adapter;
    private Activity context;
    private Contact_Model contact_model_object;
    private TextView name, username;


    public ContactAdapter(Activity context, int resource, ArrayList<Contact_Model> contact_models) {
        super(context, resource, contact_models);
        this.context = context;
        this.contact_model_adapter = contact_models;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_contact_item, parent, false);
        this.contact_model_object = this.contact_model_adapter.get(position);
        loadView(convertView);
        name.setText(contact_model_object.getName());
        username.setText(contact_model_object.getUserName());
        return convertView;
    }

    private void loadView(View convertView){
        name = (TextView) convertView.findViewById(R.id.item_name_contact);
        username = (TextView) convertView.findViewById(R.id.item_username_contact);
    }
}
