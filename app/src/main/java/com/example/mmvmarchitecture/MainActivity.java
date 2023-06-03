package com.example.mmvmarchitecture;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText width, height, length;
    private Button btnCalculate;
    private MainViewModel mainViewModel;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        width = findViewById(R.id.edt_width);
        height = findViewById(R.id.edt_height);
        length = findViewById(R.id.edt_length);
        result = findViewById(R.id.tv_result);

        mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);

        btnCalculate = findViewById(R.id.btn_calculate);
        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String w = width.getText().toString();
                String h = height.getText().toString();
                String l = length.getText().toString();

                if(w.isEmpty()){
                    width.setError("Please fill this field");
                } else if(h.isEmpty()){
                    height.setError("Please fill this field");
                } else if(l.isEmpty()){
                    length.setError("Please fill this field");
                } else {
                    mainViewModel.calculate(w, h, l);
                }
            }
        });
        displayResult();

    }

    private void displayResult(){
        mainViewModel.result.observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                result.setText(String.valueOf(integer));
            }
        });
    }

    private void calculate(String w, String h, String l){
        // Menghitung tanpa view model (tanpa MVVM)
        // Data tidak dipertahankan
        int _result = Integer.parseInt(w) * Integer.parseInt(h) * Integer.parseInt(l);
        result.setText(String.valueOf(_result));
    }
}