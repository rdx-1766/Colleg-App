package com.example.rnsitcollegeapp.ui.about;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.rnsitcollegeapp.R;

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
        list.add(new BranchModel(R.drawable.ic_cs,"Computer Science","Department is striving hard in realizing the vision of the institution by accomplishing the vision of the department by promoting excellence in teaching and covering the fundamentals of computer science"));
        list.add(new BranchModel(R.drawable.ic_is,"Information Science","The department follows a quality procedure to prepare students to be industry ready and encourages them to pursue higher education. Department maintains higher academic standards with outcome based education, witnessing higher university results and ranks. More than 95% of students are placed in top companies with paid internships."));
        list.add(new BranchModel(R.drawable.ic_mech,"Mechanical Engineering","Department has been consistently achieving 85-90% results in VTU examination. Mech Radiance is a department student forum under which technical & cultural activities are conducted annually."));
        list.add(new BranchModel(R.drawable.ic_eee,"Electrical Engineering","The well qualified and committed staff, along with the students of the department are working with the vision of making the department one of the best in India in both formal and non-formal education, and offering various research opportunities and services in Electrical Engineering over the next decade. The department provides an excellent learning environment supported by quality teaching with skilled faculty."));

        adapter = new BranchAdapter(getContext(),list);

        viewPager = view.findViewById(R.id.viewPager);
        viewPager.setAdapter(adapter);

        ImageView imageView = view.findViewById(R.id.college_image);
        Glide.with(getContext()).load("https://i.ytimg.com/vi/GJN28CFT108/maxresdefault.jpg").into(imageView);

        return view;
    }
}