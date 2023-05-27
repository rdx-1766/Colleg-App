package com.example.rnsitcollegeapp.ui.faculty;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.rnsitcollegeapp.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class FacultyFragment extends Fragment {

    private RecyclerView csDepartment , iseDepartment , mechDepartment , eeeDepartment;
    private LinearLayout csNoData , iseNoData, mechNoData , eeeNoData;
    private List<TeacherData> list1,list2,list3,list4;
    private DatabaseReference reference,dbRef;
    private TeacherAdapater adapater;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_faculty, container, false);
        csDepartment = view.findViewById(R.id.csDepartment);
        iseDepartment = view.findViewById(R.id.iseDepartment);
        mechDepartment = view.findViewById(R.id.mechDepartment);
        eeeDepartment = view.findViewById(R.id.eeeDepartment);

        csNoData = view.findViewById(R.id.csNoData);
        iseNoData = view.findViewById(R.id.iseNoData);
        mechNoData = view.findViewById(R.id.mechNoData);
        eeeNoData = view.findViewById(R.id.eeeNoData);

        reference = FirebaseDatabase.getInstance().getReference().child("teacher");

        csDepartment();
        mechDepartment();
        iseDepartment();
        eeeDepartment();

        return view;

    }

    private void eeeDepartment() {
        dbRef = reference.child("Electrical");

        dbRef.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list4 = new ArrayList<>();
                if(!snapshot.exists()){
                    eeeNoData.setVisibility(View.VISIBLE);
                    eeeDepartment.setVisibility(View.GONE);
                }else{
                    eeeNoData.setVisibility(View.GONE);
                    eeeDepartment.setVisibility(View.VISIBLE);
                    for(DataSnapshot dataSnapshot : snapshot.getChildren()){
                        TeacherData data = dataSnapshot.getValue(TeacherData.class);
                        list4.add(data);
                    }
                    eeeDepartment.setHasFixedSize(true);
                    eeeDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapater = new TeacherAdapater(list4,getContext());
                    eeeDepartment.setAdapter(adapater);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void csDepartment() {
        //String uid = FirebaseAuth.getInstance().getUid();
        dbRef = reference.child("Computer Science");

        dbRef.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list1 = new ArrayList<>();
                if(!snapshot.exists()){
                    csNoData.setVisibility(View.VISIBLE);
                    csDepartment.setVisibility(View.GONE);
                }else{
                    csNoData.setVisibility(View.GONE);
                    csDepartment.setVisibility(View.VISIBLE);
                    for(DataSnapshot dataSnapshot : snapshot.getChildren()){
                        TeacherData data = dataSnapshot.getValue(TeacherData.class);
                        list1.add(data);
                    }
                    csDepartment.setHasFixedSize(true);
                    csDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapater = new TeacherAdapater(list1,getContext());
                    csDepartment.setAdapter(adapater);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void iseDepartment() {
        //String uid = FirebaseAuth.getInstance().getUid();
        dbRef = reference.child("Information Science");

        dbRef.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list2 = new ArrayList<>();
                if(!snapshot.exists()){
                    iseNoData.setVisibility(View.VISIBLE);
                    iseDepartment.setVisibility(View.GONE);
                }else{
                    iseNoData.setVisibility(View.GONE);
                    iseDepartment.setVisibility(View.VISIBLE);
                    for(DataSnapshot dataSnapshot : snapshot.getChildren()){
                        TeacherData data = dataSnapshot.getValue(TeacherData.class);
                        list2.add(data);
                    }

                    iseDepartment.setHasFixedSize(true);
                    iseDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapater = new TeacherAdapater(list2,getContext());
                    iseDepartment.setAdapter(adapater);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void mechDepartment() {
        //String uid = FirebaseAuth.getInstance().getUid();
        dbRef = reference.child("Mechanical");

        dbRef.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list3 = new ArrayList<>();
                if(!snapshot.exists()){
                    mechNoData.setVisibility(View.VISIBLE);
                    mechDepartment.setVisibility(View.GONE);
                }else{
                    mechNoData.setVisibility(View.GONE);
                    mechDepartment.setVisibility(View.VISIBLE);
                    for(DataSnapshot dataSnapshot : snapshot.getChildren()){
                        TeacherData data = dataSnapshot.getValue(TeacherData.class);
                        list3.add(data);
                    }
                    mechDepartment.setHasFixedSize(true);
                    mechDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapater = new TeacherAdapater(list3,getContext());
                    mechDepartment.setAdapter(adapater);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }



}