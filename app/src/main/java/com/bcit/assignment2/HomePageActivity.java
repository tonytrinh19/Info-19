package com.bcit.assignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class HomePageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        Button monthYear = findViewById(R.id.mon_year_but);
        Button healthAuthority = findViewById(R.id.health_auth_button);
        Button gender = findViewById(R.id.gender_button);
        Button ageGroup = findViewById(R.id.age_group_button);

        monthYear.setOnClickListener(myv -> {
            Intent monthIntent = new Intent(this, CasesMonthYear.class);
//            monthIntent.putStringArrayListExtra("db_result")
            startActivity(monthIntent);
        });

        healthAuthority.setOnClickListener(hav -> {
            Intent healthAuthIntent = new Intent(this, CasesHealthAuthority.class);
//            monthIntent.putStringArrayListExtra("db_result")
            startActivity(healthAuthIntent);
        });

        gender.setOnClickListener(myv -> {
            Intent genderIntent = new Intent(this, CasesGender.class);
//            monthIntent.putStringArrayListExtra("db_result")
            startActivity(genderIntent);
        });

        ageGroup.setOnClickListener(myv -> {
            Intent ageIntent = new Intent(this, CasesAgeGroup.class);
//            monthIntent.putStringArrayListExtra("db_result")
            startActivity(ageIntent);
        });
    }
}