package com.cosmo.arquitecturamvpbase.views.activities.adapter;

import android.provider.SyncStateContract;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.cosmo.arquitecturamvpbase.helper.Constants;
import com.cosmo.arquitecturamvpbase.views.activities.ProductActivity;
import com.cosmo.arquitecturamvpbase.views.activities.fragments.ContactFragment;
import com.cosmo.arquitecturamvpbase.views.activities.fragments.ProductFragment;
import com.cosmo.arquitecturamvpbase.views.taller.ContactActivity;

/**
 * Created by Superadmin1 on 14/10/2017.
 */

public class DashBoardTabsAdapter extends FragmentStatePagerAdapter {


    public DashBoardTabsAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new ProductFragment();
            case 1:
                return new ContactFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return Constants.TITLE_PRODUCT;
            case 1:
                return Constants.TITLE_CONTACT;
            default:
                return Constants.TITLE_DEFAULT;
        }
    }
}
