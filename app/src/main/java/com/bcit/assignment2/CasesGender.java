package com.bcit.assignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class CasesGender extends AppCompatActivity {

    ArrayList<String> genderCases;
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cases_gender);

        Intent intent = getIntent();
        genderCases = intent.getStringArrayListExtra("db_result");
        lv = findViewById(R.id.gender_list);
        ArrayAdapter<String> ad = new ArrayAdapter<>(
                this,
                R.layout.support_simple_spinner_dropdown_item,
                genderCases
        );
        lv.setAdapter(ad);

    }
}