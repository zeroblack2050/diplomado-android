package com.cosmo.arquitecturamvpbase.views.taller;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.cosmo.arquitecturamvpbase.R;
import com.cosmo.arquitecturamvpbase.helper.Constants;
import com.cosmo.arquitecturamvpbase.model.Product;
import com.cosmo.arquitecturamvpbase.model.taller_model.Contact_Model;
import com.cosmo.arquitecturamvpbase.presenter.ProductPresenter;
import com.cosmo.arquitecturamvpbase.presenter.taller_presenter.Contact_Presenter;
import com.cosmo.arquitecturamvpbase.views.BaseActivity;
import com.cosmo.arquitecturamvpbase.views.activities.CreateProductActivity;
import com.cosmo.arquitecturamvpbase.views.activities.DetailActivity;
import com.cosmo.arquitecturamvpbase.views.activities.ProductActivity;
import com.cosmo.arquitecturamvpbase.views.activities.UpdateProductActivity;
import com.cosmo.arquitecturamvpbase.views.activities.adapter.ProductAdapter;

import java.util.ArrayList;

public class ContactActivity_View extends BaseActivity<Contact_Presenter> implements ContactActivity_interface {

    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact__view);
        setPresenter(new ProductPresenter());
        getPresenter().inject(this, getValidateInternet());
        //createProgressDialog();
        productList = (ListView) findViewById(R.id.product_listView);
        progress = (ContentLoadingProgressBar) findViewById(R.id.progress);
        progress.show();
        getPresenter().getListProduct();
        loadEvents();
        //UpdateProduct();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        getPresenter().getListProduct();
    }

    private void loadEvents() {
        buttonLaunchCreate = (FloatingActionButton) findViewById(R.id.fab_launch_createproduct);
        buttonLaunchCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProductActivity.this, CreateProductActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        progress.show();
        getPresenter().getListProduct();
    }

    @Override
    public void showProductList(final ArrayList<Product> productArrayList) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                progress.hide();
                callAdapter(productArrayList);
            }
        });
    }


    public void showUpdateProduct(final ArrayList<Product> productArrayList) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                progress.hide();
                UpdateProduct(productArrayList);
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
                        getPresenter().getListProduct();
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

    private void callAdapter(final ArrayList<Product> productArrayList) {
        productAdapter =  new ProductAdapter(this, R.id.product_listView, productArrayList);
        productList.setAdapter(productAdapter);
        productList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ProductActivity.this, DetailActivity.class);
                intent.putExtra(Constants.ITEM_PRODUCT,productArrayList.get(position));
                startActivity(intent);
            }
        });
    }

    private void UpdateProduct(final ArrayList<Product> productArrayList){
        productAdapter =  new ProductAdapter(this, R.id.product_listView, productArrayList);
        productList.setAdapter(productAdapter);
        productList.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(ProductActivity.this, UpdateProductActivity.class);
                intent.putExtra(Constants.ITEM_PRODUCT,productArrayList.get(position));
                startActivity(intent);
                return false;
            }
        });
    }


}
