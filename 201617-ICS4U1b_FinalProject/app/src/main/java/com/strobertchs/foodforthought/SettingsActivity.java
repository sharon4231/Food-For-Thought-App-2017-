package com.strobertchs.foodforthought;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by sharo_000 on 2016-12-06.
 */
public class SettingsActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);

        //find buttons
        Button btn1 = (Button) findViewById(R.id.moneyBtn);
        Button btn2 = (Button) findViewById(R.id.foodBtn);
        Button btn3 = (Button) findViewById(R.id.clothingBtn);
        Button btn4 = (Button) findViewById(R.id.historyBtn);
        TextView nameVariable = (TextView) findViewById(R.id.textView3);
        TextView homeroomVariable = (TextView) findViewById(R.id.textView5);
        TextView usernameVariable = (TextView) findViewById(R.id.textView8);
        TextView passwordVariable = (TextView) findViewById(R.id.textView10);


        //make into onclicklisteners to switch between pages
        btn1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Toast.makeText(SettingsActivity.this, "Change Name", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(SettingsActivity.this, ChangeNameActivity.class);
                startActivity(i);

            }

        });

        btn2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(SettingsActivity.this, "Change Room", Toast.LENGTH_SHORT).show();
                Intent a = new Intent(SettingsActivity.this, ChangeRoomActivity.class);
                startActivity(a);
            }

        });

        btn3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(SettingsActivity.this, "Change Username", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(SettingsActivity.this, ChangeUsernameActivity.class);
                startActivity(i);
            }

        });

        btn4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(SettingsActivity.this, "Change Password", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(SettingsActivity.this, ChangePasswordActivity.class);
                startActivity(i);
            }

        });

        SharedPreferences sp1 = getSharedPreferences("MY_APP", Context.MODE_PRIVATE);
        String defaultUsername = sp1.getString("USER_NAME", "");
        String defaultPersonName = sp1.getString("PERSON_NAME", "");
        String defaultPassword = sp1.getString("PASS", "");
        String defaultHomeroom = sp1.getString("HOME_ROOM", "");

        usernameVariable.setText(defaultUsername);
        nameVariable.setText(defaultPersonName);
        passwordVariable.setText(defaultPassword);
        homeroomVariable.setText(defaultHomeroom);
    }
}

