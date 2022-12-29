package com.tejas.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.widget.TextView;
import android.view.View;

import java.util.ArrayList;

public class MainActivity3 extends AppCompatActivity {
    public static final String MSG3 = "com.tejas.bmicalculator.ResultAcitvity";
    ArrayList<String> data = new ArrayList<String>();

    public void setFinalResult(View view){
        Intent intent = new Intent(this, ResultActivity.class);
        TextView height = findViewById(R.id.height);
        TextView weight = findViewById(R.id.weight);
        if (height.getText().toString().length() == 0) {
            height.setError("Height Cannot be empty!");
        }
        else if(weight.getText().toString().length() == 0){
            weight.setError("Weight Cannot be empty!");
        }
        else{
            data.add(height.getText().toString());
            data.add(weight.getText().toString());
            intent.putExtra(MSG3, data);
            startActivity(intent);
        }
    }

    @Override
    public void onBackPressed() {}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        Intent intent = getIntent();
        ArrayList<String> old_data = (ArrayList<String>) getIntent().getSerializableExtra("com.tejas.bmicalculator.MainActivity3");
        for (String element:old_data) {
            data.add(element);
        }
    }
}