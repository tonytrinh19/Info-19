package com.bcit.assignment2;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

public class PatientListAdapter extends ArrayAdapter<Patient> {

    private Activity context;
    private List<Patient> patientList;


    public PatientListAdapter(Activity context, List<Patient> patientList) {

        super(context, R.layout.list_layout, patientList);

        this.context = context;

        this.patientList = patientList;
    }
}
