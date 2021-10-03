package com.example.homepage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class diet_select extends AppCompatActivity {

    Button backd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diet_select);

        backd = findViewById(R.id.backd);

        backd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(diet_select.this, com.example.homepage.DietActivity.class);
                startActivity(intent);
            }
        });


    }
}