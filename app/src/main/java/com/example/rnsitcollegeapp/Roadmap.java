package com.example.rnsitcollegeapp;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.example.rnsitcollegeapp.ui.ebook.PdfViewerActivity;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Roadmap extends AppCompatActivity {

    private DatabaseReference ref;
    private String cs,bc,fs,sa,qa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roadmap);

        getWindow().setStatusBarColor(ContextCompat.getColor(Roadmap.this,R.color.darkblue));
        if(getSupportActionBar()!=null) {
            (getSupportActionBar()).setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.darkblue)));
            getSupportActionBar().setTitle(Html.fromHtml("<font color='#ffffff'>Domain RoadMap</font>"));
        }

        ref = FirebaseDatabase.getInstance().getReference().child("Domains");

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                cs = snapshot.child("cybersecurity").getValue().toString();
                bc = snapshot.child("blockchain").getValue().toString();
                fs = snapshot.child("fullstack").getValue().toString();
                sa = snapshot.child("softwarearchitect").getValue().toString();
                qa = snapshot.child("qa").getValue().toString();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(Roadmap.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        // Button for CardView 1
        Button card1Button = findViewById(R.id.card1_button);
        card1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Roadmap.this, PdfViewerActivity.class);
                intent.putExtra("pdfUrl",cs);
                startActivity(intent);
            }
        });

        // Button for CardView 2
        Button card2Button = findViewById(R.id.card2_button);
        card2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Roadmap.this, PdfViewerActivity.class);
                intent.putExtra("pdfUrl",bc);
                startActivity(intent);
            }
        });

        // Button for CardView 3
        Button card3Button = findViewById(R.id.card3_button);
        card3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Roadmap.this, PdfViewerActivity.class);
                intent.putExtra("pdfUrl",fs);
                startActivity(intent);
            }
        });

        // Button for CardView 4
        Button card4Button = findViewById(R.id.card4_button);
        card4Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Roadmap.this, PdfViewerActivity.class);
                intent.putExtra("pdfUrl",sa);
                startActivity(intent);
            }
        });

        // Button for CardView 5
        Button card5Button = findViewById(R.id.card5_button);
        card5Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Roadmap.this, PdfViewerActivity.class);
                intent.putExtra("pdfUrl",qa);
                startActivity(intent);
            }
        });
    }
}
