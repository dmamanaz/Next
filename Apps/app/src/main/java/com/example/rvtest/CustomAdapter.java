package com.example.rvtest;

import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CustomAdapter
        extends RecyclerView.Adapter<CustomViewHolder> {

    private ArrayList<Pair<String, String>> dataSet;
    //1st String for image uRL
    // 2nd for caption


    public CustomAdapter(ArrayList<Pair<String, String>> dataSet) {
        this.dataSet = dataSet;
    } // CustomApater holds data collection, list of data

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // creates a CV holder reference
       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,
               parent,
               false);
        CustomViewHolder viewHolder =
                new CustomViewHolder(view);
        return viewHolder;
        //return new CustomViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout)......;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
    // this method binds the items of VH with data
        holder.itemCaption.setText(dataSet.get(position).first
        ); //gets access the specific field defined in CVHolder
        Picasso.get().load(dataSet.get(position).second).
                into(holder.itemImage);//Picasso queries the http url,downloads and renders
    }

    @Override
    public int getItemCount() {
        // this method defines how many items (will be created)the RV will render
        if (dataSet != null)
            return dataSet.size();
            return 0;
            //return dataSet != null ? dataSet.size(): 0;
        }

}
