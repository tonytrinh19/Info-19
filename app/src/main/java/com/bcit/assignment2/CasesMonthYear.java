package com.bcit.assignment2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class CasesMonthYear extends AppCompatActivity {

    PatientAdapter adapter;
    RecyclerView rv;
    List<Patient> patientList;

    int maleCount = 0;
    int femaleCount = 0;
    int unknown = 0;

    DatabaseReference dbArtists;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cases_month_year);


        rv = findViewById(R.id.recyclerView);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(this));
        patientList = new ArrayList<>();
        adapter = new PatientAdapter(this, patientList);
        rv.setAdapter(adapter);

        // 150k max ?
        Query q = FirebaseDatabase.getInstance().getReference();

        q.addListenerForSingleValueEvent(valueEventListener);
    }

    ValueEventListener valueEventListener = new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
            patientList.clear();
            if (dataSnapshot.exists()) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {

                    if (Objects.equals(snapshot.child("Sex").getValue(String.class), "M")) {
                        maleCount++;
                    } else if (Objects.equals(snapshot.child("Sex").getValue(String.class), "F")) {
                        femaleCount++;
                    } else {
                        unknown++;
                    }

//                    snapshot.child("Age_Group").toString();
//                    snapshot.child("Classification_Reported").toString();
//                    snapshot.child("HA").toString();
//                    snapshot.child("Reported_Date").toString();
//                    snapshot.child("Sex").toString();
//                    patientList.add(p);
                }
                adapter.notifyDataSetChanged();
            }
        }

        @Override
        public void onCancelled(@NonNull DatabaseError error) {

        }
    };
}