package com.example.tp_intent;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main3);

        Intent intent = getIntent();
        String phoneNumber = intent.getStringExtra("numTel"); // Get phone number
        String websiteUrl = intent.getStringExtra("siteWeb");

        TextView textViewPhoneNumber = findViewById(R.id.textViewPhoneNumber);
        textViewPhoneNumber.setText(phoneNumber);

        TextView textViewWebsite = findViewById(R.id.textViewWebsite);
        textViewWebsite.setText(websiteUrl);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void callPhone(View view) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + getIntent().getStringExtra("numTel")));
        startActivity(intent);
    }

    public void openWebsite(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(getIntent().getStringExtra("siteWeb")));
        startActivity(intent);
    }
}