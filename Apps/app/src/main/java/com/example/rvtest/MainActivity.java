package com.example.rvtest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;
import android.util.Pair;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager =     //renders either top to bottom or from bottom to top
        new LinearLayoutManager(this);
        GridLayoutManager gridLayoutManager =   //renders in columns
                new GridLayoutManager(this, 2);
        StaggeredGridLayoutManager staggeredGridLayoutManager = // renders by changing items' sizes
         new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager); // renders the items as columns, rows
        recyclerView.setAdapter(new
                CustomAdapter(
                createDataset()));
    }
    public ArrayList<Pair<String, String>> createDataset() {
        Pair<String, String> item;
        String[] arrayTitle = getResources()
                .getStringArray(R.array.cake_title);
        String [] arrayUrl = getResources()
                .getStringArray(R.array.cake_url);
        ArrayList<Pair<String, String>> list = new ArrayList<>(); // this list holds all below iteractions

          for(int i=0; i < arrayTitle.length; i++){
              item = new Pair<>(arrayTitle[i], arrayUrl[i]);
              list.add(item);
          }
          return list;
    }
}
