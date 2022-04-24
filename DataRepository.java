package com.example.livedata_test;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class DataRepository extends ViewModel {

    // Create a LiveData with a String
    private MutableLiveData<String> currentName;
    private MutableLiveData<ArrayList<String>> allSongs;
    private MutableLiveData<ArrayList<String>> allOriginalSongs;

    public MutableLiveData<String> getCurrentName() {
        if (currentName == null) {
            currentName = new MutableLiveData<String>();
        }
        return currentName;
    }



    public MutableLiveData<ArrayList<String>> getAllSongs(){
        if (allSongs == null) {
            allSongs = new MutableLiveData<>();
            allSongs.setValue( new ArrayList<>());
            allSongs.getValue().add("Test1");
        }
        return allSongs;
    }

    public MutableLiveData<ArrayList<String>> getAllOriginalSongs(){
        if (allOriginalSongs == null)
            allOriginalSongs = new MutableLiveData<ArrayList<String>>();
        return allOriginalSongs;
    }

    public String getSongString(){
        String out = "";
        for(String s : allSongs.getValue()){
            out += s;
        }
        return out;
    }

// Rest of the ViewModel...
}