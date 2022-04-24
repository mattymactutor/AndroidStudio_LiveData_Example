package com.example.livedata_test;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

public class Page2 extends AppCompatActivity {

    Button btn;
    private DataRepository dr;
    private ArrayList<String> allSongs;
    private MutableLiveData<String> name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page2);

        //dr = AppManager.getInstance().getDataRepository();
        allSongs = AppManager.getInstance().getDataRepository().getAllSongs().getValue();
        //AppManager.getInstance().getDataRepository().getAllSongs().setValue(allSongs);
        name = AppManager.getInstance().getDataRepository().getCurrentName();
        btn = findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("1","Set getCurrentName() value");
                //name.setValue("THIS WORKED!!");
                allSongs.add("ANOTHERSTRING");
                AppManager.getInstance().getDataRepository().getAllSongs().setValue(allSongs);
                finish();
            }
        });
    }
}