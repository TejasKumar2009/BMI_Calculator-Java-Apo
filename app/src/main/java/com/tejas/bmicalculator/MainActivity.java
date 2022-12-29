package com.tejas.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public static final String MSG1 = "com.tejas.bmicalculator.MainActivity2";

    public void goToGender(View view){
        Intent intent = new Intent(this, MainActivity2.class);
        EditText txtname = findViewById(R.id.height);
        String name = txtname.getText().toString();
        intent.putExtra(MSG1, name);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}