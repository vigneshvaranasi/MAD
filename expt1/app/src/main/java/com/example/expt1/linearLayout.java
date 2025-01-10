package com.example.expt1;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class linearLayout extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear_layout);
        ImageView imgv1,imgv2;
        imgv1 = this.findViewById(R.id.imageView4);
        imgv1.setImageResource(R.drawable.cat);
        imgv2 = this.findViewById((R.id.imageView5));
        imgv2.setImageResource(R.drawable.cat);
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