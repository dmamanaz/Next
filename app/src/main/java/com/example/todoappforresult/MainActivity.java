package com.example.todoappforresult;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
    public static int NEW_TASK_REQUEST_CODE = 1498; // random.org
ListView listTask;
FloatingActionButton buttonCreateTask;
ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listTask = findViewById(R.id.lv_task);
        buttonCreateTask = findViewById(R.id.fab_add_task);
        buttonCreateTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openNewActivity();
            }
        });

    }

    private void openNewActivity() {
        Intent openNewActivity = new Intent();
        openNewActivity.setClass(this, AddNewTask.class);
        startActivityForResult(openNewActivity, NEW_TASK_REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode,
                                    int resultCode,
                                    @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        /////
        if(requestCode == NEW_TASK_REQUEST_CODE
        && requestCode == RESULT_OK
        && data != null){
            String task = data.getStringExtra("Task");
            String cate = data.getStringExtra("Cate");
            adapter = new ArrayAdapter<>(
                    this,
                    android.R.layout.simple_list_item_2
            );
            adapter.add(task);
            adapter.add(cate);
            listTask.setAdapter(adapter);

        }
    }
}

