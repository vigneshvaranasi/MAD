package com.example.a05_intent;

import android.content.Intent;
import android.net.Uri;
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

    public void onClickSecondActivity(View v){
        Intent i = new Intent(this, SecondActivity.class);
        this.startActivity(i);
    }

    public void openURL(View v) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com"));
        startActivity(browserIntent);
    }

    public void sendMailDirect(View v) {
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
        emailIntent.setData(Uri.parse("mailto:varanasivsv@gmail.com"));
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Hello");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "This is a test email");
        startActivity(emailIntent);
    }

    public void sendMailDialog(View v) {
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setType("message/rfc822");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"varanasivsv@gmail.com"});
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Hello");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "This is a test email.");
        startActivity(Intent.createChooser(emailIntent, "Send Email"));
    }

}