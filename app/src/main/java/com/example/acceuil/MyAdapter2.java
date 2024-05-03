package com.example.acceuil;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class MyAdapter2 extends RecyclerView.Adapter<MyAdapter2.ViewHolder> {

    private List<ITEM2> itemList2;

    public MyAdapter2(List<ITEM2> itemList2) {
        this.itemList2 = itemList2;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate item_layout2.xml
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout2, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ITEM2 item = itemList2.get(position);

        // Set image from resource ID
        holder.imageView.setImageResource(item.getImageResourceId());

        // Set text views based on ITEM2 data
        holder.textViewName.setText(item.getName());
        holder.textViewProfession.setText(item.getProfession());
        holder.textViewLocation.setText(item.getLocation());
    }

    @Override
    public int getItemCount() {
        return itemList2.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;
        private TextView textViewName;
        private TextView textViewProfession;
        private TextView textViewLocation;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image_view);
            textViewName = itemView.findViewById(R.id.namep);
            textViewProfession = itemView.findViewById(R.id.servicep);
            textViewLocation = itemView.findViewById(R.id.loc);
        }
    }
}
