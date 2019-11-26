package com.merchant.bookwego.baseClass;

import android.app.Application;


import com.merchant.bookwego.R;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

public class MyApp extends Application {

    private static MyApp mInstance;

    public static synchronized MyApp getInstance() {
        return mInstance;
    }

    public void setConnectivityListener(ConnectivityReceiver.ConnectivityReceiverListener listener) {
        ConnectivityReceiver.connectivityReceiverListener = listener;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        mInstance = this;
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/ProximaNovaSemibold.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );
    }




}
