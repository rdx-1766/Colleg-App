package com.example.rnsitcollegeapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;

public class ProjectCatalog extends AppCompatActivity implements View.OnClickListener {

    private Button card1_button,card7_button,card2_button,card3_button,card4_button,card5_button,card6_button;

    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_catalog);

        getWindow().setStatusBarColor(ContextCompat.getColor(ProjectCatalog.this,R.color.darkblue));
        if(getSupportActionBar()!=null) {
            (getSupportActionBar()).setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.darkblue)));
            getSupportActionBar().setTitle(Html.fromHtml("<font color='#ffffff'>Project Catalog</font>"));

            card1_button = findViewById(R.id.card1_button);
            card2_button = findViewById(R.id.card2_button);
            card3_button = findViewById(R.id.card3_button);
            card4_button = findViewById(R.id.card4_button);
            card5_button = findViewById(R.id.card5_button);
            card6_button = findViewById(R.id.card6_button);
            card7_button = findViewById(R.id.card7_button);
            card1_button.setOnClickListener(this);
            card2_button.setOnClickListener(this);
            card3_button.setOnClickListener(this);
            card4_button.setOnClickListener(this);
            card5_button.setOnClickListener(this);
            card6_button.setOnClickListener(this);
            card7_button.setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View view) {
        Intent intent;
        if (card1_button.equals(view)) {
            intent = new Intent(ProjectCatalog.this, ProjectList.class);
            intent.putExtra("category", "Android Development");
            startActivity(intent);
        } else if (card2_button.equals(view)) {
            intent = new Intent(ProjectCatalog.this, ProjectList.class);
            intent.putExtra("category", "Data Science");
            startActivity(intent);
        } else if (card3_button.equals(view)) {
            intent = new Intent(ProjectCatalog.this, ProjectList.class);
            intent.putExtra("category", "Full-Stack Development");
            startActivity(intent);
        } else if (card4_button.equals(view)) {
            intent = new Intent(ProjectCatalog.this, ProjectList.class);
            intent.putExtra("category", "Machine Learning");
            startActivity(intent);
        } else if (card5_button.equals(view)) {
            intent = new Intent(ProjectCatalog.this, ProjectList.class);
            intent.putExtra("category", "IOT");
            startActivity(intent);
        } else if (card6_button.equals(view)) {
            intent = new Intent(ProjectCatalog.this, ProjectList.class);
            intent.putExtra("category", "AR-VR");
            startActivity(intent);
        } else if (card7_button.equals(view)) {
            intent = new Intent(ProjectCatalog.this, ProjectList.class);
            intent.putExtra("category", "Artificial Intelligence");
            startActivity(intent);
        }
    }
}