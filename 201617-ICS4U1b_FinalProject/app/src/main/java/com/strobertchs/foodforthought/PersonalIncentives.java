package com.strobertchs.foodforthought;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by fliwong on 2017-01-24.
 */

public class PersonalIncentives extends AppCompatActivity{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.personal_incentives);

        TextView incentiveVariable = (TextView) findViewById(R.id.textView39);
        SharedPreferences sp2 = getSharedPreferences("MY_APP", Context.MODE_PRIVATE);
        String output2 = sp2.getString("b", "");
        incentiveVariable.setText(output2);
    }
}
