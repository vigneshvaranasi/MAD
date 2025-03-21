package com.example.a08_firebase;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.internal.EdgeToEdgeUtils;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Stack;

public class MainActivity extends AppCompatActivity {

    EditText edtxt_roll,edtxt_name,edtxt_avg,edtxt_grade;
    FirebaseDatabase fdb;
    DatabaseReference studentRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        edtxt_roll = (EditText) this.findViewById(R.id.edtxt_roll);
        edtxt_name = (EditText) this.findViewById(R.id.edtxt_name);
        edtxt_avg = (EditText) this.findViewById(R.id.edtxt_avg);
        edtxt_grade = (EditText) this.findViewById(R.id.edtxt_grade);

        fdb = FirebaseDatabase.getInstance();
        studentRef = fdb.getReference("students");
    }


    public void insertStudent(View v){
        Student st = new Student(edtxt_roll.getText().toString(),edtxt_name.getText().toString(),edtxt_grade.getText().toString(),edtxt_avg.getText().toString());
        String roll = edtxt_roll.getText().toString().trim();
        studentRef.child(roll).setValue(st).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {
                Toast.makeText(MainActivity.this, "Insertion Succes", Toast.LENGTH_SHORT).show();
            }
        })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(MainActivity.this, "Insertion Falied", Toast.LENGTH_SHORT).show();
                    }
                });

    }
    public void getStudent(View v) {
        String roll = edtxt_roll.getText().toString().trim();

        // Validate input to avoid crashes
        if (roll.isEmpty()) {
            Toast.makeText(this, "Please enter a Roll Number", Toast.LENGTH_SHORT).show();
            return;
        }

        studentRef.child(roll).get()
                .addOnSuccessListener(dataSnapshot -> {
                    if (dataSnapshot.exists()) {
                        Student s = dataSnapshot.getValue(Student.class);

                        if (s != null && s.getName() != null) {
                            Toast.makeText(MainActivity.this, "Student Found: " + s.getName(), Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(MainActivity.this, "Student data is incomplete", Toast.LENGTH_LONG).show();
                        }
                    } else {
                        Toast.makeText(MainActivity.this, "No student found with Roll No: " + roll, Toast.LENGTH_LONG).show();
                    }
                })
                .addOnFailureListener(e ->
                        Toast.makeText(MainActivity.this, "Retrieval Failure: " + e.getMessage(), Toast.LENGTH_LONG).show());
    }



    public void updateStudent(View v){
        String roll = edtxt_roll.getText().toString();
        String name = edtxt_name.getText().toString();
        String avg = edtxt_avg.getText().toString();
        String grade = edtxt_grade.getText().toString();

        Student updatedStudent = new Student(roll,name,grade,avg);
        studentRef.child(roll).setValue(updatedStudent).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(MainActivity.this, "Updation Succes", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(MainActivity.this, "Updation Falied", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    public void deleteStudent(View v){
        String roll = edtxt_roll.getText().toString();
        studentRef.child(roll).removeValue().addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {
                Toast.makeText(MainActivity.this, "Deletion Succes", Toast.LENGTH_SHORT).show();
            }
        })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(MainActivity.this, "Deletion Falied", Toast.LENGTH_SHORT).show();
                    }
                });

    }
}