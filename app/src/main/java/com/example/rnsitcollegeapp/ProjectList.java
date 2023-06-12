package com.example.rnsitcollegeapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class ProjectList extends AppCompatActivity {

    private DatabaseReference ref,dbRef;
    private RecyclerView recyclerView;
    private ProjectAdapter projectAdapter;
    private LinearLayout nodata;
    private CardView cardView;

    String title,category;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_list);

        getWindow().setStatusBarColor(ContextCompat.getColor(ProjectList.this, R.color.orange));
        if (getSupportActionBar() != null) {
            (getSupportActionBar()).setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.orange)));
            getSupportActionBar().setTitle(Html.fromHtml("<font color='#ffffff'>Project List</font>"));
        }

        List<Project> projects = getProjects();

        nodata = findViewById(R.id.projectNoData);
        cardView = findViewById(R.id.cardView);



        category = getIntent().getStringExtra("category");
        title = getTitle().toString();

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        ref = FirebaseDatabase.getInstance().getReference().child("Projects");
        projectAdapter = new ProjectAdapter(projects);
        recyclerView.setAdapter(projectAdapter);

    }

    private List<Project> getProjects() {

        String category = getIntent().getExtras().getString("category");
        dbRef = FirebaseDatabase.getInstance().getReference().child("Projects").child(category);
        List<Project> projects = new ArrayList<>();

        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (!snapshot.exists()) {
                    nodata.setVisibility(View.VISIBLE);
                    recyclerView.setVisibility(View.GONE);
                } else {
                    nodata.setVisibility(View.GONE);
                    recyclerView.setVisibility(View.VISIBLE);
                    for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                        Project p = new Project();
                        p.setTitle(dataSnapshot.child("ptitle").getValue().toString());
                        p.setDescription(dataSnapshot.child("pdesc").getValue().toString());
                        projects.add(p);
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        return projects;
    }

    private static class ProjectAdapter extends RecyclerView.Adapter<ProjectAdapter.ProjectViewHolder> {
        private List<Project> projects;

        public ProjectAdapter(List<Project> projects) {
            this.projects = projects;
        }

        @Override
        public ProjectViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.projectlist_layout, parent, false);
            return new ProjectViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ProjectViewHolder holder, int position) {
            Project project = projects.get(position);
            holder.titleTextView.setText(project.getTitle());
            holder.descriptionTextView.setText(project.getDescription());
        }

        @Override
        public int getItemCount() {
            return projects.size();
        }

        public static class ProjectViewHolder extends RecyclerView.ViewHolder {
            public CardView cardView;
            public TextView titleTextView;
            public TextView descriptionTextView;

            public ProjectViewHolder(View itemView) {
                super(itemView);
                cardView = itemView.findViewById(R.id.cardView);
                titleTextView = itemView.findViewById(R.id.titleTextView);
                descriptionTextView = itemView.findViewById(R.id.descriptionTextView);

                cardView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(view.getContext(),Projects.class);
                        intent.putExtra("ptitle",titleTextView.getText().toString());
                        intent.putExtra("category","Android Development");
                        view.getContext().startActivity(intent);
                    }
                });
            }
        }

    }
}