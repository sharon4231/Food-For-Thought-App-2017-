package com.strobertchs.foodforthought;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by sharo_000 on 2016-12-07.
 */
public class ChangeUsernameActivity extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.change_username);


        Button btnOK = (Button) findViewById(R.id.ok3);
        Button btnCancel = (Button) findViewById(R.id.cancel3);

        btnOK.setOnClickListener(this);
        btnCancel.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.ok3:
                Toast.makeText(ChangeUsernameActivity.this, "Username Updated", Toast.LENGTH_SHORT).show();
                EditText newUsername = (EditText) findViewById(R.id.editNewUsername);

                SharedPreferences prefs = getSharedPreferences("MY_APP", MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();
                editor.putString("USER_NAME", newUsername.getText().toString());
                editor.apply();

                Intent c = new Intent(ChangeUsernameActivity.this, SettingsActivity.class);
                startActivity(c);
                break;

            case R.id.cancel3:
                finish();
                break;
        }
    }
}
