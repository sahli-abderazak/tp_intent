package com.example.tp_intent;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity_td2_ex1 extends AppCompatActivity {

    private EditText edittext;
    private Button button1, button2;
    private ImageView imageview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_td2_ex1);

        edittext = findViewById(R.id.edittext);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        imageview = findViewById(R.id.imageView);

        button1.setOnClickListener(view -> {
            String url = edittext.getText().toString();
            if (!url.isEmpty()) {
                if (!url.startsWith("http://") && !url.startsWith("https://")) {
                    url = "http://" + url;
                }
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);
            }
        });

        button2.setOnClickListener(view -> {
            Intent galleryIntent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.INTERNAL_CONTENT_URI);
            startActivityForResult(galleryIntent, 37);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 37 && resultCode == RESULT_OK && data != null) {
            Uri uri = data.getData();
            imageview.setImageURI(uri);
        }
    }
}
