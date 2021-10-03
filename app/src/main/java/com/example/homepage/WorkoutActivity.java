package com.example.homepage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class WorkoutActivity extends AppCompatActivity {
    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout);

        spinner = findViewById(R.id.spinner1);

        List<String> categories = new ArrayList<>();
        categories.add(0, "Choose Category");
        categories.add("Age 18 - 30");
        categories.add("Age 30 - 50");
        categories.add("Age 50+");

        ArrayAdapter<String> dataAdapter;
        dataAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, categories);

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item);

        spinner.setAdapter(dataAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(parent.getItemAtPosition(position).equals("Choose category"))
                {
                    //nothing
                }
                else
                {
                    String item = parent.getItemAtPosition(position).toString();

                    Toast.makeText(parent.getContext(), "Selected: "+ item, Toast.LENGTH_SHORT).show();

                    //additional part
                    if (parent.getItemAtPosition(position).equals("Age 18 - 30"))
                    {
                        Intent intent = new Intent(WorkoutActivity.this, item_select1.class);
                        startActivity(intent);
                    }

                    if (parent.getItemAtPosition(position).equals("Age 30 - 50"))
                    {
                        Intent intent = new Intent(WorkoutActivity.this, item_select2.class);
                        startActivity(intent);
                    }

                    if (parent.getItemAtPosition(position).equals("Age 50+"))
                    {
                        Intent intent = new Intent(WorkoutActivity.this, com.example.homepage.item_select3.class);
                        startActivity(intent);
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

}