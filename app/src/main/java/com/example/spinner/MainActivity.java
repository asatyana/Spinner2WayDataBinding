package com.example.spinner;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Spinner;

import com.example.spinner.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        Model model = new Model();
        binding.setModel(model);
    }

    public int getPosition(Spinner spinner) {
        return spinner.getSelectedItemPosition();
    }
}
