package com.example.weatherapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SmallCardAdapter extends RecyclerView.Adapter<SmallCardAdapter.SmallCardViewHolder> {

    private List<CardItems> cardItemsList;

    public static class SmallCardViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView tx1TextView;

        public SmallCardViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.card_image);
            tx1TextView = itemView.findViewById(R.id.tx1);
        }
    }

    public SmallCardAdapter(List<CardItems> cardItemsList) {
        this.cardItemsList = cardItemsList;
    }

    @NonNull
    @Override
    public SmallCardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.small_card_item, parent, false);
        return new SmallCardViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull SmallCardViewHolder holder, int position) {
        CardItems currentItem = cardItemsList.get(position);
        holder.imageView.setImageResource(currentItem.getImageResource());
        holder.tx1TextView.setText(currentItem.getTitle());
    }

    @Override
    public int getItemCount() {
        return cardItemsList.size();
    }
}
