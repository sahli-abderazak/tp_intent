package com.example.tp_intent;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        Intent intent = getIntent();
        String nom = intent.getStringExtra("nom");
        String age = intent.getStringExtra("age");
        String siteWeb = intent.getStringExtra("siteWeb");
        String numTel = intent.getStringExtra("numTel");

        TextView textViewNom = findViewById(R.id.textViewNom);
        TextView textViewAge = findViewById(R.id.textViewAge);
        TextView textViewSiteWeb = findViewById(R.id.textViewSiteWeb);
        TextView textViewTel = findViewById(R.id.textViewTel);


        textViewNom.setText("Nom: " + nom);
        textViewAge.setText("Age: " + age);
        textViewSiteWeb.setText("Site Web: " + siteWeb);
        textViewTel.setText("Numéro de Téléphone: " + numTel);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void go(View view) {
        Intent intent = new Intent(this, MainActivity3.class);
        startActivity(intent);
    }
    public void retour(View view) {
        finish();
    }
}