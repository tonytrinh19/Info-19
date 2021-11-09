package com.bcit.assignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class CasesAgeGroup extends AppCompatActivity {

    String lessThan10Cases,
    to19Cases, to29Cases, to39Cases,
    to49Cases, to59Cases, to69Cases,
    to79Cases, to89Cases, plus90Cases, unknownCases;

    TextView lessThan10, to19, to29,
    to39, to49, to59, to69, to79,
    to89, plus90, unknown;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cases_age_group);

        Intent intent = getIntent();
        lessThan10Cases =   intent.getStringExtra("lessThan10");
        to19Cases =         intent.getStringExtra("to19");
        to29Cases =         intent.getStringExtra("to29");
        to39Cases =         intent.getStringExtra("to39");
        to49Cases =         intent.getStringExtra("to49");
        to59Cases =         intent.getStringExtra("to59");
        to69Cases =         intent.getStringExtra("to69");
        to79Cases =         intent.getStringExtra("to79");
        to89Cases =         intent.getStringExtra("to89");
        plus90Cases =       intent.getStringExtra("plus90");
        unknownCases =      intent.getStringExtra("unknown");


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
        unknown = findViewById(R.id.unknown);


        lessThan10.setText(lessThan10Cases);
        to19.setText(to19Cases);
        to29.setText(to29Cases);
        to39.setText(to39Cases);
        to49.setText(to49Cases);
        to59.setText(to59Cases);
        to69.setText(to69Cases);
        to79.setText(to79Cases);
        to89.setText(to89Cases);
        plus90.setText(plus90Cases);
        plus90.setText(unknownCases);
    }
}