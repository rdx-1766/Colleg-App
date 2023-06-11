package com.example.rnsitcollegeapp;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.rnsitcollegeapp.ui.ebook.PdfViewerActivity;
import com.example.rnsitcollegeapp.ui.faculty.TeacherAdapater;
import com.example.rnsitcollegeapp.ui.faculty.TeacherData;

import java.util.List;

public class ProjectAdapter extends RecyclerView.Adapter<ProjectAdapter.ProjectViewAdapter> {
    private List<ProjectData> list;
    private Context context;
    private String category;

    public ProjectAdapter(List<ProjectData> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ProjectAdapter.ProjectViewAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.project_item_layout,parent,false);
        return new ProjectAdapter.ProjectViewAdapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProjectViewAdapter holder, int position) {
        ProjectData item = list.get(position);
        holder.title_text.setText(item.getPtitle());
        holder.developer.setText(item.getPdeveloper());
        holder.description.setText(item.getPdes());

        String link = item.getPlink().toString();
        String report = item.getPdfUrl();


        holder.link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.getContext().startActivity(new Intent(Intent.ACTION_VIEW,   Uri.parse(link)));
            }
        });

        holder.report_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, PdfViewerActivity.class);
                intent.putExtra("pdfUrl",report);
                view.getContext().startActivity(intent);
            }
        });
    }



    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ProjectViewAdapter extends RecyclerView.ViewHolder {

        private TextView title_text,developer,description;
        private LinearLayout link;

        private Button report_button;

        public ProjectViewAdapter(@NonNull View itemView) {
            super(itemView);

            title_text = itemView.findViewById(R.id.title_text);
            developer = itemView.findViewById(R.id.developer);
            description = itemView.findViewById(R.id.description);
            link = itemView.findViewById(R.id.link);
            report_button = itemView.findViewById(R.id.report_button);

        }
    }
}
