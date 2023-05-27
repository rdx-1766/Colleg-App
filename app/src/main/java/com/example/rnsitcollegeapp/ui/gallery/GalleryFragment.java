package com.example.rnsitcollegeapp.ui.gallery;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Gallery;
import android.widget.Toast;

import com.example.rnsitcollegeapp.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class GalleryFragment extends Fragment {

    RecyclerView induRecycler,parichayRecycler,otherRecycler;

    GalleryAdapter adapter;
    DatabaseReference reference;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_gallery, container, false);

        induRecycler = view.findViewById(R.id.induRecycler);
        parichayRecycler = view.findViewById(R.id.parichayRecycler);
        otherRecycler = view.findViewById(R.id.otherRecycler);

        reference = FirebaseDatabase.getInstance().getReference().child("gallery");

        getInduImage();
        getParichayImage();
        getOtherImage();

        return view;
    }

    private void getInduImage() {
        reference.child("Induction Program").addValueEventListener(new ValueEventListener() {
            List<String> imageList = new ArrayList<>();
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot: snapshot.getChildren()){
                    String data = (String)dataSnapshot.getValue();
                    imageList.add(data);
                }
                adapter = new GalleryAdapter(getContext(),imageList);
                induRecycler.setLayoutManager(new GridLayoutManager(getContext(),4));
                induRecycler.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), "Failed to load images", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getParichayImage() {
        reference.child("Parichay").addValueEventListener(new ValueEventListener() {
            List<String> imageList = new ArrayList<>();
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot: snapshot.getChildren()){
                    String data = (String)dataSnapshot.getValue();
                    imageList.add(data);
                }
                adapter = new GalleryAdapter(getContext(),imageList);
                parichayRecycler.setLayoutManager(new GridLayoutManager(getContext(),4));
                parichayRecycler.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), "Failed to load images", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getOtherImage() {
        reference.child("Other Events").addValueEventListener(new ValueEventListener() {
            List<String> imageList = new ArrayList<>();
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot: snapshot.getChildren()){
                    String data = (String) dataSnapshot.getValue();
                    imageList.add(data);
                }
                adapter = new GalleryAdapter(getContext(),imageList);
                otherRecycler.setLayoutManager(new GridLayoutManager(getContext(),4));
                otherRecycler.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), "Failed to load images", Toast.LENGTH_SHORT).show();
            }
        });
    }
}