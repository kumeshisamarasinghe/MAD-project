package com.example.homepage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class NotebookDetailsActivity extends AppCompatActivity {

    CardView fatNoteDetails;
    CardView calorieNoteDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notebook_details);

        fatNoteDetails = (CardView) findViewById(R.id.fatNoteDetails);
        calorieNoteDetails = (CardView) findViewById(R.id.calorieNoteDetails);

        fatNoteDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FatNoteDetailsActivity();
            }
        });

        calorieNoteDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CalorieNoteDetailsActivity();
            }
        });
    }

    public void FatNoteDetailsActivity(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }

    public void CalorieNoteDetailsActivity(){
        Intent intent = new Intent(this, CalorieActivity.class);
        startActivity(intent);

    }
}