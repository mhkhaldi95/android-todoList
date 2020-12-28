package com.example.todolist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        TextView tv_splash_next = findViewById(R.id.To_tasksList);
        tv_splash_next.setOnClickListener(view -> {
            Intent intent = new Intent(SplashActivity.this, SignUp.class);
            startActivity(intent);
        });


    }
}