package com.cosmo.arquitecturamvpbase.views.taller;

import com.cosmo.arquitecturamvpbase.views.IBaseView;

/**
 * Created by jasmany on 4/10/2017.
 */

public interface IDetailContactView extends IBaseView {

    void showToast(int message);
    void showToast(String message);
}
