package com.example.homepage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FirstPage extends AppCompatActivity {

    Button button_firstpage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_page);

        button_firstpage = (Button) findViewById(R.id.button_firstpage);

        button_firstpage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirstPageActivity();
            }
        });
    }

    public void FirstPageActivity(){
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);

    }
}