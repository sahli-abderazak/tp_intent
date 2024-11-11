package com.example.tp_intent;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity_td2_ex2_2 extends AppCompatActivity {
    RadioButton jaune;
    RadioButton bleu;
    RadioButton rouge;
    RadioButton vert;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_td2_ex22);
        jaune = findViewById(R.id.jaune);
        bleu = findViewById(R.id.bleu);
        rouge = findViewById(R.id.rouge);
        vert = findViewById(R.id.vert);
    }
    public void choisir (View view){
            int couleur = 0;
            if (rouge.isChecked()) {
                couleur = ContextCompat.getColor(this, R.color.rouge);
            } else if (vert.isChecked()) {
                couleur = ContextCompat.getColor(this, R.color.vert);
            } else if (bleu.isChecked()) {
                couleur = ContextCompat.getColor(this, R.color.bleu);
            } else if (jaune.isChecked()) {
                couleur = ContextCompat.getColor(this, R.color.jaune);
            }

            Intent ri = new Intent();
            ri.putExtra("couleur", couleur);
            setResult(RESULT_OK, ri);
            finish();
        }
    }