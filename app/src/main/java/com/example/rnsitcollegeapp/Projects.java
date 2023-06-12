package com.example.rnsitcollegeapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.rnsitcollegeapp.ui.faculty.TeacherAdapater;
import com.example.rnsitcollegeapp.ui.faculty.TeacherData;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Projects extends AppCompatActivity {

    private LinearLayout projectNoData;
    private RecyclerView projects;

    private DatabaseReference reference,dbRef;
    private List<ProjectData> list;
    private ProjectAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_projects);

        getWindow().setStatusBarColor(ContextCompat.getColor(Projects.this,R.color.darkblue));
        if(getSupportActionBar()!=null) {
            (getSupportActionBar()).setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.darkblue)));
            getSupportActionBar().setTitle(Html.fromHtml("<font color='#ffffff'>Project Details</font>"));
        }

        projectNoData = findViewById(R.id.projectNoData);
        projects = findViewById(R.id.projects);

        reference = FirebaseDatabase.getInstance().getReference();
        getProjects();
    }

    private void getProjects() {

        String category = getIntent().getExtras().get("category").toString();
        String title = getIntent().getExtras().get("ptitle").toString();
        dbRef = reference.child("Projects").child(category).child(title);

        dbRef.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list = new ArrayList<>();
                if(!snapshot.exists()){
                    projectNoData.setVisibility(View.VISIBLE);
                    projects.setVisibility(View.GONE);
                }else{
                    projectNoData.setVisibility(View.GONE);
                    projects.setVisibility(View.VISIBLE);
                        ProjectData data = snapshot.getValue(ProjectData.class);
                        data.setPdes(snapshot.child("pdesc").getValue().toString());
                        if(!snapshot.child("demo").exists()){
                            data.setDemo("--NOT AVAILABLE--");
                        }
                        if(!snapshot.child("future").exists()){
                            data.setFuture("--NOT AVAILABLE--");
                        }
                        list.add(data);
                    projects.setHasFixedSize(true);
                    projects.setLayoutManager(new LinearLayoutManager(Projects.this));
                    adapter = new ProjectAdapter(list,Projects.this);
                    projects.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(Projects.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}