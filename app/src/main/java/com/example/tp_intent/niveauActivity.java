package com.example.tp_intent;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;


public class niveauActivity extends AppCompatActivity {

    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_niveau);
        text = findViewById(R.id.text);
        int niveau = getIntent().getIntExtra("niveau", 1);
        text.setText("" + niveau);
    }
    public void precedent(View view) {
        finish();
    }
}