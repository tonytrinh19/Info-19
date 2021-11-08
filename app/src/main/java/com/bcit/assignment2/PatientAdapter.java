package com.bcit.assignment2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


// Ended up not needing to parse data, might remove later.

public class PatientAdapter extends RecyclerView.Adapter<PatientAdapter.PatientViewHolder> {

    private Context mCtx;
    private List<Patient> PatientList;

    public PatientAdapter(Context mCtx, List<Patient> PatientList) {
        this.mCtx = mCtx;
        this.PatientList = PatientList;
    }

    @NonNull
    @Override
    public PatientViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mCtx).inflate(R.layout.recyclerview_patients, parent, false);
        return new PatientViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PatientViewHolder holder, int position) {
        Patient Patient = PatientList.get(position);

        holder.textViewAge_Group.setText("Age Group: " + Patient.ageGroup);
        holder.textViewClassification_Reported.setText("Classification: " + Patient.classificationReported);
        holder.textViewHA.setText("Health Authority: " + Patient.healthAuthority);
        holder.textViewReported_Date.setText("Reported Date: " + Patient.reportedDate);
        holder.textViewSex.setText("Sex: " + Patient.sex);
    }

    @Override
    public int getItemCount() {
        return PatientList.size();
    }

    class PatientViewHolder extends RecyclerView.ViewHolder {

        TextView textViewAge_Group, textViewClassification_Reported,
                textViewHA, textViewReported_Date, textViewSex;

        public PatientViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewAge_Group = itemView.findViewById(R.id.Age_Group);
            textViewClassification_Reported= itemView.findViewById(R.id.Classification_Reported);
            textViewHA = itemView.findViewById(R.id.HA);
            textViewReported_Date = itemView.findViewById(R.id.Reported_Date);
            textViewSex = itemView.findViewById(R.id.Sex);
        }
    }
}
