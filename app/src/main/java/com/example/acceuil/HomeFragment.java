package com.example.acceuil;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private RecyclerView recyclerView;
    private MyAdapter2 myAdapter2;
    private List<ITEM2> itemList2;

    private RecyclerView recyclerView1;
    private MyAdapter myAdapter1;
    private List<Item> itemList1;


    FirebaseAuth auth;
    Button buttonlogout;
    TextView textView;
    FirebaseUser user;


        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            // Inflate the layout for this fragment
            View view = inflater.inflate(R.layout.fragment_home, container, false);

            // Find the RecyclerView after view inflation
            recyclerView = view.findViewById(R.id.view_cat);

            // Set layout manager for the RecyclerView
            recyclerView.setLayoutManager(new LinearLayoutManager(requireActivity()));

            // Get screen height


            // Prepare your item data
            itemList2 = new ArrayList<>();
            itemList2.add(new ITEM2(R.drawable.a1,"zayneb ben ali ","Home Maid","tunis"));
            itemList2.add(new ITEM2(R.drawable.a2,"sami ben mohamed ","Painter","gafsa"));
            itemList2.add(new ITEM2(R.drawable.a3,"Amira belhadj ","Baby Sitter","bizerte"));
            itemList2.add(new ITEM2(R.drawable.a4,"mohamed nefzi ","Gardener","hammamet"));
            itemList2.add(new ITEM2(R.drawable.a5,"salah kamoun","Mecanical","Kairouan"));
            itemList2.add(new ITEM2(R.drawable.a7,"Salma salah ","Freelancer","Ariana"));
            itemList2.add(new ITEM2(R.drawable.a8,"Afef karoui ","HairStyler & MakeupArtist","Ben Arous"));
            itemList2.add(new ITEM2(R.drawable.a9,"Ali Hammemi ","Crafter","Touzeur"));
            // Create and set the adapter for the RecyclerView
            myAdapter2 = new MyAdapter2(itemList2);
            recyclerView.setAdapter(myAdapter2);

            // Second RecyclerView
        recyclerView1 = view.findViewById(R.id.view_pop);
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

            auth = FirebaseAuth.getInstance();
            buttonlogout =view.findViewById(R.id.logout);
            textView= view.findViewById(R.id.usermail);

            user = auth.getCurrentUser();
            if (user == null){
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
                
            }
            else {
                textView.setText(user.getEmail());
            }
        buttonlogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);

            }
        });


        return view;
    }


    }

