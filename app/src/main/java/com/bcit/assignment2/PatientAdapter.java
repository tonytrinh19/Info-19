package com.bcit.assignment2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

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
        holder.textViewYear.setText(Patient.reportedDate);
        holder.textViewMonth.setText(Patient.reportedDate);
    }

    @Override
    public int getItemCount() {
        return PatientList.size();
    }

    class PatientViewHolder extends RecyclerView.ViewHolder {

        TextView textViewYear, textViewMonth;

        public PatientViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewYear = itemView.findViewById(R.id.text_view_year);
            textViewMonth = itemView.findViewById(R.id.text_view_month);
        }
    }
}
