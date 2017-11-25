package com.example.usman.myproject;

import android.app.Application;
import android.support.v7.app.AppCompatActivity;

import com.facebook.stetho.Stetho;

/**
 * Created by usman on 18/11/2017.
 */

public class ClientApplication extends Application {

    public void onCreate() {
        super.onCreate();
        Stetho.initialize(
                Stetho.newInitializerBuilder(this)
                        .enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
                        .enableWebKitInspector(Stetho.defaultInspectorModulesProvider(this))
                        .build());
    }
}
