package com.example.mmvmarchitecture;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel{


    private MutableLiveData<Integer> _result = new MutableLiveData<>();
    public MutableLiveData<Integer> result = _result;

    public void calculate(String width, String height, String length){
        int result = Integer.parseInt(width) * Integer.parseInt(height) * Integer.parseInt(length);
        _result.setValue(result);
    }




}
