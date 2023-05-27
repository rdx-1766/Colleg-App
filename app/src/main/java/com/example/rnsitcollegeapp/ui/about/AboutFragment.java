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
        list.add(new BranchModel(R.drawable.ic_cs,"Computer Science","Good Branch"));
        list.add(new BranchModel(R.drawable.ic_is,"Information Science","Good Branch"));
        list.add(new BranchModel(R.drawable.ic_mech,"Mechanical Engineering","Good Branch"));
        list.add(new BranchModel(R.drawable.ic_eee,"Electrical Engineering","Good Branch"));

        adapter = new BranchAdapter(getContext(),list);

        viewPager = view.findViewById(R.id.viewPager);
        viewPager.setAdapter(adapter);

        ImageView imageView = view.findViewById(R.id.college_image);
        Glide.with(getContext()).load("https://i.ytimg.com/vi/GJN28CFT108/maxresdefault.jpg").into(imageView);

        return view;
    }
}