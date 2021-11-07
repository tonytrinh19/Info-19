package com.bcit.assignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class CasesGender extends AppCompatActivity {

    String genderMaleCases;
    String genderFemaleCases;
    String genderUnknownCases;
    TextView genderMale;
    TextView genderFemale;
    TextView genderUnknown;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cases_gender);

        Intent intent = getIntent();

        genderMaleCases = intent.getStringExtra("male");
        genderFemaleCases = intent.getStringExtra("female");
        genderUnknownCases = intent.getStringExtra("unknown");

        genderMale = findViewById(R.id.femaleGender);
        genderFemale = findViewById(R.id.maleGender);
        genderUnknown = findViewById(R.id.unknownGender);

        genderMale.setText(genderMaleCases);
        genderFemale.setText(genderFemaleCases);
        genderUnknown.setText(genderUnknownCases);
    }
}