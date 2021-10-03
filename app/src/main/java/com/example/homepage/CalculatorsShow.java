package com.example.homepage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class CalculatorsShow extends AppCompatActivity {

    CardView fatCalculatorid;
    CardView calorieCalculatorid;
    CardView bmiCalShow;
    CardView hrateCalculatorid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculators_show);

        fatCalculatorid = (CardView) findViewById(R.id.fatCalculatorid);
        calorieCalculatorid = (CardView) findViewById(R.id.calorieCalculatorid);
        bmiCalShow = (CardView) findViewById(R.id.bmiCalShow);
        hrateCalculatorid = (CardView) findViewById(R.id.hrateCalculatorid);

        fatCalculatorid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FatCalculatorActivity();
            }
        });

        calorieCalculatorid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CalorieCalculatorActivity();
            }
        });

        bmiCalShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BmiCalShowActivity();
            }
        });

        hrateCalculatorid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HrateCalShowActivity();
            }
        });

    }

    public void FatCalculatorActivity(){
        Intent intent = new Intent(this, FatCalcActivity.class);
        startActivity(intent);

    }

    public void CalorieCalculatorActivity(){
        Intent intent = new Intent(this, CalorieCalculator.class);
        startActivity(intent);

    }

    public void BmiCalShowActivity(){
        Intent intent = new Intent(this, splash.class);
        startActivity(intent);

    }

    public void HrateCalShowActivity(){
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);

    }
}