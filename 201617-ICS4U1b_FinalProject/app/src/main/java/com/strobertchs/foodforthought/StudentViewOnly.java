package com.strobertchs.foodforthought;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by fliwong on 2017-01-20.
 */
public class StudentViewOnly extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_only_student);

        TextView eventVariable = (TextView) findViewById(R.id.textView36);
        SharedPreferences sp4 = getSharedPreferences("MY_APP", Context.MODE_PRIVATE);
        String output3 = sp4.getString("a", "");
        eventVariable.setText(output3);

        TextView incentiveVariable = (TextView) findViewById(R.id.textView43);
        SharedPreferences sp2 = getSharedPreferences("MY_APP", Context.MODE_PRIVATE);
        String output2 = sp2.getString("b", "");
        incentiveVariable.setText(output2);


    }
}
