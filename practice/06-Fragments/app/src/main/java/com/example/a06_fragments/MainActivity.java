package com.example.a06_fragments;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentResultListener;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {

    SportsFragment sf;
    FragmentManager fm;
    FragmentTransaction ft;

    BadmintonFragment bf;
    CricketFragment cf;
    FootballFragment ff;
    HockeyFragment hf;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sf = new SportsFragment();
        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();
        sf = new SportsFragment();
        ft.add(R.id.ll1,sf);
        ft.commit();

        fm.setFragmentResultListener("si", this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {
                int option = result.getInt("si");
                ft = fm.beginTransaction();
                switch (option) {
                    case 0:
                        ft.replace(R.id.ll2, new BadmintonFragment(), String.valueOf(bf));
                        break;
                    case 1:
                        ft.replace(R.id.ll2, new HockeyFragment(), String.valueOf(hf));
                        break;
                    case 2:
                        ft.replace(R.id.ll2, new FootballFragment(), String.valueOf(ff));
                        break;
                    case 3:
                        ft.replace(R.id.ll2, new CricketFragment(), String.valueOf(cf));
                        break;
                }
                ft.commit();
            }
        });
    }
}