package com.example.beernuxaapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.beernuxaapp.MainActivity;
import com.example.beernuxaapp.R;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }

    public void login(View view) {
        startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
    }

    public void mainActivity(View view) {
        startActivity(new Intent(RegisterActivity.this, MainActivity.class));

    }
}