package com.strobertchs.foodforthought;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by fliwong on 2017-01-20.
 */

public class Incentives extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_incentives);

        Button btn5 = (Button) findViewById(R.id.Incentivesbutton);

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Incentives.this, PersonalIncentives.class);
                        startActivity(i);
            }
        });
    }
}