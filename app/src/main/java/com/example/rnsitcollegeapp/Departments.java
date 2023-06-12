package com.example.rnsitcollegeapp;

import static java.security.AccessController.getContext;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.rnsitcollegeapp.ui.faculty.TeacherAdapater;
import com.example.rnsitcollegeapp.ui.faculty.TeacherData;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class Departments extends AppCompatActivity {

    private RecyclerView deptStaff;
    private String getName ;
    private TextView deptName,deptAbt,deptVision,deptMission,deptHodMsg;
    private ImageView deptHod,deptImg;
    private LinearLayout staffNoData;
    private DatabaseReference reference,dbRef,deptRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_departments);
        getWindow().setStatusBarColor(ContextCompat.getColor(Departments.this,R.color.darkblue));
        if(getSupportActionBar()!=null) {
            (getSupportActionBar()).setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.orange)));
            getSupportActionBar().setTitle(Html.fromHtml("<font color='#ffffff'>Departments</font>"));
        }

        Bundle extras = getIntent().getExtras();
        getName = extras.getString("dept");


        deptStaff = findViewById(R.id.deptStaff);
        deptName = findViewById(R.id.deptName);
        deptAbt = findViewById(R.id.deptAbt);
        deptVision = findViewById(R.id.deptVision);
        deptMission = findViewById(R.id.deptMission);
        deptHodMsg = findViewById(R.id.deptHodMsg);
        staffNoData = findViewById(R.id.staffNoData);
        deptHod = findViewById(R.id.deptHod);
        deptImg = findViewById(R.id.deptImg);

        deptRef = FirebaseDatabase.getInstance().getReference().child("Departments");
        setDeptDetails(getName);

        reference = FirebaseDatabase.getInstance().getReference().child("teacher");
        deptStaff(getName);
    }

    private void setDeptDetails(String getName) {
        dbRef = deptRef.child(getName);
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                deptAbt.setText(snapshot.child("about").getValue().toString());
                deptVision.setText(snapshot.child("vision").getValue().toString());
                deptMission.setText(snapshot.child("mission").getValue().toString());
                deptHodMsg.setText(snapshot.child("msg").getValue().toString());
                Glide.with(Departments.this).load(snapshot.child("img").getValue().toString()).dontAnimate().into(deptImg);
                Glide.with(Departments.this).load(snapshot.child("hod").getValue().toString()).placeholder(R.drawable.faculty).dontAnimate().into(deptHod);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(Departments.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        deptName.setText(getName);



        }


    private void deptStaff(String deptName) {
        dbRef = reference.child(deptName);

        dbRef.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                List<TeacherData> list4 = new ArrayList<>();
                if(!snapshot.exists()){
                    staffNoData.setVisibility(View.VISIBLE);
                    deptStaff.setVisibility(View.GONE);
                }else{
                    staffNoData.setVisibility(View.GONE);
                    deptStaff.setVisibility(View.VISIBLE);
                    for(DataSnapshot dataSnapshot : snapshot.getChildren()){
                        TeacherData data = dataSnapshot.getValue(TeacherData.class);
                        list4.add(data);
                    }
                    deptStaff.setHasFixedSize(true);
                    deptStaff.setLayoutManager(new LinearLayoutManager(Departments.this));
                    TeacherAdapater adapater = new TeacherAdapater(list4, Departments.this);
                    deptStaff.setAdapter(adapater);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(Departments.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}