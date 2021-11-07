package com.bcit.assignment2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CasesMonthYear extends AppCompatActivity {

    PatientAdapter adapter;
    RecyclerView rv;
    List<Patient> patientList;

    String year;
    String month;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cases_month_year);

        Button findButton = findViewById(R.id.searchYearMonth);
        findButton.setOnClickListener(v -> {
            TextView monthView = findViewById(R.id.monthSearch);
            TextView yearView = findViewById(R.id.yearSearch);
            year = yearView.getText().toString();
            month = monthView.getText().toString();

            Query q = FirebaseDatabase.getInstance().getReference().limitToFirst(10000);
            q.addListenerForSingleValueEvent(valueEventListener);
        });

        rv = findViewById(R.id.recyclerView);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(this));
        patientList = new ArrayList<>();
        adapter = new PatientAdapter(this, patientList);
        rv.setAdapter(adapter);


    }

    ValueEventListener valueEventListener = new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
            patientList.clear();
            if (dataSnapshot.exists()) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {

                    if (
                        // is year
                        Objects.equals(Objects.requireNonNull(snapshot
                            .child("Reported_Date").getValue(String.class))
                            .split("-")[0], year)
                    &&
                        // is month
                        Objects.equals(Objects.requireNonNull(snapshot
                                .child("Reported_Date").getValue(String.class))
                                .split("-")[1], month)

                    ) {
                        patientList.add(new Patient(
                                snapshot.child("Age_Group").getValue(String.class),
                                snapshot.child("Classification_Reported").getValue(String.class),
                                snapshot.child("HA").getValue(String.class),
                                snapshot.child("Reported_Date").getValue(String.class),
                                snapshot.child("Sex").getValue(String.class)
                            )
                        );
                    }
                    adapter.notifyDataSetChanged();
                }
            }
        }

        @Override
        public void onCancelled(@NonNull DatabaseError error) {}
    };
}