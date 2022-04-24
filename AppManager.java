package com.example.livedata_test;

import android.app.Activity;
import android.content.Context;
import android.net.wifi.WifiManager;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;


import java.util.ArrayList;

public class AppManager {
        // Static variable reference of single_instance
        // of type Singleton
        private static AppManager _instance = null;
        private static Context context;
        private static DataRepository dR;


        private AppManager()
        {

        }

    public void initContextDependentObjects(Activity c){
        context = c;
        dR = ViewModelProviders.of((FragmentActivity) c).get(DataRepository.class);
    }


    public DataRepository getDataRepository(){
            return dR;
        }

        // Static method
        // Static method to create instance of Singleton class
        public static AppManager getInstance()
        {
            if (_instance == null)
                _instance = new AppManager();
            return _instance;
        }

    }
