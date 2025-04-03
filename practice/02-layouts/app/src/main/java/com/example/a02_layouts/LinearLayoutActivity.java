package com.example.a02_layouts;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LinearLayoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear_layout);
    }

    public void changeDir(View v){
        LinearLayout ll = findViewById(R.id.ll_full);
        if(ll.getOrientation()==LinearLayout.HORIZONTAL){
            ll.setOrientation(LinearLayout.VERTICAL);
        }
        else{
            ll.setOrientation(LinearLayout.HORIZONTAL);
        }
    }
}