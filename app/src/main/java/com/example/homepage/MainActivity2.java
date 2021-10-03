package com.example.homepage;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {
    EditText et_age;
    RadioButton rd_btn_M;
    RadioButton rd_btn_B;
    Button btn_calculate;
    TextView tv_answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        et_age = findViewById(R.id.et_age);
        rd_btn_M = findViewById(R.id.rd_btn_M);
        rd_btn_B = findViewById(R.id.rd_btn_B);
        btn_calculate = findViewById(R.id.btn_calculate);
        tv_answer = findViewById(R.id.tv_answer);
    }

    @Override
    protected void onResume() {
        super.onResume();
        btn_calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateAnswer(view);

            }
        });
    }

    public void calculateAnswer(View view){
       com.example.homepage.Calculation cal = new com.example.homepage.Calculation();
       String value = et_age.getText().toString();
       if(TextUtils.isEmpty(value)){
           Toast.makeText(this, "Enter your value", Toast.LENGTH_SHORT).show();
       }else {
          Integer age = Integer.parseInt(value);
           if (rd_btn_M.isChecked()){
              age =  cal.convertAgeToMaximumHeartRate(age);
           }else if (rd_btn_B.isChecked()){
               age = cal.convertAgeToMHR(age);
           }else {
               Toast.makeText(this, "Select the button", Toast.LENGTH_SHORT).show();
               age = 0;
           }

           tv_answer.setText(new Integer(age).toString());
       }
    }

}