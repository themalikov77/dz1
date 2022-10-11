package com.example.homework;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {
   EditText editText;
   Button button;
   EditText theme;
   EditText messages;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.email);
        button = findViewById(R.id.button);
        theme = findViewById(R.id.theme);
        messages = findViewById(R.id.messages);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = null, chooser = null;{
                    intent = new Intent(Intent.ACTION_SEND);
                    intent.setData(Uri.parse("mailto:"));
                    String[] to = {editText.getText().toString()};
                    intent.putExtra(Intent.EXTRA_EMAIL, to);
                    intent.putExtra(intent.EXTRA_SUBJECT,theme.getText().toString());
                    intent.putExtra(intent.EXTRA_TEXT,messages.getText().toString());
                    intent.setType("message/rfc822");
                    chooser=Intent.createChooser(intent,"sendEmail");
                    startActivity(chooser);
                }
            }

        });


    }}
