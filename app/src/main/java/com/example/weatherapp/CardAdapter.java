package com.example.weatherapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.CardViewHolder> {
    private List<CardItems> cardItemsList;

    public static class CardViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView titleTextView;
        public TextView subtitleTextView;
        public TextView descriptionTextView;

        public CardViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.card_image);
            titleTextView = itemView.findViewById(R.id.tx1);
            subtitleTextView = itemView.findViewById(R.id.tx2);
            descriptionTextView = itemView.findViewById(R.id.tx3);
        }
    }

    public CardAdapter(List<CardItems> cardItemsList) {
        this.cardItemsList = cardItemsList;
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_items, parent, false);
        return new CardViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {
        CardItems currentItem = cardItemsList.get(position);
        holder.imageView.setImageResource(currentItem.getImageResource());
        holder.titleTextView.setText(currentItem.getTitle());
        holder.subtitleTextView.setText(currentItem.getSubtitle());
        holder.descriptionTextView.setText(currentItem.getDescription());
    }

    @Override
    public int getItemCount() {
        return cardItemsList.size();
    }
}
