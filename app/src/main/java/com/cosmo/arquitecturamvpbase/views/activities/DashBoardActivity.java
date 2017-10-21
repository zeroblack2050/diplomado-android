package com.cosmo.arquitecturamvpbase.views.activities;

import android.content.ClipData;
import android.content.res.ColorStateList;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TableLayout;

import com.cosmo.arquitecturamvpbase.R;
import com.cosmo.arquitecturamvpbase.helper.Constants;
import com.cosmo.arquitecturamvpbase.helper.CustomSharedPreferences;
import com.cosmo.arquitecturamvpbase.views.BaseActivity;
import com.cosmo.arquitecturamvpbase.views.activities.adapter.DashBoardTabsAdapter;

public class DashBoardActivity extends BaseActivity {

    private TabLayout dashBoard_tlTabs;
    private ViewPager dashBoard_vpContainer;

    //@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);
        loadViews();
        loadToolbar();
        loadTabsAdapter();
    }

    public void loadToolbar(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.dashboard_toolbar);
        toolbar.setTitle(Constants.EMPTY);
        setSupportActionBar(toolbar);
    }

    private void loadTabsAdapter() {
        DashBoardTabsAdapter dashBoardTabsAdapter = new DashBoardTabsAdapter(getSupportFragmentManager());
        dashBoard_vpContainer.setAdapter(dashBoardTabsAdapter);
        dashBoard_tlTabs.setupWithViewPager(dashBoard_vpContainer);
        dashBoard_tlTabs.setSelectedTabIndicatorColor(ContextCompat.getColor(this,R.color.colorPrimaryDark));
        dashBoard_tlTabs.setTabTextColors(ColorStateList.valueOf(ContextCompat.getColor(this,R.color.colorPrimaryDark)));
    }

    private void loadViews() {
        dashBoard_tlTabs = (TabLayout)findViewById(R.id.dashboard_tablayout);
        dashBoard_vpContainer = (ViewPager) findViewById(R.id.dashboard_viewpager);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.menu_close){
            CustomSharedPreferences customSharedPreferences = new CustomSharedPreferences(this);
            customSharedPreferences.deleteValue(Constants.USER);
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_dashboard,menu);

        return super.onCreateOptionsMenu(menu);
    }
}
