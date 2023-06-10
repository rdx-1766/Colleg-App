package com.example.rnsitcollegeapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class CGPA extends AppCompatActivity {

    private EditText editTextSem1, editTextSem2, editTextSem3, editTextSem4, editTextSem5, editTextSem6, editTextSem7, editTextSem8;
    private Button buttonCalculate;
    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cgpa);

        getWindow().setStatusBarColor(ContextCompat.getColor(CGPA.this,R.color.darkblue));
        if(getSupportActionBar()!=null) {
            (getSupportActionBar()).setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.orange)));
            getSupportActionBar().setTitle("CGPA Calculator");
        }

        // Initialize EditText fields
        editTextSem1 = findViewById(R.id.editTextSem1);
        editTextSem2 = findViewById(R.id.editTextSem2);
        editTextSem3 = findViewById(R.id.editTextSem3);
        editTextSem4 = findViewById(R.id.editTextSem4);
        editTextSem5 = findViewById(R.id.editTextSem5);
        editTextSem6 = findViewById(R.id.editTextSem6);
        editTextSem7 = findViewById(R.id.editTextSem7);
        editTextSem8 = findViewById(R.id.editTextSem8);

        editTextSem1.setText("0");
        editTextSem2.setText("0");
        editTextSem3.setText("0");
        editTextSem4.setText("0");
        editTextSem5.setText("0");
        editTextSem6.setText("0");
        editTextSem7.setText("0");
        editTextSem8.setText("0");

        // Initialize Button and TextView
        buttonCalculate = findViewById(R.id.buttonCalculate);
        textViewResult = findViewById(R.id.textViewResult);

        // Set OnClickListener for the Calculate button
        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateCGPA();
            }
        });
    }

    private void calculateCGPA() {
        float sum = 0;
        int count = 0;
        // Retrieve SGPA values from EditText fields
        float sgpaSem1 = Float.parseFloat(editTextSem1.getText().toString());
        float sgpaSem2 = Float.parseFloat(editTextSem2.getText().toString());
        float sgpaSem3 = Float.parseFloat(editTextSem3.getText().toString());
        float sgpaSem4 = Float.parseFloat(editTextSem4.getText().toString());
        float sgpaSem5 = Float.parseFloat(editTextSem5.getText().toString());
        float sgpaSem6 = Float.parseFloat(editTextSem6.getText().toString());
        float sgpaSem7 = Float.parseFloat(editTextSem7.getText().toString());
        float sgpaSem8 = Float.parseFloat(editTextSem8.getText().toString());

        // Calculate CGPA
        if (sgpaSem1 != 0) {
            sum += sgpaSem1;
            count++;
        }
        if (sgpaSem2 != 0) {
            sum += sgpaSem2;
            count++;
        }
        if (sgpaSem3 != 0) {
            sum += sgpaSem3;
            count++;
        }
        if (sgpaSem4 != 0) {
            sum += sgpaSem4;
            count++;
        }
        if (sgpaSem5 != 0) {
            sum += sgpaSem5;
            count++;
        }
        if (sgpaSem6 != 0) {
            sum += sgpaSem6;
            count++;
        }
        if (sgpaSem7 != 0) {
            sum += sgpaSem7;
            count++;
        }
        if (sgpaSem8 != 0) {
            sum += sgpaSem8;
            count++;
        }

        // Calculate CGPA
        float cgpa = count > 0 ? sum / count : 0;

        // Display the CGPA result
        textViewResult.setText("CGPA: " + cgpa);
    }
}
