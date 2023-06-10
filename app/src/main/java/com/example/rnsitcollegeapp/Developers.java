package com.example.rnsitcollegeapp;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class Developers extends AppCompatActivity {
    private ImageView linkedinIconDeveloper1, githubIconDeveloper1, instagramIconDeveloper1;
    private ImageView linkedinIconDeveloper2, githubIconDeveloper2, instagramIconDeveloper2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_developers);

        getWindow().setStatusBarColor(ContextCompat.getColor(Developers.this,R.color.darkblue));
        if(getSupportActionBar()!=null) {
            (getSupportActionBar()).setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.darkblue)));
            getSupportActionBar().setTitle(Html.fromHtml("<font color='#ffffff'>Developers</font>"));
        }

        // Developer 1's details
        ImageView imageDeveloper1 = findViewById(R.id.imageDeveloper1);
        TextView nameDeveloper1 = findViewById(R.id.nameDeveloper1);
        TextView departmentDeveloper1 = findViewById(R.id.departmentDeveloper1);
        TextView collegeDeveloper1 = findViewById(R.id.collegeDeveloper1);
        linkedinIconDeveloper1 = findViewById(R.id.linkedinIconDeveloper1);
        githubIconDeveloper1 = findViewById(R.id.githubIconDeveloper1);
        instagramIconDeveloper1 = findViewById(R.id.instagramIconDeveloper1);



        // Set click listeners for Developer 1's icons
        linkedinIconDeveloper1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLinkInBrowser("https://www.linkedin.com/in/harikrishna2364/");
            }
        });

        githubIconDeveloper1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLinkInBrowser("https://github.com/1rn20cs049-Harikrishna");
            }
        });

        instagramIconDeveloper1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLinkInBrowser("https://www.instagram.com/harikrishna92364/");
            }
        });

        // Developer 2's details
        ImageView imageDeveloper2 = findViewById(R.id.imageDeveloper2);
        TextView nameDeveloper2 = findViewById(R.id.nameDeveloper2);
        TextView departmentDeveloper2 = findViewById(R.id.departmentDeveloper2);
        TextView collegeDeveloper2 = findViewById(R.id.collegeDeveloper2);
        linkedinIconDeveloper2 = findViewById(R.id.linkedinIconDeveloper2);
        githubIconDeveloper2 = findViewById(R.id.githubIconDeveloper2);
        instagramIconDeveloper2 = findViewById(R.id.instagramIconDeveloper2);


        // Set click listeners for Developer 2's icons
        linkedinIconDeveloper2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLinkInBrowser("https://www.linkedin.com/in/m-pavan-kumar-735310212/");
            }
        });

        githubIconDeveloper2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLinkInBrowser("https://github.com/rdx-1766");
            }
        });

        instagramIconDeveloper2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLinkInBrowser("https://www.instagram.com/rdx_1766/");
            }
        });
    }

    private void openLinkInBrowser(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }
}
