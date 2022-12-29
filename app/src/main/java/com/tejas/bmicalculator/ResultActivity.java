package com.tejas.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.nio.channels.InterruptedByTimeoutException;
import java.util.ArrayList;

public class ResultActivity extends AppCompatActivity {
    TextView healthStatus;
    TextView healthStatus2;
    ImageView bmi_meter;
    ImageView person_health;

    public void test_again(){
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {}

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        healthStatus = findViewById(R.id.healthStatus);
        healthStatus2 = findViewById(R.id.healthStatus2);
        bmi_meter = findViewById(R.id.bmi_meter);
        person_health = findViewById(R.id.person_health);

        ArrayList<String> data = (ArrayList<String>) getIntent().getSerializableExtra("com.tejas.bmicalculator.ResultAcitvity");
        String name = data.get(0);
        String gender = data.get(1);
        double height = (Double.parseDouble(data.get(2)))/100;
        double weight = Double.parseDouble(data.get(3));
        double bmi_raw = weight/(height*height);
        double bmi = Math.round(bmi_raw*100.0)/100.0;

        healthStatus.setText("YOUR BMI IS " + bmi);

        if (bmi<18.5) {
            healthStatus2.setText(name + ", You Are Underweight. Increase Your Weight Fast !");
            healthStatus.setTextColor(Color.RED);
            bmi_meter.setImageResource(R.drawable.underweight);
            person_health.setImageResource(R.drawable.thin_man);
        }
        else if (bmi<25){
            healthStatus2.setText(name + ", Your Are Normal And Healthy !");
            healthStatus.setTextColor(Color.GREEN);
            bmi_meter.setImageResource(R.drawable.normal);
            person_health.setImageResource(R.drawable.healthy_man);
        }
        else if (bmi<30){
            healthStatus2.setText(name + ", You are Overweight. You have to loose your weight Fast !");
            healthStatus.setTextColor(Color.YELLOW);
            bmi_meter.setImageResource(R.drawable.overweight);
            person_health.setImageResource(R.drawable.fat_man);
        }
        else{
            healthStatus2.setText(name + ", You are too Fat. You have to loose weight or It will very dangerous !");
            healthStatus.setTextColor(Color.RED);
            bmi_meter.setImageResource(R.drawable.obesity);
            person_health.setImageResource(R.drawable.fat_man);
        }
    }
}