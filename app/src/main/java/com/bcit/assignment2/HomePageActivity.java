package com.bcit.assignment2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

public class HomePageActivity extends AppCompatActivity {
    // 93193
    static int maleCount = 0;
    // 88479
    static int femaleCount = 0;
    // 244
    static int unknown = 0;

    // 14924
    static int ageLessThan10Count;
    // 0
    static int age10To19Count;
    // 44653
    static int age20To29Count;
    // 38471
    static int age30To39Count;
    // 29573
    static int age40To49Count;
    // 24180
    static int age50To59Count;
    // 15801
    static int age60To69Count;
    // 8102
    static int age70To79Count;
    // 4290
    static int age80To89Count;
    // 1890
    static int ageMoreThan90;
    // 32 ???
    static int ageElse;

    // Fraser 92184
    static int countFraserHA;
    // Interior 26824
    static int countInteriorHA;
    // Northern 13397
    static int countNorthernHA;
    // Vancouver Coastal 39869
    static int countVancouverCoastalHA;
    // Vancouver Island 9348
    static int countVancouverIslandHA;
    // else ? 294
    static int countOutsideCa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Query q = FirebaseDatabase.getInstance().getReference();
        q.addListenerForSingleValueEvent(valueEventListener);
        // Load the buttons and contents after finish querying
        // Add a progress bar here
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);



        Button monthYear = findViewById(R.id.mon_year_but);
        Button healthAuthority = findViewById(R.id.health_auth_button);
        Button gender = findViewById(R.id.gender_button);
        Button ageGroup = findViewById(R.id.age_group_button);

        monthYear.setOnClickListener(myv -> {
            Intent timeIntent = new Intent(this, CasesMonthYear.class);
            startActivity(timeIntent);
        });

        healthAuthority.setOnClickListener(hav -> {
            Intent healthAuthIntent = new Intent(this, CasesHealthAuthority.class);
            healthAuthIntent.putExtra(   "Fraser", "Fraser:\t" +   countFraserHA          );
            healthAuthIntent.putExtra( "Interior", "Interior:\t" + countInteriorHA        );
            healthAuthIntent.putExtra( "Northern", "Northern:\t" + countNorthernHA        );
            healthAuthIntent.putExtra(   "Canada", "Canada:\t" +   countOutsideCa         );
            healthAuthIntent.putExtra("Vancouver", "Vancouver:\t" + countVancouverCoastalHA);
            healthAuthIntent.putExtra(  "Coastal", "Coastal:\t" + countVancouverIslandHA );

            startActivity(healthAuthIntent);
        });

        gender.setOnClickListener(gv -> {
            Intent genderIntent = new Intent(this, CasesGender.class);
            genderIntent.putExtra(     "male",  "male:\t" + maleCount  );
            genderIntent.putExtra(   "female",  "female:\t" + femaleCount);
            genderIntent.putExtra(  "unknown",  "unknown:\t" + unknown    );
            startActivity(genderIntent);
        });

        ageGroup.setOnClickListener(agv -> {
            Intent ageIntent = new Intent(this, CasesAgeGroup.class);
            ageIntent.putExtra("lessThan10" ,   "lessThan10:\t" + ageLessThan10Count);
            ageIntent.putExtra("to19"       ,   "to19:\t" + age10To19Count);
            ageIntent.putExtra("to29"       ,   "to29:\t" + age20To29Count);
            ageIntent.putExtra("to39"       ,   "to39:\t" + age30To39Count);
            ageIntent.putExtra("to49"       ,   "to49:\t" + age40To49Count);
            ageIntent.putExtra("to59"       ,   "to59:\t" + age50To59Count);
            ageIntent.putExtra("to69"       ,   "to69:\t" + age60To69Count);
            ageIntent.putExtra("to79"       ,   "to79:\t" + age70To79Count);
            ageIntent.putExtra("to89"       ,   "to89:\t" + age80To89Count);
            ageIntent.putExtra("plus90"     ,   "plus90:\t" + ageMoreThan90);
            ageIntent.putExtra("unknown"    ,   "unknown:\t" + ageElse);
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
                // After query
                System.out.println("MALE COUNT:" + maleCount);
                System.out.println("FEMALE COUNT:" + femaleCount);
                System.out.println("UNKNOWN COUNT:" + unknown);

                System.out.println("AGE <10:" +   ageLessThan10Count);
                System.out.println("AGE age10To19Count:" + age10To19Count);
                System.out.println("AGE age20To29Count:" + age20To29Count);
                System.out.println("AGE age30To39Count:" + age30To39Count);
                System.out.println("AGE age40To49Count:" + age40To49Count);
                System.out.println("AGE age50To59Count:" + age50To59Count);
                System.out.println("AGE age60To69Count:" + age60To69Count);
                System.out.println("AGE age70To79Count:" + age70To79Count);
                System.out.println("AGE age80To89Count:" + age80To89Count);
                System.out.println("AGE ageMoreThan90:" + ageMoreThan90);
                System.out.println("AGE ageElse:" + ageElse);

                System.out.println("HA countFraserHA: " + countFraserHA);
                System.out.println("HA countInteriorHA: " + countInteriorHA);
                System.out.println("HA countNorthernHA: " + countNorthernHA);
                System.out.println("HA countVancouverCoastalHA: " + countVancouverCoastalHA);
                System.out.println("HA countVancouverIslandHA: " + countVancouverIslandHA);
                System.out.println("HA outsideCanada: " + countOutsideCa);
            }
        }

        @Override
        public void onCancelled(@NonNull DatabaseError error) {

        }
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