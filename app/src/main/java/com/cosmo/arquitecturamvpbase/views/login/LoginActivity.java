package com.cosmo.arquitecturamvpbase.views.login;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.cosmo.arquitecturamvpbase.R;
import com.cosmo.arquitecturamvpbase.helper.Constants;
import com.cosmo.arquitecturamvpbase.helper.CustomSharedPreferences;
import com.cosmo.arquitecturamvpbase.model.loginModel.LoginModel;
import com.cosmo.arquitecturamvpbase.presenter.login.LoginPresenter;
import com.cosmo.arquitecturamvpbase.repository.loginRepository.LoginRepository;
import com.cosmo.arquitecturamvpbase.views.BaseActivity;

public class LoginActivity extends BaseActivity<LoginPresenter> implements ILoginView, TextWatcher{

    TextView textviewOneLoginActivity;
    TextView textviewTwoLoginActivity;
    Button buttonLoginActivity;
    private CustomSharedPreferences custom;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setPresenter(new LoginPresenter(new LoginRepository()));
        getPresenter().inject(this, getValidateInternet());
        custom = new CustomSharedPreferences(this);
        //autoLoginSaved();
        loadViews();
        loginAction();
    }

    private void autoLoginSaved() {
        if(custom.getObjectuser(Constants.USER) != null){
            getPresenter().autoLoginInRepository(custom.getObjectuser(Constants.USER).getToken());
            /*login(custom.getObjectuser(Constants.USER).getEmail().toString(),
                    custom.getObjectuser(Constants.USER).getPassword().toString());
            buttonLoginActivity.setEnabled(true);
            buttonLoginActivity.performClick();*/

        }
    }


    private void loadViews() {
        textviewOneLoginActivity = (TextView)findViewById(R.id.textviewOneLoginActivity);
        textviewOneLoginActivity.addTextChangedListener(this);
        textviewTwoLoginActivity= (TextView)findViewById(R.id.textviewTwoLoginActivity);
        textviewTwoLoginActivity.addTextChangedListener(this);
        buttonLoginActivity = (Button) findViewById(R.id.buttonLoginActivity);
        buttonLoginActivity.addTextChangedListener(this);
    }

    private void loginAction() {
        buttonLoginActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login(textviewOneLoginActivity.getText().toString(), textviewTwoLoginActivity.getText().toString());
                //Toast.makeText(LoginActivity.this,custom.getObjectuser(Constants.USER).getEmail().toString(), Toast.LENGTH_LONG).show();
                //Toast.makeText(LoginActivity.this,custom.getObjectuser(Constants.USER).getPassword().toString(), Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        if(!textviewOneLoginActivity.getText().toString().trim().isEmpty() &&
                !textviewTwoLoginActivity.getText().toString().trim().isEmpty()){
            buttonLoginActivity.setEnabled(true);
        }else{
            buttonLoginActivity.setEnabled(false);
        }
    }



    private void login (String email, String password){
        getPresenter().loginPresenter(email, password);
    }

    @Override
    public void showAlertDialogInternet(int title, int validate_internet) {
        showAlertDialog(title, validate_internet);
    }

    @Override
    public void showAlertError(int title, int message) {
        showAlertDialog(title, message);
    }

    @Override
    public void showAlertError(int title, String message) {
    }

    public void showAlertDialog(final int title, final int message) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                getShowAlertDialog().showAlertDialog(title, message, false, R.string.accept, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                }, R.string.option_cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
            }
        });
    }

    @Override
    public void showProfile(LoginModel login) {
        getPresenter().autoLoginInRepository(login.getToken().toString());
        custom.saveObjectUser(Constants.USER,login);
        Intent intent = new Intent(LoginActivity.this, LoggedActivity.class);
        startActivity(intent);
    }

}
