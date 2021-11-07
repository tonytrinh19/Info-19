package com.bcit.assignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class CasesHealthAuthority extends AppCompatActivity {

    String Fraser;
    String Interior;
    String Northern;
    String Canada;
    String Vancouver;
    String Coastal;

    TextView fraserCases;
    TextView interiorCases;
    TextView northernCases;
    TextView canadaCases;
    TextView vancouverCases;
    TextView coastalCases;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cases_gender);

        Intent intent = getIntent();

        Fraser = intent.getStringExtra("lessThan10");
        Interior = intent.getStringExtra("to19");
        Northern = intent.getStringExtra("to29");
        Canada = intent.getStringExtra("to39");
        Vancouver = intent.getStringExtra("to49");
        Coastal = intent.getStringExtra("to59");

        fraserCases = findViewById(R.id.to19);
        interiorCases = findViewById(R.id.to29);
        northernCases = findViewById(R.id.to39);
        canadaCases = findViewById(R.id.to49);
        vancouverCases = findViewById(R.id.to59);
        coastalCases = findViewById(R.id.to69);

        fraserCases.setText(getString(R.string   .Fraser,   fraserCases));
        interiorCases.setText(getString(R.string .Interior, interiorCases));
        northernCases.setText(getString(R.string .Northern, northernCases));
        canadaCases.setText(getString(R.string   .Canada,   canadaCases));
        vancouverCases.setText(getString(R.string.Vancouver,vancouverCases));
        coastalCases.setText(getString(R.string      .Coastal,  coastalCases));


    }
}