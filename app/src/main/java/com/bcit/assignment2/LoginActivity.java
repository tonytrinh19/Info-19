package com.bcit.assignment2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.Iterator;

public class LoginActivity extends AppCompatActivity {

    EditText editEmail;
    EditText editPassword;
    ProgressBar progressBar;
    Button btnLogin;
    TextView tvCreateNewAccount;

    FirebaseAuth fAuth;

    private ArrayList<Patient> _patientList;
    private DatabaseReference mDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editEmail = findViewById(R.id.editEmail);
        editPassword = findViewById(R.id.editPassword);
        progressBar = findViewById(R.id.progressBar);
        btnLogin = findViewById(R.id.btnLogin);
        tvCreateNewAccount = findViewById(R.id.tvCreateNewAccount);

        fAuth = FirebaseAuth.getInstance();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = editEmail.getText().toString().trim();
                String password = editPassword.getText().toString().trim();

                if (TextUtils.isEmpty(email)) {
                    editEmail.setError("Email is required");
                    return;
                }

                if (TextUtils.isEmpty(password)) {
                    editEmail.setError("Password is required");
                    return;
                }

                if (password.length() < 6) {
                    editEmail.setError("Password must be >= 6 characters.");
                    return;
                }

                progressBar.setVisibility(View.VISIBLE);

                //authenticate user
                fAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(LoginActivity.this, "Login successful!", Toast.LENGTH_LONG).show();
                            startActivity(new Intent(getApplicationContext(), HomePageActivity.class));
                        } else {
                            Toast.makeText(LoginActivity.this, "ERROR: " + task.getException().getMessage(), Toast.LENGTH_LONG).show();
                            progressBar.setVisibility(View.GONE);
                        }
                    }
                });

            }
        });

        tvCreateNewAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), RegisterActivity.class));
            }
        });


        _patientList = new ArrayList<Patient>();

        // Get the db ref
//        mDatabase = FirebaseDatabase.getInstance().getReference();

//        mDatabase.get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
//            @Override
//            public void onComplete(@NonNull Task<DataSnapshot> task) {
//                if (!task.isSuccessful()) {
//                    Log.e("firebase", "Error getting data", task.getException());
//                } else {
//                    System.out.println("Hey ma im here");
//                    for (DataSnapshot currentItem : task.getResult().getChildren()) {
//                        System.out.print(currentItem);
//                        Patient newPatient = new Patient(currentItem.child("Age_Group").getValue(String.class),
//                                currentItem.child("Classification_Reported").getValue(String.class),
//                                currentItem.child("HA").getValue(String.class),
//                                currentItem.child("Reported_Date").getValue(String.class),
//                                currentItem.child("Sex").getValue(String.class));
//                        _patientList.add(newPatient);
//                    }
//                    System.out.println(_patientList);
////                    Log.d("firebase", String.valueOf(task.getResult().getValue()));
//                }
//            }
//        });
    }

}