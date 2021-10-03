package com.example.homepage;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class FatCalcActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fat_calc);


        // Get the references to the widgets
        final EditText e1 = (EditText) findViewById(R.id.et1);
        final EditText e2 = (EditText) findViewById(R.id.et2);
        final TextView tv4 = (TextView) findViewById(R.id.tv4);

        findViewById(R.id.ib1).setOnClickListener(new View.OnClickListener() {

            // Logic for validation, input can't be empty
            @Override
            public void onClick(View v) {
                String str1 = e1.getText().toString();
                String str2 = e2.getText().toString();

                if(TextUtils.isEmpty(str1)){
                    e1.setError("Please enter your weight");
                    e1.requestFocus();
                    return;
                }

                if(TextUtils.isEmpty(str2)){
                    e2.setError("Please enter your height");
                    e2.requestFocus();
                    return;
                }
//Get the user values from the widget reference
                float weight = Float.parseFloat(str1);
                float height = Float.parseFloat(str2)/100;

//Calculate Fat value
                float fatValue = calculateFAT(weight, height);

//Define the meaning of the Fat value
                String fatInterpretation = interpretFAT(fatValue);

                tv4.setText(String.valueOf(fatValue + "-" + fatInterpretation));

            }
        });



    }


    //Calculate Fat
    private float calculateFAT (float weight, float height) {
        return (float) (1.2*(weight / (height * height)));
    }

    // Interpret what Fat means
    private String interpretFAT(float fatValue) {

        if (fatValue < 19.2) {
            return "Severely Low Fat";
        } else if (fatValue < 22.2) {

            return "Low Fat";
        } else if (fatValue < 30) {

            return "Fat Percentage is Normal";
        } else if (fatValue < 36) {

            return "High Fat Percentage";
        } else {
            return "Obese";
        }
    }
}