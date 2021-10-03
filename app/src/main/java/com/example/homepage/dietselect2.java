package com.example.homepage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class dietselect2 extends AppCompatActivity {

    Button backd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dietselect2);

        backd = findViewById(R.id.backd);

        backd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(dietselect2.this, com.example.homepage.DietActivity.class);
                startActivity(intent);
            }
        });
    }
}