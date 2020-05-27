package com.nimus.whatsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private ImageView imageView;
    private boolean send_status = true;
    private String message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.EditText);
        imageView = findViewById(R.id.fab);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(send_status){
                    message = editText.getText().toString().trim();
                    editText.setText(null);
                    editText.clearFocus();
                    Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MainActivity.this, "Record Audio", Toast.LENGTH_SHORT).show();
                }
            }
        });

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(s.length() > 0){
                    imageView.setImageDrawable(getResources().getDrawable(R.drawable.send,getTheme()));
                    send_status = true;
                }
                else{
                    imageView.setImageDrawable(getResources().getDrawable(R.drawable.mic,getTheme()));
                    send_status = false;
                }
            }
        });


    }
    @Override
    protected void onStart() {
        super.onStart();
        send_status = true;
    }
}
