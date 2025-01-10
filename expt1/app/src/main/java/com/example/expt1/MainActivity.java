package com.example.expt1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void onClick_btn_ll(View v){
        Intent i = new Intent(this,linearLayout.class);
        this.startActivity(i);
    }
    public void onClick_btn_tl(View v){
        Intent i = new Intent(this,tableLayout.class);
        this.startActivity(i);
    }
    public void onClick_btn_fl(View v){
        Intent i = new Intent(this,frameLayout.class);
        this.startActivity(i);
    }
    public void onClick_btn_rl(View v){
        Intent i = new Intent(this,relativeLayout.class);
        this.startActivity(i);
    }
    public void onClick_btn_tabl(View v){
        Intent i = new Intent(this,tabLayout.class);
        this.startActivity(i);
    }


}