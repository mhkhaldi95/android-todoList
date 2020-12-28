package com.example.todolist;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        TextView tv_register = findViewById(R.id.To_SignUp);
        tv_register.setOnClickListener(view -> {
            Intent intent = new Intent(LoginActivity.this, SignUp.class);
            startActivity(intent);
            finish();
        });

    }
}