package com.cosmo.arquitecturamvpbase.presenter.login;

import com.cosmo.arquitecturamvpbase.R;
import com.cosmo.arquitecturamvpbase.model.loginModel.LoginModel;
import com.cosmo.arquitecturamvpbase.presenter.BasePresenter;
import com.cosmo.arquitecturamvpbase.repository.loginRepository.ILoginRepository;
import com.cosmo.arquitecturamvpbase.views.login.ILoginView;
import retrofit.RetrofitError;

/**
 * Created by Superadmin1 on 17/10/2017.
 */

public class LoginPresenter extends BasePresenter<ILoginView>{

    ILoginRepository loginRepository;

    public LoginPresenter(ILoginRepository LoginRepository) {
        this.loginRepository = LoginRepository;
    }


    public void loginPresenter(String email, String password){
        if(getValidateInternet().isConnected()){
            createThreadLogin(email, password);
        }else{
            getView().showAlertDialogInternet(R.string.error, R.string.validate_internet);
        }
    }

    private void createThreadLogin(final String email, final String password) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                loginServices(email, password);
            }
        });
        thread.start();
    }

    private void loginServices(String email, String password) {
        try {
            LoginModel login = loginRepository.login(email, password);
            getView().showProfile(login);
        }catch (RetrofitError retrofitError){
            getView().showAlertError(R.string.error, retrofitError.getMessage());
        }
    }



    public LoginModel autoLoginInRepository(String token){
        //bearer:
        try{
            String bearerToken = "Bearer: " + token;
            LoginModel user = loginRepository.autoLogin(token);
            return user;

        }catch (RetrofitError retrofitError){
            return null;
        }
    }


    public void autoLoginPresenter(String token){

    }

}
