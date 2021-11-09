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
        setContentView(R.layout.activity_cases_health_authority);

        Intent intent = getIntent();

        Fraser =    intent.getStringExtra(     "Fraser");
        Interior =  intent.getStringExtra(   "Interior");
        Northern =  intent.getStringExtra(   "Northern");
        Canada =    intent.getStringExtra(     "Canada");
        Vancouver = intent.getStringExtra(  "Vancouver");
        Coastal =   intent.getStringExtra(    "Coastal");

        fraserCases = findViewById(R.id     .Fraser);
        interiorCases = findViewById(R.id   .Interior);
        northernCases = findViewById(R.id   .Northern);
        canadaCases = findViewById(R.id     .Canada);
        vancouverCases = findViewById(R.id  .Vancouver);
        coastalCases = findViewById(R.id    .Coastal);

        fraserCases.setText(Fraser);
        interiorCases.setText(Interior);
        northernCases.setText(Northern);
        canadaCases.setText(Canada);
        vancouverCases.setText(Vancouver);
        coastalCases.setText(Coastal);


    }
}