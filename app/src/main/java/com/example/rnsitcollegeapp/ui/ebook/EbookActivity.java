package com.example.rnsitcollegeapp.ui.ebook;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.Toast;

import com.example.rnsitcollegeapp.MainActivity;
import com.example.rnsitcollegeapp.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class EbookActivity extends AppCompatActivity {

    private EbookAdapter adapter;
    private List<EbookData> list;
    private RecyclerView ebookRecycler;
    private DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ebook);

        getWindow().setStatusBarColor(ContextCompat.getColor(EbookActivity.this,R.color.darkblue));

        if(getSupportActionBar()!=null) {
            (getSupportActionBar()).setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.orange)));
            getSupportActionBar().setTitle("RNSIT");
        }

        ebookRecycler = findViewById(R.id.ebookRecycler);
        reference = FirebaseDatabase.getInstance().getReference().child("pdf");

        getData();
    }

    private void getData() {
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list = new ArrayList<>();
                for(DataSnapshot dataSnapshot: snapshot.getChildren()){
                    EbookData data = dataSnapshot.getValue(EbookData.class);
                    list.add(data);
                }
                adapter = new EbookAdapter(EbookActivity.this,list);
                ebookRecycler.setLayoutManager(new LinearLayoutManager(EbookActivity.this));
                ebookRecycler.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(EbookActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}