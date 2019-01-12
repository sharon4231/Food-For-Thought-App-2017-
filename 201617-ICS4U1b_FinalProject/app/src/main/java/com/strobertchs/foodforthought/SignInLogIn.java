package com.strobertchs.foodforthought;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by sharo_000 on 2017-01-12.
 */
public class SignInLogIn extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_or_log_in);

        Button btn7 = (Button) findViewById(R.id.button7);
        Button btn6 = (Button) findViewById(R.id.button6);

        Button btn2 = (Button) findViewById(R.id.button2);

        btn7.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                EditText username = (EditText) findViewById(R.id.editText);
                EditText password = (EditText) findViewById(R.id.editText2);

                String a = username.getText().toString();
                String b = password.getText().toString();

                SharedPreferences sp1 = getSharedPreferences("MY_APP", Context.MODE_PRIVATE);
                String defaultUsername = sp1.getString("USER_NAME", "");
                String defaultPassword = sp1.getString("PASS", "");

                if ((a.equals(defaultUsername)) && (b.equals(defaultPassword))) {
                    Intent i = new Intent(SignInLogIn.this, DonationPage.class);
                    startActivity(i);
                }
                else {
                    Toast.makeText(SignInLogIn.this, "Username and Password don't match", Toast.LENGTH_LONG).show();
                }
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = new Intent(SignInLogIn.this, ProfileCreation.class);
                startActivity(i);
            }
        });

        Button btn8 = (Button) findViewById(R.id.signInbtn);
        btn8.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                EditText homeroom = (EditText) findViewById(R.id.editTextHomeroom);

                String c = homeroom.getText().toString();
                SharedPreferences sp3 = getSharedPreferences("MY_APP", Context.MODE_PRIVATE);
                String defaultHomeroom = sp3.getString("HOME_ROOM", "");

                if (c.equals(defaultHomeroom)) {
                    Intent i = new Intent(SignInLogIn.this, StudentViewOnly.class);
                    startActivity(i);
                } else {
                    Toast.makeText(SignInLogIn.this, "Homeroom doesn't match", Toast.LENGTH_LONG).show();
                }
            }
        });



        btn2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = new Intent(SignInLogIn.this, AdminLogin.class);
                startActivity(i);
            }
        });
    }
}
