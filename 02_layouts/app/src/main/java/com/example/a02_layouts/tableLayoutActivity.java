package com.example.a02_layouts;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class tableLayoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_table_layout);
        ImageView imgv1,imgv2,imgv3,imgv4;
        imgv1 = this.findViewById(R.id.imageView);
        imgv1.setImageResource(R.drawable.cat);

        imgv2 = this.findViewById(R.id.imageView2);
        imgv2.setImageResource(R.drawable.cat);

        imgv3 = this.findViewById(R.id.imageView3);
        imgv3.setImageResource(R.drawable.cat);

        imgv4 = this.findViewById(R.id.imageView4);
        imgv4.setImageResource(R.drawable.cat);
    }


}