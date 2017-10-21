package com.cosmo.arquitecturamvpbase.views.login;

import com.cosmo.arquitecturamvpbase.model.loginModel.LoginModel;
import com.cosmo.arquitecturamvpbase.views.IBaseView;

/**
 * Created by Superadmin1 on 17/10/2017.
 */

public interface ILoginView extends IBaseView{

    void showProfile(LoginModel login);

    void showAlertDialogInternet(int error, int validate_internet);

    void showAlertError(int title, int message);

    void showAlertError(int title, String message);

}
