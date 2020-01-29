package com.example.todoappforresult;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.content.Intent;

import com.google.android.material.textfield.TextInputLayout;

public class AddNewTask extends AppCompatActivity {
    TextInputLayout tilNewTask;
    TextInputLayout tilNewCategory;
    Button btnSaveTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_task);
        tilNewTask = findViewById(R.id.til_new_task);
        tilNewCategory = findViewById(R.id.til_new_task_category);
        btnSaveTask = findViewById(R.id.btn_save_task);
        btnSaveTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // to get the values from the TIL
                // set the values in an Intent
                String task = tilNewTask.getEditText().getText().toString();
                String cate = tilNewCategory.getEditText().getText().toString();
                if (task.isEmpty() && cate.isEmpty()) {
                    Toast.makeText(AddNewTask.this,
                            "No empty values",
                            Toast.LENGTH_SHORT).show();
                } else{
                Intent intent = new Intent();
                intent.putExtra("Task", task);
                intent.putExtra("Cate", cate);
                setResult(RESULT_OK, intent);
                finish();
            }
        }
        });
    }
}
