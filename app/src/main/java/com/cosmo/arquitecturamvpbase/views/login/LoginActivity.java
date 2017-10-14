package com.cosmo.arquitecturamvpbase.views.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.cosmo.arquitecturamvpbase.R;
import com.cosmo.arquitecturamvpbase.views.activities.CreateProductActivity;

public class LoginActivity extends AppCompatActivity {

    TextView textviewOneLoginActivity;
    TextView textviewTwoLoginActivity;
    Button buttonLoginActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loadViews();
        loginAction();
    }



    private void loadViews() {
        textviewOneLoginActivity = (TextView)findViewById(R.id.textviewOneLoginActivity);
        textviewTwoLoginActivity= (TextView)findViewById(R.id.textviewTwoLoginActivity);
        buttonLoginActivity = (Button) findViewById(R.id.buttonLoginActivity);
    }

    private void loginAction() {
        buttonLoginActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Toast.makeText(LoginActivity.this,"Login Button Actioned", Toast.LENGTH_LONG).show();
            }
        });
    }
}
