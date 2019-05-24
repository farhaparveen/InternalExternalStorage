package com.example.internalexternalstorage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class SecondActivity extends AppCompatActivity {
    EditText editText;
    Button button, button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        button = findViewById(R.id.loadBtn);
        editText = findViewById(R.id.editTextid);
        button2 = findViewById(R.id.previousBtn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    FileInputStream inputStream = openFileInput("aizah.txt");//open the file for reading purpose
                    int r = -1;//when we read data from file it returns integer value of each character read so if integer value of charactere is -1 it means there is no data in file
                    String data = "";

                    while ((r = inputStream.read()) != -1) {
                        data = data + (char) r;//reading single character from file and appending with data string to get whole data
                    }
                    editText.setText(data);//set the data received in edittext
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }


            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SecondActivity.this, MainActivity.class));
            }
        });

    }
}
