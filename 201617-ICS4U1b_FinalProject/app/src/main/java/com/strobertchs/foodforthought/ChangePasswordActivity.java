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
public class ChangePasswordActivity extends AppCompatActivity implements View.OnClickListener{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.change_password);

        Button btnOK = (Button) findViewById(R.id.ok4);
        Button btnCancel = (Button) findViewById(R.id.cancel4);

        btnOK.setOnClickListener(this);
        btnCancel.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.ok4:
                Toast.makeText(ChangePasswordActivity.this, "Password Updated", Toast.LENGTH_SHORT).show();
                EditText newPassword = (EditText) findViewById(R.id.editNewPassword);

                SharedPreferences prefs = getSharedPreferences("MY_APP", MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();
                editor.putString("PASS", newPassword.getText().toString());
                editor.apply();

                Intent c = new Intent(ChangePasswordActivity.this, SettingsActivity.class);
                startActivity(c);
                break;

            case R.id.cancel4:
                finish();
                break;
        }

    }
}