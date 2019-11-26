package com.merchant.bookwego.utills;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.merchant.bookwego.R;
import com.merchant.bookwego.baseClass.ConnectivityReceiver;

public class Utility implements ConnectivityReceiver.ConnectivityReceiverListener {
    private Context context;


    public static Typeface typeFaceForProximaNovaBoldText(Context context) {

        return Typeface.createFromAsset(context.getAssets(),
                "fonts/ProximaNovaBold.ttf");
    }


    public static Typeface typeFaceForPoppinsBoldText(Context context) {

        return Typeface.createFromAsset(context.getAssets(),
                "fonts/PoppinsBold.ttf");
    }

    public static Typeface typeFaceForPoppinsRegulerText(Context context) {

        return Typeface.createFromAsset(context.getAssets(),
                "fonts/PoppinsRegular.ttf");
    }

    public static Typeface typeFaceForProximaNovaRegulerText(Context context) {

        return Typeface.createFromAsset(context.getAssets(),
                "fonts/ProximaNovaRegular.ttf");
    }

    public static Typeface typeFaceForProximaNovaSemiboldText(Context context) {

        return Typeface.createFromAsset(context.getAssets(),
                "fonts/ProximaNovaSemibold.ttf");
    }

    @Override
    public void onNetworkConnectionChanged(boolean isConnected) {

        boolean isNetworkConnected = ConnectivityReceiver.isConnected();

    }

    // Method to manually check connection status
    public static boolean checkConnection() {

        boolean isConnected = ConnectivityReceiver.isConnected();
        return isConnected;
    }
}
