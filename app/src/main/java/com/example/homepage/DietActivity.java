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

public class DietActivity extends AppCompatActivity {

    private Spinner spinner2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.diet_main);

        spinner2 = findViewById(R.id.spinner2);

        List<String> categories = new ArrayList<>();
        categories.add(0, "Choose Category");
        categories.add("Between age 18 - 29");
        categories.add("Between age 30 - 50");
        categories.add("50+");

        ArrayAdapter<String> dataAdapter;
        dataAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,categories);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item);

        spinner2.setAdapter(dataAdapter);

        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long i) {
                if(parent.getItemAtPosition(position).equals("Choose Category"))
                {

                }
                else{
                    String item = parent.getItemAtPosition(position).toString();

                    Toast.makeText(parent.getContext(),"Selected:"+ item,Toast.LENGTH_SHORT).show();

                    if(parent.getItemAtPosition(position).equals("Between age 18 - 29"))
                    {
                        Intent intent = new Intent(DietActivity.this, com.example.homepage.diet_select.class);
                        startActivity(intent);
                    }
                    else if(parent.getItemAtPosition(position).equals("Between age 30 - 50"))
                    {
                        Intent intent = new Intent(DietActivity.this, com.example.homepage.dietselect2.class);
                        startActivity(intent);
                    }
                    else if(parent.getItemAtPosition(position).equals("50+"))
                    {
                        Intent intent = new Intent(DietActivity.this, com.example.homepage.diet_select.class);
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