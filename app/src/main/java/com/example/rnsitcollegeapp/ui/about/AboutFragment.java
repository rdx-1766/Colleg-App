package com.example.rnsitcollegeapp.ui.about;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.rnsitcollegeapp.Departments;
import com.example.rnsitcollegeapp.R;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class AboutFragment extends Fragment {
    private ViewPager viewPager;
    private BranchAdapter adapter;
    private List<BranchModel> list;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_about, container, false);




        list = new ArrayList<>();
        list.add(new BranchModel(R.drawable.ic_cs,"Computer Science","Preparing Better Computer Professionals for a Real World"));
        list.add(new BranchModel(R.drawable.ic_is,"Information Science","Building Information Technology Professionals by Imparting Quality Education and Inculcating Key Competencies"));
        list.add(new BranchModel(R.drawable.ic_mech,"Mechanical Engineering","To become a center of excellence in Mechanical Engineering and to nurture technically competent and socially responsible engineering professionals."));
        list.add(new BranchModel(R.drawable.ic_eee,"Electrical Engineering","Pursuit of excellence in the field of Electrical & Electronics Engineering."));

        adapter = new BranchAdapter(getContext(),list);

        viewPager = view.findViewById(R.id.viewPager);
        viewPager.setAdapter(adapter);

        ImageView imageView = view.findViewById(R.id.college_image);
        Glide.with(getContext()).load("https://i.ytimg.com/vi/GJN28CFT108/maxresdefault.jpg").into(imageView);

        return view;
    }
}