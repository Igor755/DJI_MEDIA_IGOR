package com.fg.dji_media;

import android.app.Application;
import android.content.Context;

import androidx.multidex.MultiDex;

import com.secneo.sdk.Helper;

import dji.sdk.base.BaseProduct;
import dji.sdk.sdkmanager.DJISDKManager;


public class MApplication extends Application {


    private static BaseProduct product;
    private static Application app = null;

    @Override
    protected void attachBaseContext(Context paramContext) {
        super.attachBaseContext(paramContext);
        MultiDex.install(this);
        Helper.install(MApplication.this);
        app = this;

    }
    public static synchronized BaseProduct getProductInstance() {
        product = DJISDKManager.getInstance().getProduct();
        return product;
    }
    public static Application getInstance() {
        return MApplication.app;
    }




}
