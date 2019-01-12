package com.strobertchs.foodforthought;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by fliwong on 2016-12-05.
 */
public class ProfileCreation extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.creation_profile);


        Button btnCreateProfile = (Button)findViewById(R.id.button5);
        btnCreateProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText userName = (EditText) findViewById(R.id.editTextUserName);
                EditText personName = (EditText) findViewById(R.id.editTextName);
                EditText password = (EditText) findViewById(R.id.editTextPassword);
                EditText homeroom = (EditText) findViewById(R.id.editTextHomeroom);

                SharedPreferences prefs = getSharedPreferences("MY_APP", MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();
                editor.putString("USER_NAME", userName.getText().toString());
                editor.putString("PERSON_NAME", personName.getText().toString());
                editor.putString("PASS", password.getText().toString());
                editor.putString("HOME_ROOM", homeroom.getText().toString());
                editor.commit();

                Intent i=new Intent(ProfileCreation.this, DonationPage.class);
                startActivity(i);

            }
        });


    }
}

