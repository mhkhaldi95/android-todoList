package com.example.todolist;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUp extends AppCompatActivity {

    private Button register;
    private EditText emailid, passwordd;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);


        mAuth = FirebaseAuth.getInstance();


        emailid = findViewById(R.id.RegisterEmail);
        passwordd = findViewById(R.id.RegisterPassword);
        register = (Button) findViewById(R.id.Register_btn);
        register.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View view) {
                                            String email = emailid.getText().toString();
                                            String password = passwordd.getText().toString();
                                            if (email.isEmpty()) {
                                                emailid.setError("Enter Your Email");
                                                emailid.requestFocus();
                                            } else if (password.isEmpty()) {
                                                passwordd.setError("Enter Your Password");
                                                emailid.requestFocus();
                                            } else if (email.isEmpty() && password.isEmpty()) {
                                                passwordd.setError("Enter Your Password");
                                                Toast.makeText(SignUp.this, "Fields are empty", Toast.LENGTH_SHORT).show();
                                            } else if (!(email.isEmpty() && password.isEmpty())) {
                                                mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(SignUp.this, new OnCompleteListener<AuthResult>() {
                                                    @Override
                                                    public void onComplete(@NonNull Task<AuthResult> task) {
                                                        if (!task.isSuccessful()) {
                                                            Toast.makeText(SignUp.this, "Error in Sign Up Please try again", Toast.LENGTH_SHORT).show();
                                                        } else {
                                                            startActivity(new Intent(SignUp.this, HomeActivity.class));
                                                        }
                                                    }
                                                });
                                            } else {
                                                Toast.makeText(SignUp.this, "Error Occurred!", Toast.LENGTH_SHORT).show();
                                            }
                                        }
                                    }


        );


        TextView tv_register = findViewById(R.id.To_login);
        tv_register.setOnClickListener(view -> {
            Intent intent = new Intent(SignUp.this, LoginActivity.class);
            startActivity(intent);
            finish();
        });
    }
}