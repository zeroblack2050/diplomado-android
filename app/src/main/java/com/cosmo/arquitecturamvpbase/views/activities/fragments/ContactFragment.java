package com.cosmo.arquitecturamvpbase.views.activities.fragments;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.cosmo.arquitecturamvpbase.R;
import com.cosmo.arquitecturamvpbase.helper.Constants;
import com.cosmo.arquitecturamvpbase.model.taller_model.ContactModel;
import com.cosmo.arquitecturamvpbase.presenter.taller_presenter.Contact_Presenter;
import com.cosmo.arquitecturamvpbase.views.activities.adapter.ContactAdapter;
import com.cosmo.arquitecturamvpbase.views.taller.Contact_Detail;
import com.cosmo.arquitecturamvpbase.views.taller.CreateContactActivity;
import com.cosmo.arquitecturamvpbase.views.taller.IContactView;

import java.util.ArrayList;

/**
 * Created by Superadmin1 on 14/10/2017.
 */

public class ContactFragment extends BaseFragment<Contact_Presenter> implements IContactView {

    private ListView contactListView;
    private ContactAdapter contactAdapter;
    //private ContentLoadingProgressBar progress;
    private FloatingActionButton buttonLaunchCreate;
    private SwipeRefreshLayout swipeRefreshLayout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_contact_list, container,false);
        setPresenter(new Contact_Presenter());
        getPresenter().inject(this, getValidateInternet());
        getBaseActivity().createProgressDialog();
        contactListView = (ListView) view.findViewById(R.id.contact_listView);
        //progress = (ContentLoadingProgressBar) getActivity().findViewById(R.id.progress);
        //progress.show();
        getPresenter().PresConsultContact();
        loadEvents(view);
        return view;
    }


    private void loadEvents(View view) {
        buttonLaunchCreate = (FloatingActionButton) view.findViewById(R.id.createContact);
        buttonLaunchCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), CreateContactActivity.class);
                startActivity(intent);
            }
        });
        swipeRefreshLayout = (SwipeRefreshLayout)view.findViewById(R.id.contactswiperefresh);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getPresenter().getContactList();
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
//      progress.show();
        swipeRefreshLayout.setRefreshing(true);
        getPresenter().PresConsultContact();
    }

    public void showUpdateProduct(final ArrayList<ContactModel> productArrayList) {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                //progress.hide();
                //updateContact(productArrayList);
            }
        });
    }


    @Override
    public void showAlertDialogInternet(final int title, final int message) {
        showAlertDialog(title, getResources().getString(message));

    }

    private void showAlertDialog(final int title, final String message) {
        swipeRefreshLayout.setRefreshing(false);
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                getBaseActivity().getShowAlertDialog().showAlertDialog(title, message, false, R.string.accept, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        getPresenter().PresConsultContact();
                    }
                }, R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        getActivity().finish();
                    }
                });
            }
        });
    }

    @Override
    public void showAlertError(int title, String message) {
        showAlertDialog(title, message);
    }

    private void callAdapter(final ArrayList<ContactModel> customers) {
        contactAdapter =  new ContactAdapter(getActivity(), R.id.contact_listView, customers);
        contactListView.setAdapter(contactAdapter);
        contactListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(getActivity(), Contact_Detail.class);
                intent.putExtra(Constants.ITEM_CONTACT,customers.get(position));
                startActivity(intent);
                //Toast.makeText(ContactActivity.this,"Pendiente por hacer",Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void showContactList(final ArrayList<ContactModel> customers) {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                //progress.hide();
                //metodo clase adapter
                swipeRefreshLayout.setRefreshing(false);
                callAdapter(customers);

            }
        });
    }

}
