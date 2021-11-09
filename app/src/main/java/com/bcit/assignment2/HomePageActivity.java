package com.bcit.assignment2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

public class HomePageActivity extends AppCompatActivity {

    ProgressBar pb;
    Button monthYear, healthAuthority, gender, ageGroup;

    // 93193
    static int maleCount = 0, femaleCount = 0, unknown = 0;

    // 14924
    static int ageLessThan10Count, age10To19Count,
    age20To29Count, age30To39Count, age40To49Count,
    age50To59Count, age60To69Count, age70To79Count,
    age80To89Count, ageMoreThan90, ageElse;

    static int countFraserHA, countInteriorHA, countNorthernHA,
    countVancouverCoastalHA, countVancouverIslandHA, countOutsideCa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Query q = FirebaseDatabase.getInstance().getReference();
        q.addListenerForSingleValueEvent(valueEventListener);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        pb = findViewById(R.id.progress_bar);

        monthYear = findViewById(R.id.mon_year_but);
        healthAuthority = findViewById(R.id.health_auth_button);
        gender = findViewById(R.id.gender_button);
        ageGroup = findViewById(R.id.age_group_button);


        monthYear.setOnClickListener(myv -> {
            Intent timeIntent = new Intent(this, CasesMonthYear.class);
            startActivity(timeIntent);
        });

        healthAuthority.setOnClickListener(hav -> {
            Intent healthAuthIntent = new Intent(this, CasesHealthAuthority.class);
            healthAuthIntent.putExtra(   "Fraser","Fraser:\t" +   countFraserHA          );
            healthAuthIntent.putExtra( "Interior","Interior:\t" + countInteriorHA        );
            healthAuthIntent.putExtra( "Northern","Northern:\t" + countNorthernHA        );
            healthAuthIntent.putExtra(   "Canada","Canada:\t" +   countOutsideCa         );
            healthAuthIntent.putExtra("Vancouver","Vancouver:\t" + countVancouverCoastalHA);
            healthAuthIntent.putExtra(  "Coastal","Coastal:\t" + countVancouverIslandHA );
            startActivity(healthAuthIntent);
        });

        gender.setOnClickListener(gv -> {
            Intent genderIntent = new Intent(this, CasesGender.class);
            genderIntent.putExtra(   "male","male:\t" + maleCount  );
            genderIntent.putExtra( "female","female:\t" + femaleCount);
            genderIntent.putExtra("unknown","unknown:\t" + unknown    );
            startActivity(genderIntent);
        });

        ageGroup.setOnClickListener(agv -> {
            Intent ageIntent = new Intent(this, CasesAgeGroup.class);
            ageIntent.putExtra("lessThan10","Less than 10:\t\t"  + ageLessThan10Count);
            ageIntent.putExtra("to19"        ,"10 to 19:\t\t"    + age10To19Count);
            ageIntent.putExtra("to29"        ,"19 to 29:\t\t"    + age20To29Count);
            ageIntent.putExtra("to39"        ,"29 to 39:\t\t"    + age30To39Count);
            ageIntent.putExtra("to49"        ,"39 to 49:\t\t"    + age40To49Count);
            ageIntent.putExtra("to59"        ,"49 to 59:\t\t"    + age50To59Count);
            ageIntent.putExtra("to69"        ,"59 to 69:\t\t"    + age60To69Count);
            ageIntent.putExtra("to79"        ,"69 to 79:\t\t"    + age70To79Count);
            ageIntent.putExtra("to89"        ,"79 to 89:\t\t"    + age80To89Count);
            ageIntent.putExtra("plus90"      ,"+90:\t\t"         + ageMoreThan90);
            ageIntent.putExtra("unknown"     ,"unknown:\t\t"     + ageElse);
            startActivity(ageIntent);
        });
    }

    ValueEventListener valueEventListener = new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
            if (dataSnapshot.exists()) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    countGender(snapshot.child("Sex").getValue(String.class));
                    countAgeGroup(snapshot.child("Age_Group").getValue(String.class));
                    countHA(snapshot.child("HA").getValue(String.class));
                }

                monthYear.setVisibility(View.VISIBLE);
                healthAuthority .setVisibility(View.VISIBLE);
                gender.setVisibility(View.VISIBLE);
                ageGroup.setVisibility(View.VISIBLE);

                pb.setVisibility(View.GONE);
            }
        }
        @Override
        public void onCancelled(@NonNull DatabaseError error) {}
    };

    private void countGender(String genderValue) {
        if (Objects.equals(genderValue, "M")) {
            maleCount++;
        } else if (Objects.equals(genderValue, "F")) {
            femaleCount++;
        } else {
            unknown++;
        }
    }

    private void countHA(String HA) {
        if (Objects.equals(HA, "Fraser")) {
            countFraserHA++;
        } else if (Objects.equals(HA, "Interior")) {
            countInteriorHA++;
        } else if (Objects.equals(HA, "Northern")) {
            countNorthernHA++;
        } else if (Objects.equals(HA, "Vancouver Coastal")) {
            countVancouverCoastalHA++;
        } else if (Objects.equals(HA, "Vancouver Island")) {
            countVancouverIslandHA++;
        } else {
            countOutsideCa++;
        }
    }

    private void countAgeGroup(String ageGroupValue) {
        if (Objects.equals(ageGroupValue, "<10")) {
            ageLessThan10Count++;
        } else if (Objects.equals(ageGroupValue, "10-19")) {
            age10To19Count++;
        } else if (Objects.equals(ageGroupValue, "20-29")) {
            age20To29Count++;
        } else if (Objects.equals(ageGroupValue, "30-39")) {
            age30To39Count++;
        } else if (Objects.equals(ageGroupValue, "40-49")) {
            age40To49Count++;
        } else if (Objects.equals(ageGroupValue, "50-59")) {
            age50To59Count++;
        } else if (Objects.equals(ageGroupValue, "60-69")) {
            age60To69Count++;
        } else if (Objects.equals(ageGroupValue, "70-79")) {
            age70To79Count++;
        } else if (Objects.equals(ageGroupValue, "80-89")) {
            age80To89Count++;
        } else if (Objects.equals(ageGroupValue, "90+")) {
            ageMoreThan90++;
        } else {
            ageElse++;
        }
    }
}