package com.cosmo.arquitecturamvpbase.repository.loginRepository;

import com.cosmo.arquitecturamvpbase.helper.ServicesFactory;
import com.cosmo.arquitecturamvpbase.model.loginModel.LoginModel;
import com.cosmo.arquitecturamvpbase.services.loginServices.ILoginService;

import retrofit.RetrofitError;

/**
 * Created by Superadmin1 on 17/10/2017.
 */

public class LoginRepository implements ILoginRepository {

    ILoginService service;

    public LoginRepository(){
        ServicesFactory servicesFactory = new ServicesFactory();
        service = (ILoginService) servicesFactory.getInstance(ILoginService.class);
    }

    @Override
    public LoginModel login(String user, String password) throws RetrofitError {
        return service.login(user, password);
    }

    @Override
    public LoginModel autoLogin(String token) throws RetrofitError {
        return service.autoLogin(token);
    }


}
