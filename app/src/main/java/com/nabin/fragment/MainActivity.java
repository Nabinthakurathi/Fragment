package com.nabin.fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener  {
    private Button btnfragment;
    private Boolean Status = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnfragment = findViewById(R.id.btnfragment);
        btnfragment.setOnClickListener(this);
    }

    public void onClick(View v) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        if(Status){
            firstFragment firstfragment = new firstFragment();
            fragmentTransaction.replace(R.id.fragmentContainer,firstfragment);
            fragmentTransaction.commit();
            btnfragment.setText("Load second Fragment");
            Status = false;
        }
        else{
            SecondFragment secondFragment = new SecondFragment();
            fragmentTransaction.replace(R.id.fragmentContainer,secondFragment);
            fragmentTransaction.commit();
            btnfragment.setText("Load first Fragment");
            Status = true;
        }
    }
}
