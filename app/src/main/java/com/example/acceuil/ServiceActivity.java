package com.example.acceuil;



import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


public class ServiceActivity extends  AppCompatActivity {


    private RecyclerView recyclerView1;
    private MyAdapter myAdapter1;
    private List<Item> itemList1;

    @SuppressLint("MissingInflatedId")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_service);
        recyclerView1 = findViewById(R.id.view_cat);
        recyclerView1.setLayoutManager(new LinearLayoutManager(this));

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


    }
}


