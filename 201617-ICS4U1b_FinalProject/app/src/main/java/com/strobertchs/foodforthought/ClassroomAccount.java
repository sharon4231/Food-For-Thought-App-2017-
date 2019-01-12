package com.strobertchs.foodforthought;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class ClassroomAccount extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.account_classroom);

    }
    public void teacherName(View v) {
        EditText teacher = (EditText) findViewById(R.id.editTextTeacher);
        String strTeacher = teacher.getText().toString();
    }
    public void classNum(View v) {
        EditText classroom = (EditText) findViewById(R.id.editTextClass);
        String strClass = classroom.getText().toString();
    }
}
