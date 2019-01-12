package com.strobertchs.foodforthought;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by ryanlui on 2017-01-22.
 */
public class AdminLogin extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_login);

        final EditText adminUsername = (EditText) findViewById(R.id.editTextAdminUsername);
        final EditText adminPassword = (EditText) findViewById(R.id.editTextAdminPassword);

        Button btnAdminLogin = (Button)findViewById(R.id.buttonAdminLogin);
        btnAdminLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = adminUsername.getText().toString();
                String password = adminPassword.getText().toString();

                if ((username.equals("Admin123") && password.equals("123"))) {
                    Toast.makeText(AdminLogin.this, "Login Successful", Toast.LENGTH_SHORT).show();
                    Intent i=new Intent(
                            AdminLogin.this,
                            AdminPage.class);
                    startActivity(i);
                } else{
                    Toast.makeText(AdminLogin.this, "Login Failed, wrong username or password", Toast.LENGTH_SHORT).show();

                }


            }
        });
    }
}
