package com.example.rvtest;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CustomViewHolder
        extends RecyclerView.ViewHolder {
ImageView itemImage;
TextView  itemCaption;

    public CustomViewHolder(@NonNull View itemView) {
        super(itemView);
        itemImage = itemView.findViewById(R.id.iv_item_images);
        itemCaption = itemView.findViewById(R.id.tv_item_caption);
    }
}
