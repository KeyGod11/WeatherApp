package com.example.weatherapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class VerticalCardAdapter extends RecyclerView.Adapter<VerticalCardAdapter.VerticalCardViewHolder> {

    private List<CardItems> cardItemsList;

    public static class VerticalCardViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView tx1TextView;
        public TextView tx2TextView;
        public TextView tx3TextView;

        public VerticalCardViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.card_image);
            tx1TextView = itemView.findViewById(R.id.tx1);
            tx2TextView = itemView.findViewById(R.id.tx2);
            tx3TextView = itemView.findViewById(R.id.tx3);
        }
    }

    public VerticalCardAdapter(List<CardItems> cardItemsList) {
        this.cardItemsList = cardItemsList;
    }

    @NonNull
    @Override
    public VerticalCardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.vertical_card_item, parent, false);
        return new VerticalCardViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull VerticalCardViewHolder holder, int position) {
        CardItems currentItem = cardItemsList.get(position);
        holder.imageView.setImageResource(currentItem.getImageResource());
        holder.tx1TextView.setText(currentItem.getTitle());
        holder.tx2TextView.setText(currentItem.getSubtitle());
        holder.tx3TextView.setText(currentItem.getDescription());
    }

    @Override
    public int getItemCount() {
        return cardItemsList.size();
    }
}
