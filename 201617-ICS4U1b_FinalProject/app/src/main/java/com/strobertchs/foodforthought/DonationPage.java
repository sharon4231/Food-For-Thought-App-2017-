package com.strobertchs.foodforthought;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by ryanlui on 2016-12-06.
 */
public class DonationPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.donation_page);

        Button btn1 = (Button) findViewById(R.id.moneyBtn);

        btn1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(DonationPage.this, "Money", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(
                        DonationPage.this,
                        MoneyDonationPage.class);
                startActivity(i);

            }
        });

        Button btn2 = (Button) findViewById(R.id.foodBtn);

        btn2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(DonationPage.this, "Food", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(
                        DonationPage.this,
                        FoodDonationPage.class);
                startActivity(i);

            }
        });

        Button btn3 = (Button) findViewById(R.id.clothingBtn);

        btn3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(DonationPage.this, "Clothing", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(
                        DonationPage.this,
                        ClothingDonationPage.class);
                startActivity(i);

            }
        });

        Button btn4 = (Button) findViewById(R.id.historyBtn);

        btn4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(DonationPage.this, "History", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(
                        DonationPage.this,
                        DonationHistoryPage.class);
                startActivity(i);

            }
        });

        Button incentiveBtn = (Button) findViewById(R.id.goToIncentivebtn);

        incentiveBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent i = new Intent(DonationPage.this, Incentives.class);
                startActivity(i);

            }
        });

        TextView nameVariable = (TextView) findViewById(R.id.textViewEvent);
        SharedPreferences sp1 = getSharedPreferences("MY_APP", Context.MODE_PRIVATE);
        String output = sp1.getString("a", "");
        nameVariable.setText(output);

    }





    //Setting icon button
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_settings, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                Intent i=new Intent(DonationPage.this, SettingsActivity.class);
                startActivity(i);
                return true;

            default:
                return super.onOptionsItemSelected(item);

        }
    }
}