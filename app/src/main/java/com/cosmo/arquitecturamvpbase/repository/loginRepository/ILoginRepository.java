package com.cosmo.arquitecturamvpbase.repository.loginRepository;

/**
 * Created by Superadmin1 on 17/10/2017.
 */

import com.cosmo.arquitecturamvpbase.model.loginModel.LoginModel;

import retrofit.RetrofitError;

public interface ILoginRepository {

    public LoginModel login(String email, String password) throws RetrofitError;
    public LoginModel autoLogin(String Token) throws RetrofitError;


}
