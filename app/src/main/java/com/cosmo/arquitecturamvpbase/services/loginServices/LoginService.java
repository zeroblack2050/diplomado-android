package com.cosmo.arquitecturamvpbase.services.loginServices;

import com.cosmo.arquitecturamvpbase.model.DeleteResponse;
import com.cosmo.arquitecturamvpbase.model.Product;

import java.util.ArrayList;

import retrofit.http.Body;
import retrofit.http.DELETE;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.PUT;
import retrofit.http.Path;

/**
 * Created by Superadmin1 on 14/10/2017.
 */

public interface LoginService {
    @GET("/user/auth?")
    ArrayList<Product> getProductList();

    @GET("/user/auth?")
    Product createProduct(@Body Product product);

    @DELETE("/products/{id}")
    DeleteResponse deleteProduct(@Path("id")String id);

    @PUT("/products/{id}")
    boolean updateProduct(@Path("id")String id);
}
