package com.cosmo.arquitecturamvpbase.views.Maps;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.cosmo.arquitecturamvpbase.R;

public class StartActivityMaps extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_start);
    }


    public void launchMap(View view) {
        Intent intent = new Intent(StartActivityMaps.this,MapsActivity.class);
        startActivity(intent);
    }
}
