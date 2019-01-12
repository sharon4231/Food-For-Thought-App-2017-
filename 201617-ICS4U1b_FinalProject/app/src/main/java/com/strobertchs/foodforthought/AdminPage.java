package com.strobertchs.foodforthought;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class AdminPage extends AppCompatActivity {
    Button loadEvent, saveEvent;
    EditText eventTxt;
    String Event;
    int data_block = 100;
    Button loadIncentive, saveIncentive;
    EditText incentiveTxt;
    String Incentive;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_page);

        saveEvent = (Button) findViewById(R.id.btnSubmitEvent);
        loadEvent = (Button) findViewById(R.id.testbutton);
        eventTxt = (EditText) findViewById(R.id.eventInput);

        saveEvent.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Event = eventTxt.getText().toString();
                //Saving Data
                //writing into file first must open file and then write
                //method must be inserted in a try catch block
                try {
                    //mode world_readable means data is available for reading in other applications
                    //opening file
                    FileOutputStream fou = openFileOutput("EventText.txt", MODE_APPEND);

                    //writing into the file
                    OutputStreamWriter osw = new OutputStreamWriter(fou);
                    try {
                        osw.write(Event + "\n");

                        osw.flush();
                        osw.close();
                        Toast.makeText(getBaseContext(), "Event  saved", Toast.LENGTH_SHORT).show();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }

            }
        });
        //opening file and getting text
        loadEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    FileInputStream fis = openFileInput("EventText.txt");
                    InputStreamReader isr = new InputStreamReader(fis);
                    char[] data = new char[data_block];
                    String finalEventData = "";
                    int size;
                    try {
                        while ((size = isr.read(data)) > 0) {
                            //reading one block of data and convert into string
                            String readEventData = String.copyValueOf(data, 0, size);
                            //must attach each block into final string
                            finalEventData += readEventData;
                            data = new char[data_block];

                        }
                        SharedPreferences prefs = getSharedPreferences("MY_APP", MODE_PRIVATE);
                        SharedPreferences.Editor editor = prefs.edit();
                        editor.putString("a", finalEventData);
                        editor.apply();

                        Toast.makeText(getBaseContext(), "Events Have Refreshed", Toast.LENGTH_SHORT).show();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }


            }
        });
        saveIncentive = (Button) (findViewById(R.id.btnSubmitIncentive));
        loadIncentive = (Button) (findViewById(R.id.btnLoadIncentive));
        incentiveTxt = (EditText) (findViewById(R.id.incentiveeditText));

        saveIncentive.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Incentive = incentiveTxt.getText().toString();
                //Saving Data
                //writing into file first must open file and then write
                //method must be inserted in a try catch block
                try {
                    //mode world_readable means data is available for reading in other applications
                    //opening file
                    FileOutputStream fou2 = openFileOutput("IncentiveText.txt", MODE_APPEND);

                    //writing into the file
                    OutputStreamWriter osw2 = new OutputStreamWriter(fou2);
                    try {
                        osw2.write(Incentive + "\n");

                        osw2.flush();
                        osw2.close();
                        Toast.makeText(getBaseContext(), "Incentive  saved", Toast.LENGTH_SHORT).show();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });
        //opening file and getting text
        loadIncentive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    FileInputStream fis2 = openFileInput("IncentiveText.txt");
                    InputStreamReader isr2 = new InputStreamReader(fis2);
                    char[] data = new char[data_block];
                    String finalIncentiveData = "";
                    int size;
                    try {
                        while ((size = isr2.read(data)) > 0) {
                            //reading one block of data and convert into string
                            String readEventData = String.copyValueOf(data, 0, size);
                            //must attach each block into final string
                            finalIncentiveData += readEventData;
                            data = new char[data_block];

                        }
                        SharedPreferences prefs2 = getSharedPreferences("MY_APP", MODE_PRIVATE);
                        SharedPreferences.Editor editor = prefs2.edit();
                        editor.putString("b", finalIncentiveData);
                        editor.apply();

                        Toast.makeText(getBaseContext(), "Events Have Refreshed", Toast.LENGTH_SHORT).show();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }


            }
        });
    }

}
