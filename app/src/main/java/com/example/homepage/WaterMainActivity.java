package com.example.homepage;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class WaterMainActivity extends AppCompatActivity {

    EditText mneww, mtime;
    Button minsert, mupdate, mdelete, mview, mcalcuate;
    waterDBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_watermain);

        mneww = findViewById(R.id.neww);
        mtime = findViewById(R.id.time);
        minsert = findViewById(R.id.add);
        mupdate = findViewById(R.id.edit);
        mdelete = findViewById(R.id.reset);
        mview = findViewById(R.id.view);

        db = new waterDBHelper(this);

        minsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String timeTXT = mtime.getText().toString();
                Integer litresINT = Integer.valueOf(mneww.getText().toString());

                Boolean checkinsertdata = db.insertdrinkedwater(timeTXT, litresINT);
                if (checkinsertdata==true)
                    Toast.makeText(WaterMainActivity.this, "New Entry Inserted", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(WaterMainActivity.this, "New Entry Not Inserted", Toast.LENGTH_SHORT).show();
            }
        });

        mupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String timeTXT = mtime.getText().toString();
                Integer litresINT = Integer.valueOf(mneww.getText().toString());

                Boolean checkinsertdata = db.updatedrinkedwater(timeTXT, litresINT);
                if (checkinsertdata==true)
                    Toast.makeText(WaterMainActivity.this, "New Entry Inserted", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(WaterMainActivity.this, "New Entry Not Inserted", Toast.LENGTH_SHORT).show();
            }
        });

        mdelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String timeTXT = mtime.getText().toString();

                Boolean checkinsertdata = db.deletedrinkedwater(timeTXT);
                if (checkinsertdata==true)
                    Toast.makeText(WaterMainActivity.this, "New Entry Inserted", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(WaterMainActivity.this, "New Entry Not Inserted", Toast.LENGTH_SHORT).show();
            }
        });

        mview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor res = db.getdata();
                if (res.getCount()==0){
                    Toast.makeText(WaterMainActivity.this, "No Entry Exists",Toast.LENGTH_SHORT).show();
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while (res.moveToNext()) {
                    buffer.append("Time :"+res.getString(0)+"\n");
                    buffer.append("Litres :"+res.getString(1)+"\n");
                }

                AlertDialog.Builder builder = new AlertDialog.Builder(WaterMainActivity.this);
                builder.setCancelable(true);
                builder.setTitle("Your Water Plan");
                builder.setMessage(buffer.toString());
                builder.show();
            }
        });




    }
}