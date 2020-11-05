package com.example.demo_mavendependent_test;

import android.content.Context;
import android.support.multidex.MultiDex;
import android.support.multidex.MultiDexApplication;

import com.tradplus.ads.mobileads.TradPlus;

public class MYApplication extends MultiDexApplication {
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
        final Context applicationContext = getApplicationContext();
        if (applicationContext != null) {
//            TradPlus.invoker().initSDK(applicationContext,"FDC48B1D9D9E1F5CBD0C327159C8191C");
        }
    }
}
