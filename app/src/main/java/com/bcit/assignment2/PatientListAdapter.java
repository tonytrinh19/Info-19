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

//    public PatientListAdapter(Context context, int resource, List<Patient> objects, Activity context1, List<Patient> patientList) {
//
//        super(context, resource, objects);
//
//        this.context = context1;
//
//        this.patientList = patientList;
//
//    }


//    @NonNull
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//
//        LayoutInflater inflater = context.getLayoutInflater();
//
//
//        View listViewItem = inflater.inflate(R.layout.list_layout, null, true);
//
//
//        TextView tvName = listViewItem.findViewById(R.id.textViewName);
//
//        TextView tvSchool = listViewItem.findViewById(R.id.textViewSchool);
//
//
//        Patient student = patientList.get(position);
//
//        tvName.setText(student.getPatientFirstName()
//
//                + " " + student.getPatientLastName());
//
//        tvSchool.setText(student.getSchool());
//
//
//        return listViewItem;
//
//    }

}
