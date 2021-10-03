package com.example.homepage;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class CalorieActivity extends AppCompatActivity {
    EditText category, weight, height, state;
    Button insertd, updated, deleted, viewd;
    com.example.homepage.DBHelperDiet DB;
    Button btnd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calorie_main);
        category = findViewById(R.id.category);
        weight = findViewById(R.id.weight);
        height = findViewById(R.id.height);
        state = findViewById(R.id.state);
        insertd = findViewById(R.id.btnInsertd);
        updated = findViewById(R.id.btnUpdated);
        deleted = findViewById(R.id.btnDeleted);
        viewd = findViewById(R.id.btnViewd);


        DB = new com.example.homepage.DBHelperDiet(this);

        insertd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String categoryTXT = category.getText().toString();
                String weightTXT = weight.getText().toString();
                String heightTXT = height.getText().toString();
                String stateTXT = state.getText().toString();

                Boolean checkinsertdiet = DB.insertdietdata(categoryTXT, weightTXT, heightTXT, stateTXT);
                if (checkinsertdiet == true)
                    Toast.makeText(CalorieActivity.this, "New Entry Inserted", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(CalorieActivity.this, "New Entry Not Inserted", Toast.LENGTH_SHORT).show();
            }
        });
        updated.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String categoryTXT = category.getText().toString();
                String weightTXT = weight.getText().toString();
                String heightTXT = height.getText().toString();
                String stateTXT = state.getText().toString();

                Boolean checkupdatediet = DB.updatedietdata(categoryTXT, weightTXT, heightTXT, stateTXT);
                if (checkupdatediet == true)
                    Toast.makeText(CalorieActivity.this, "Entry Updated", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(CalorieActivity.this, "New Entry Not Updated", Toast.LENGTH_SHORT).show();
            }
        });
        deleted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameTXT = category.getText().toString();
                Boolean checkudeletediet = DB.deletediet(nameTXT);
                if (checkudeletediet == true)
                    Toast.makeText(CalorieActivity.this, "Entry Deleted", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(CalorieActivity.this, "Entry Not Deleted", Toast.LENGTH_SHORT).show();
            }
        });

        viewd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor res = DB.getdiet();
                if (res.getCount() == 0) {
                    Toast.makeText(CalorieActivity.this, "No Entry Exists", Toast.LENGTH_SHORT).show();
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while (res.moveToNext()) {
                    buffer.append("Category :" + res.getString(0) + "\n");
                    buffer.append("Weight :" + res.getString(1) + "\n");
                    buffer.append("Height :" + res.getString(2) + "\n\n");
                    buffer.append("Activity State :" + res.getString(2) + "\n\n");
                }


                AlertDialog.Builder builder = new AlertDialog.Builder(CalorieActivity.this);
                builder.setCancelable(true);
                builder.setTitle("View Calorie History");
                builder.setMessage(buffer.toString());
                builder.show();
            }
        });


    }
    

}
