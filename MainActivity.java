package com.example.livedata_test;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


/*
Live Data

Make a singleton to house the DataRepository
Get the array list for whatever data you need on each activity
change the data
then set the value through the data repository to fire off all of the listeners





 */
public class MainActivity extends AppCompatActivity {
    private AppManager appManager;
    private DataRepository dr;
    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //create first instance of DataRepository
        appManager = AppManager.getInstance();
        appManager.initContextDependentObjects(this);
        // Get the ViewModel.
        dr = appManager.getDataRepository();
        text = findViewById(R.id.text);

        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent page2 = new Intent(MainActivity.this,Page2.class);
                startActivity(page2);
            }
        });

        // Observe the LiveData, passing in this activity as the LifecycleOwner and the observer.
        dr.getCurrentName().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable final String newName) {
                // Update the UI, in this case, a TextView.
                Log.i("1","Observable String data changed");
                text.setText(dr.getCurrentName().getValue());
            }
        });

        dr.getAllSongs().observe(this, new Observer<List<String>>() {
            @Override
            public void onChanged(List<String> strings) {
                Log.i("1","Observable ArrayList String All Songs data changed");
                text.setText(dr.getSongString());
            }
        });
    }
}