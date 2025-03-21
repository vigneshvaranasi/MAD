package com.example.a01_customtoast;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

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
//        Toast.makeText(this, "Hello, from onStart", Toast.LENGTH_LONG).show();
    }

    // override onStart
    protected void onStart(){
        Toast.makeText(this, "Hello, from onStart", Toast.LENGTH_LONG).show();
        super.onStart();
    }

    // override onResume
    protected void onResume(){
        Toast.makeText(this, "Hello, from onResume", Toast.LENGTH_LONG).show();
        super.onResume();
    }

    // override onPause
    protected void onPause(){
        Toast.makeText(this, "Hello, from onPause", Toast.LENGTH_LONG).show();
        super.onPause();
    }

    // override onRestart
    protected void onRestart(){
        Toast.makeText(this, "Hello, from onRestart", Toast.LENGTH_LONG).show();
        super.onRestart();
    }

    // override onStop
    protected void onStop(){
        Toast.makeText(this, "Hello, from onStop", Toast.LENGTH_LONG).show();
        super.onStop();
    }

    public void showToast(View x) {
        Toast.makeText(this, "Hello, Welcome", Toast.LENGTH_LONG).show();
    }

    public void showCustomToast(View v){
        LayoutInflater lf = getLayoutInflater();
        // use ID given for the new Layout
        ViewGroup vg = findViewById(R.id.toastLayoutId);
        View cv = lf.inflate(R.layout.toastlayout,vg);
        ImageView imgv = cv.findViewById(R.id.imageView2);
        imgv.setImageResource(R.drawable.car);
        Toast  t = new Toast(this);
        t.setDuration(Toast.LENGTH_LONG);
        t.setView(cv);
        t.show();
    }
}