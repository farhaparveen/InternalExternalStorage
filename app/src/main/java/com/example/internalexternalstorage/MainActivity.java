package com.example.internalexternalstorage;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button button, next;
    File file;//file object is used to find the location of file where data is saved

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.editTextid);
        button = findViewById(R.id.saveBtn);
        next = findViewById(R.id.nextbtn);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SecondActivity.class));
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FileOutputStream f = null;
                try {
                    file = getFilesDir();
                    f = openFileOutput("aizah.txt", Context.MODE_PRIVATE);//this will open the file with filename aizah for writing purpose
                    String data = editText.getText().toString();//getting the data from edittxt which returns string
                    f.write(data.getBytes());//data in file are saved as bytestream so we need to convert string into bytestream
                    Toast.makeText(MainActivity.this, "data saved " + file.toString(), Toast.LENGTH_SHORT).show();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        f.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });


    }
}
