package com.bcit.assignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class CasesAgeGroup extends AppCompatActivity {

    String lessThan10Cases;
    String to19Cases;
    String to29Cases;
    String to39Cases;
    String to49Cases;
    String to59Cases;
    String to69Cases;
    String to79Cases;
    String to89Cases;
    String plus90Cases;

    TextView lessThan10;
    TextView to19;
    TextView to29;
    TextView to39;
    TextView to49;
    TextView to59;
    TextView to69;
    TextView to79;
    TextView to89;
    TextView plus90;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cases_gender);

        Intent intent = getIntent();
        lessThan10Cases = intent.getStringExtra("lessThan10");
        to19Cases = intent.getStringExtra("to19");
        to29Cases = intent.getStringExtra("to29");
        to39Cases = intent.getStringExtra("to39");
        to49Cases = intent.getStringExtra("to49");
        to59Cases = intent.getStringExtra("to59");
        to69Cases = intent.getStringExtra("to69");
        to79Cases = intent.getStringExtra("to79");
        to89Cases = intent.getStringExtra("to89");
        plus90Cases = intent.getStringExtra("plus90");

        lessThan10 = findViewById(R.id.lessThan10);
        to19 = findViewById(R.id.to19);
        to29 = findViewById(R.id.to29);
        to39 = findViewById(R.id.to39);
        to49 = findViewById(R.id.to49);
        to59 = findViewById(R.id.to59);
        to69 = findViewById(R.id.to69);
        to79 = findViewById(R.id.to79);
        to89 = findViewById(R.id.to89);
        plus90 = findViewById(R.id.plus90);

        lessThan10.setText(getString(R.string.lessThan10, lessThan10Cases));
        to19.setText(getString(R.string.to19, to19Cases));
        to29.setText(getString(R.string.to29, to29Cases));
        to39.setText(getString(R.string.to39, to39Cases));
        to49.setText(getString(R.string.to49, to49Cases));
        to59.setText(getString(R.string.to59, to59Cases));
        to69.setText(getString(R.string.to69, to69Cases));
        to79.setText(getString(R.string.to79, to79Cases));
        to89.setText(getString(R.string.to89, to89Cases));
        plus90.setText(getString(R.string.plus90, plus90Cases));
    }
}