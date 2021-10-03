package com.example.homepage;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CalorieCalculator extends AppCompatActivity {

    EditText height;
    EditText weight;
    EditText age;
    Button btn;
    TextView result;
    String calculation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator_calorie);

        //get the values to the variables
        height = findViewById(R.id.height);
        weight = findViewById(R.id.weight);
        age = findViewById(R.id.age);
        btn = findViewById(R.id.btn);
        result = findViewById(R.id.result);
    }


        public void calculateCalorie (View view){
            String W = weight.getText().toString();
            String H = height.getText().toString();
            String A = age.getText().toString();

            //do validations
            if(TextUtils.isEmpty(A)){
                age.setError("Please enter your age");
                age.requestFocus();
                return;
            }

            if(TextUtils.isEmpty(W)){
                weight.setError("Please enter your weight");
                weight.requestFocus();
                return;
            }

            if(TextUtils.isEmpty(H)){
                height.setError("Please enter your height");
                height.requestFocus();
                return;
            }

            //get the values
            float weightValue = Float.parseFloat(W);
            float heightValue = Float.parseFloat(H);
            float ageValue = Float.parseFloat(A);

            //calculation to get calorie amount
            float calorie = (float) (((10 * weightValue) + (6.25 * heightValue) - (5 * ageValue)  - 161) * 1.2);

            calculation =  "Result:\n\n " + calorie + "\n" + "calories";

            result.setText(calculation);





    }
}

