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

public class MainActivity5 extends AppCompatActivity {
    TextView t1,t2,t3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main5);
        t1=findViewById(R.id.textView9);
        t2=findViewById(R.id.textView10);
        t3=findViewById(R.id.textView11);


        Integer x=getIntent().getIntExtra("num1",0);
        Integer x1=getIntent().getIntExtra("num2",0);
        t1.setText(x+"");
        t2.setText(x1+"");

        int res=x+x1;
        t3.setText(res+"");
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void callback(View view) {
        if (t3.getText().toString().isEmpty()) {
            setResult(RESULT_CANCELED);
        } else {
            Intent data = new Intent();
            data.putExtra("n1", t3.getText().toString());
            setResult(RESULT_OK, data);
        }
        finish();
    }
}