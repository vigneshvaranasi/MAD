package com.example.a04_recyclerview;

import android.os.Bundle;
import android.widget.RelativeLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Department> depts;
    RecyclerView rcv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        rcv = findViewById(R.id.rec);
        rcv.setLayoutManager(new LinearLayoutManager(this));

        depts = new ArrayList<>();
        depts.add(new Department(R.drawable.cat, "CSE", "230"));
        depts.add(new Department(R.drawable.cat, "IT", "200"));
        depts.add(new Department(R.drawable.cat, "ECE", "150"));


        DepartmentAdapter adapter = new DepartmentAdapter(this, depts);
        rcv.setAdapter(adapter);

    }
}