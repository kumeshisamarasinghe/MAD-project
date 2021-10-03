package com.example.homepage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class HomeActivity extends AppCompatActivity {

    CardView cardView;
    CardView calShow;
    CardView dietshowid;
    CardView noteBookid;
    CardView waterDetailsid;
    CardView feebackDetailsid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        cardView = (CardView) findViewById(R.id.bankcardId);
        calShow = (CardView) findViewById(R.id.calShow);
        dietshowid = (CardView) findViewById(R.id.dietshowid);
        noteBookid = (CardView) findViewById(R.id.noteBookid);
        waterDetailsid = (CardView) findViewById(R.id.waterDetailsid);
        feebackDetailsid = (CardView) findViewById(R.id.feebackDetailsid);


        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirstActivity();
            }
        });

        calShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CalShowActivity();
            }
        });

        dietshowid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DietShowActivity();
            }
        });

        noteBookid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NoteBookIdActivity();
            }
        });

        waterDetailsid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                WaterDetailsActivity();
            }
        });

        feebackDetailsid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FeedbackDetailsActivity();
            }
        });


    }

    public void FirstActivity(){
        Intent intent = new Intent(this, WorkoutActivity.class);
        startActivity(intent);

    }

    public void CalShowActivity(){
        Intent intent = new Intent(this, CalculatorsShow.class);
        startActivity(intent);

    }

    public void DietShowActivity(){
        Intent intent = new Intent(this, DietActivity.class);
        startActivity(intent);

    }
    public void NoteBookIdActivity(){
        Intent intent = new Intent(this, NotebookDetailsActivity.class);
        startActivity(intent);

    }

    public void WaterDetailsActivity(){
        Intent intent = new Intent(this, WaterMainActivity.class);
        startActivity(intent);

    }

    public void FeedbackDetailsActivity(){
        Intent intent = new Intent(this, FeedbackActivity.class);
        startActivity(intent);

    }
}