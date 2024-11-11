package com.example.tp_intent;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity4 extends AppCompatActivity {
    EditText ed1,ed2;
    TextView ed3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main4);
        ed1=findViewById(R.id.editTextText4);
        ed2=findViewById(R.id.editTextText5);
        ed3=findViewById(R.id.textView7);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void addition(View view) {
        Integer x=Integer.parseInt(ed1.getText().toString());
        Integer x1=Integer.parseInt(ed2.getText().toString());
        Intent i =new Intent(MainActivity4.this,MainActivity5.class);
        i.putExtra("num1",x);
        i.putExtra("num2",x1);
        startActivityForResult(i,10);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==10){
            if(resultCode==RESULT_OK) {
                ed3.setText("la somme est :"+data.getStringExtra("n1"));
            }
            else{
                Toast.makeText(MainActivity4.this, "No response", Toast.LENGTH_LONG).show();
            }
        }
    }
}