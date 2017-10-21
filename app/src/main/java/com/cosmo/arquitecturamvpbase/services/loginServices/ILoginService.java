package com.cosmo.arquitecturamvpbase.services.loginServices;

import com.cosmo.arquitecturamvpbase.model.loginModel.LoginModel;

import java.util.ArrayList;

import retrofit.http.Body;
import retrofit.http.DELETE;
import retrofit.http.GET;
import retrofit.http.Header;
import retrofit.http.POST;
import retrofit.http.PUT;
import retrofit.http.Path;
import retrofit.http.Query;

/**
 * Created by Superadmin1 on 14/10/2017.
 */

public interface ILoginService {

    @GET("/user/auth")
    LoginModel login(@Query("email") String email, @Query("password") String password);

    @GET("/user")
    LoginModel autoLogin(@Header("Authorization") String token);
}
