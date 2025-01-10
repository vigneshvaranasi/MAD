package com.example.expt1;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class tableLayout extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_layout);
        ImageView imgv1,imgv2,imgv3;
        imgv1 = this.findViewById(R.id.imageView8);
        imgv1.setImageResource(R.drawable.cat);
        imgv2 = this.findViewById((R.id.imageView9));
        imgv2.setImageResource(R.drawable.cat);
        imgv3 = this.findViewById((R.id.imageView10));
        imgv3.setImageResource(R.drawable.cat);
    }


}