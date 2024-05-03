package com.example.acceuil;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ServiceFragment extends Fragment {

    private RecyclerView recyclerView1;
    private MyAdapter myAdapter1;
    private List<Item> itemList1;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_service, container, false);


        // Find the RecyclerView after view inflation
        recyclerView1 = view.findViewById(R.id.view_ser);
        recyclerView1.setLayoutManager(new LinearLayoutManager(requireContext()));
        itemList1 = new ArrayList<>();
        itemList1.add(new Item(R.drawable.oip6, "Housekeeper"));
        itemList1.add(new Item(R.drawable.oip2, "Baby Sitting"));
        itemList1.add(new Item(R.drawable.oip5, "Gardening"));
        itemList1.add(new Item(R.drawable.oip3, "Plumbing"));
        itemList1.add(new Item(R.drawable.oip10, "DIY and Assembly"));
        itemList1.add(new Item(R.drawable.oip9, "Mechanic"));
        itemList1.add(new Item(R.drawable.oip11, "Beauty & Good"));
        itemList1.add(new Item(R.drawable.oip12, "Freelance"));
        itemList1.add(new Item(R.drawable.oip14, "Painting"));
        myAdapter1 = new MyAdapter(itemList1);
        recyclerView1.setAdapter(myAdapter1);

        return view;
    }
}

