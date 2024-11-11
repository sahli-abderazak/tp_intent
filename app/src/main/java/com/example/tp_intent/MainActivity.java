package com.example.tp_intent;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    public EditText ed1;
    public EditText ed2;
    public EditText ed3;
    public EditText ed4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ed1 = findViewById(R.id.editTextText2);
        ed2 = findViewById(R.id.editTextText);
        ed3 = findViewById(R.id.editTextText3);
        ed4 = findViewById(R.id.editText11);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;

        });
    }

    public void valider(View view) {
        String val1 = ed1.getText().toString();
        String val2 = ed2.getText().toString();
        String val3 = ed3.getText().toString();
        String val4 = ed4.getText().toString();
        if (val1.isEmpty() || val2.isEmpty() || val3.isEmpty() || val4.isEmpty()) {
            Toast.makeText(this, "champs vide", Toast.LENGTH_SHORT).show();
            ed1.setTextColor(getResources().getColor(R.color.red));
            ed2.setTextColor(getResources().getColor(R.color.red));
            ed3.setTextColor(getResources().getColor(R.color.red));
            ed4.setTextColor(getResources().getColor(R.color.red));
        } else {
            Toast.makeText(this, "champs vide", Toast.LENGTH_SHORT).show();
            ed1.setTextColor(getResources().getColor(R.color.green));
            ed2.setTextColor(getResources().getColor(R.color.green));
            ed3.setTextColor(getResources().getColor(R.color.green));
            ed4.setTextColor(getResources().getColor(R.color.green));


            Intent intent = new Intent(this, MainActivity2.class);
            intent.putExtra("nom", val1);
            intent.putExtra("age", val2);
            intent.putExtra("siteWeb", val3);
            intent.putExtra("numTel", val4);
            startActivity(intent);
        }
    }
}