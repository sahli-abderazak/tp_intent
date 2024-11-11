package com.example.tp_intent;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity_td2_ex2_1 extends AppCompatActivity {

    private RelativeLayout layout;
    private EditText taille;
    private RadioButton gras, italic;
    private TextView texte;
    private Button btnOk, btnBG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_td2_ex21);
        layout = findViewById(R.id.main); // Correction de l'identifiant
        taille = findViewById(R.id.taille);
        gras = findViewById(R.id.gras);
        italic = findViewById(R.id.italic);
        texte = findViewById(R.id.texte);
        btnOk = findViewById(R.id.btnOk);
        btnBG = findViewById(R.id.btnBG);
    }

    public void modifier(View view) {
        float tailleTexte = 12; // Taille par défaut
        if (!taille.getText().toString().isEmpty()) {
            tailleTexte = Float.parseFloat(taille.getText().toString());
        }
        texte.setTextSize(tailleTexte);

        if (gras.isChecked()) {
            texte.setTypeface(null, Typeface.BOLD);
        } else if (italic.isChecked()) {
            texte.setTypeface(null, Typeface.ITALIC);
        } else {
            texte.setTypeface(null, Typeface.NORMAL); // Si aucun style n'est sélectionné
        }
    }

    public void modifierColor(View view) {
        Intent i = new Intent(MainActivity_td2_ex2_1.this, MainActivity_td2_ex2_2.class);
        startActivityForResult(i, 25);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 25 && resultCode == RESULT_OK && data != null) {
            int color = data.getIntExtra("couleur", Color.BLACK);
            layout.setBackgroundColor(color);
        }
    }
}
