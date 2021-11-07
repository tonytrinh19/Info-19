package com.bcit.assignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class CasesMonthYear extends AppCompatActivity {

    ArrayList<String> monthYearCases;
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cases_gender);

        Intent intent = getIntent();
        monthYearCases = intent.getStringArrayListExtra("db_result");
        lv = findViewById(R.id.month_year_list);
        ArrayAdapter<String> ad = new ArrayAdapter<>(
                this,
                R.layout.support_simple_spinner_dropdown_item,
                monthYearCases
        );
        lv.setAdapter(ad);

    }
}