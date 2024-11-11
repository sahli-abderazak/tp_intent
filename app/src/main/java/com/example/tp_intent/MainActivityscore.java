package com.example.tp_intent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivityscore extends AppCompatActivity {
    TextView t1,t2;
    Button button, Rejouer;
    Integer n = 1;
    Integer s = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activityscore);
        t1 = findViewById(R.id.textView14);
        t2 = findViewById(R.id.textView15);
        button = findViewById(R.id.button6);
        Rejouer = findViewById(R.id.button7);
    }

    public void score(View view) {
        s++;
        t1.setText(String.valueOf(s));
        if (s >= 5) {
            n++;
            t2.setText(String.valueOf(n));
            Toast.makeText(this, "Passage au niveau suivant", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(this, niveauActivity.class);
            i.putExtra("niveau", n);
            startActivity(i);

            s = 0;
            t1.setText(String.valueOf(s));
        }
    }

    public void rejouer(View view) {
        s = 0;
        n = 1;
        t1.setText(String.valueOf(s));
        t2.setText(String.valueOf(n));
    }
}
