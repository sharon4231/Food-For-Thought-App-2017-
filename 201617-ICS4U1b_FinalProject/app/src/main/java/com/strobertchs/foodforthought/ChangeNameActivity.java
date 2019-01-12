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
 * Created by sharo_000 on 2016-12-06.
 */

public class ChangeNameActivity extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.change_name);


        Button btnOK = (Button) findViewById(R.id.ok1);
        Button btnCancel = (Button) findViewById(R.id.cancel1);

        btnOK.setOnClickListener(this);
        btnCancel.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.ok1:
                Toast.makeText(ChangeNameActivity.this, "Name Updated", Toast.LENGTH_SHORT).show();
                EditText newName = (EditText) findViewById(R.id.editNewName);

                SharedPreferences prefs = getSharedPreferences("MY_APP", MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();
                editor.putString("PERSON_NAME", newName.getText().toString());
                editor.apply();

                Intent c = new Intent(ChangeNameActivity.this, SettingsActivity.class);
                startActivity(c);
                break;

            case R.id.cancel1:
                finish();
                break;
        }
    }
}


