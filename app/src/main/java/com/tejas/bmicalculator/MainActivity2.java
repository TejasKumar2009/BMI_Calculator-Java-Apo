package com.tejas.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {
    public static final String MSG2 = "com.tejas.bmicalculator.MainActivity3";
    ArrayList<String> data = new ArrayList<String>();

    public void clickMale(View view){
        Intent intent = new Intent(this, MainActivity3.class);
        data.add("male");
        intent.putExtra(MSG2, data);
        startActivity(intent);
    }

    public void clickFemale(View view){
        Intent intent = new Intent(this, MainActivity3.class);
        data.add("female");
        intent.putExtra(MSG2, data);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent = getIntent();
        String name = intent.getStringExtra("com.tejas.bmicalculator.MainActivity2");
        data.add(name);
    }
}