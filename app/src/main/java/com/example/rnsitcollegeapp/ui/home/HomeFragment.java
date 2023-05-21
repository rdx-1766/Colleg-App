package com.example.rnsitcollegeapp.ui.home;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SlidingDrawer;

import com.example.rnsitcollegeapp.R;
import com.example.rnsitcollegeapp.SliderAdapter;
import com.example.rnsitcollegeapp.SliderData;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private SliderView sliderView;
    private ImageView map;
    String url1 = "https://www.rnsit.ac.in/wp-content/themes/twentyseventeen/img/d.jpg";
    String url2 = "https://www.rnsit.ac.in/wp-content/themes/twentyseventeen/img/a.jpg";
    String url3 = "https://www.rnsit.ac.in/wp-content/themes/twentyseventeen/img/c.jpg";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        sliderView = view.findViewById(R.id.slider);
        sliderView.setIndicatorAnimation(IndicatorAnimationType.FILL);
        sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        sliderView.setScrollTimeInSec(3);

        map = view.findViewById(R.id.map);
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMap();
            }
        });


        ArrayList<SliderData> sliderDataArrayList = new ArrayList<>();

        sliderDataArrayList.add(new SliderData(url1));
        sliderDataArrayList.add(new SliderData(url2));
        sliderDataArrayList.add(new SliderData(url3));

        SliderAdapter adapter = new SliderAdapter(view.getContext(), sliderDataArrayList);
        sliderView.setSliderAdapter(adapter);

        sliderView.setAutoCycle(true);

        sliderView.startAutoCycle();




        return view;
    }

    private void openMap() {
        Uri uri = Uri.parse("geo:0, 0?q=RNS Institute of Technology");
        Intent intent = new Intent(Intent.ACTION_VIEW,uri);
        intent.setPackage("com.google.android.apps.maps");
        startActivity(intent);
    }
}