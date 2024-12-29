package com.example.a02_layouts;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class linearLayoutActivity extends AppCompatActivity {

    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
//        setContentView(R.layout.activity_linear_layout);
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });
//    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear_layout);
        ImageView imgv1,imgv2;
        imgv1 = this.findViewById(R.id.imageView);
        imgv1.setImageResource(R.drawable.img);




        imgv2 = this.findViewById((R.id.imageView3));
        imgv2.setImageResource(R.drawable.img);
    }

    public void changeOrientation(View v)
    {
        LinearLayout ll=findViewById(R.id.main);
        if(ll.getOrientation()==LinearLayout.HORIZONTAL){
            ll.setOrientation(LinearLayout.VERTICAL);
        }
        else {
            ll.setOrientation(LinearLayout.HORIZONTAL);
        }
    }
}