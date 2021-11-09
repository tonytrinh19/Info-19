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

public class StudentListAdapter extends ArrayAdapter<Student> {

    private Activity context;

    private List<Student> studentList;


    public StudentListAdapter(Activity context, List<Student> studentList) {

        super(context, R.layout.list_layout, studentList);

        this.context = context;

        this.studentList = studentList;

    }


    public StudentListAdapter(Context context, int resource, List<Student> objects, Activity context1, List<Student> studentList) {

        super(context, resource, objects);

        this.context = context1;

        this.studentList = studentList;

    }


    @NonNull

    @Override

    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = context.getLayoutInflater();


        View listViewItem = inflater.inflate(R.layout.list_layout, null, true);


        TextView tvName = listViewItem.findViewById(R.id.textViewName);

        TextView tvSchool = listViewItem.findViewById(R.id.textViewSchool);


        Student student = studentList.get(position);

        tvName.setText(student.getStudentFirstName()

                + " " + student.getStudentLastName());

        tvSchool.setText(student.getSchool());


        return listViewItem;

    }

}
