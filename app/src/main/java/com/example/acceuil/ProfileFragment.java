package com.example.acceuil;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


public class ProfileFragment extends Fragment {


    private RecyclerView recyclerView;
    private MyAdapter2 myAdapter2;
    private List<ITEM2> itemList2;

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        // Find the RecyclerView after view inflation
        recyclerView = view.findViewById(R.id.view_pro);

        // Set layout manager for the RecyclerView
        recyclerView.setLayoutManager(new LinearLayoutManager(requireActivity()));


        // Prepare your item data
        itemList2 = new ArrayList<>();
        itemList2.add(new ITEM2(R.drawable.a1, "zayneb ben ali ", "Home Maid", "tunis"));
        itemList2.add(new ITEM2(R.drawable.a2, "sami ben mohamed ", "Painter", "gafsa"));
        itemList2.add(new ITEM2(R.drawable.a3, "Amira belhadj ", "Baby Sitter", "bizerte"));
        itemList2.add(new ITEM2(R.drawable.a4, "mohamed nefzi ", "Gardener", "hammamet"));
        itemList2.add(new ITEM2(R.drawable.a5, "salah kamoun", "Mecanical", "Kairouan"));
        itemList2.add(new ITEM2(R.drawable.a7, "Salma salah ", "Freelancer", "Ariana"));
        itemList2.add(new ITEM2(R.drawable.a8, "Afef karoui ", "HairStyler & MakeupArtist", "Ben Arous"));
        itemList2.add(new ITEM2(R.drawable.a9, "Ali Hammemi ", "Crafter", "Touzeur"));
        // Create and set the adapter for the RecyclerView
        myAdapter2 = new MyAdapter2(itemList2);
        recyclerView.setAdapter(myAdapter2);
        return view;
    }
}
