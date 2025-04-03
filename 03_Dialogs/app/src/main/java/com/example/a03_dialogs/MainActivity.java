package com.example.a03_dialogs;

import static android.app.AlertDialog.*;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.security.cert.CertPathBuilderSpi;
import java.util.Calendar;

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

    public void showDialog(View v){
        AlertDialog.Builder ad= new Builder(this);

        ad.setTitle("Dialog");
        ad.setMessage("This is a Message in Dialog");
        ad.setPositiveButton("OK", new OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "Positive Button is Clicked", Toast.LENGTH_SHORT).show();
            }
        });

        ad.setNegativeButton("NO", new OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "Negative Button is Clicked", Toast.LENGTH_SHORT).show();
            }
        });

        ad.create().show();
    }
    public void timeDialog(View v){
        Calendar cal = Calendar.getInstance();
        int hr = cal.get(Calendar.HOUR);
        int min = cal.get(Calendar.MINUTE);

        TimePickerDialog tp = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                Toast.makeText(MainActivity.this, "Selected time is "+hourOfDay+" : "+minute, Toast.LENGTH_SHORT).show();
            }
        },hr,min,false);
        tp.show();
    }
    public void dateDialog(View v){
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog dp = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                Toast.makeText(MainActivity.this, "Date: "+dayOfMonth+"-"+(month+1)+"-"+year, Toast.LENGTH_SHORT).show();
            }
        },year,month,day);
        dp.show();
    }
}