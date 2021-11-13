package com.example.signup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Signupactivity extends AppCompatActivity {
    LinearLayout signupp;
    private FirebaseAuth nAuth;

    EditText emailedt,paroledt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        getWindow().setStatusBarColor(Color.TRANSPARENT);
        setContentView(R.layout.activity_signupactivity);
        emailedt=findViewById(R.id.emailedt);
        paroledt=findViewById(R.id.paroledt);
        nAuth = FirebaseAuth.getInstance();

        signupp=findViewById(R.id.mainlogin1);
        signupp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String email=emailedt.getText().toString();
                String parol=paroledt.getText().toString();

                nAuth.createUserWithEmailAndPassword(email,parol).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful())
                        {
                            Toast.makeText(Signupactivity.this, "Saqlandi", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Toast.makeText(Signupactivity.this, "Faqat bir marta ro'yhatdan o'tish mumkin", Toast.LENGTH_SHORT).show();
                        }
                    }
                });


            }
        });
    }
}