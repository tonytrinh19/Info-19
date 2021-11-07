package com.bcit.assignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class CasesAgeGroup extends AppCompatActivity {

    ArrayList<String> ageCases;
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cases_gender);

        Intent intent = getIntent();
        ageCases = intent.getStringArrayListExtra("db_result");
        lv = findViewById(R.id.age_group_list);
        ArrayAdapter<String> ad = new ArrayAdapter<>(
                this,
                R.layout.support_simple_spinner_dropdown_item,
                ageCases
        );
        lv.setAdapter(ad);

    }
}