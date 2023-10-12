package com.example.beernuxaapp.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.beernuxaapp.MainActivity;
import com.example.beernuxaapp.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class RegisterActivity extends AppCompatActivity {

    private EditText mSignUpEmail, mSignUpPassword;
    private Button mSignUp;
    private TextView mGoToLogIn;

    private FirebaseAuth firebaseAuth;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mSignUpEmail=findViewById(R.id.signupemail);
        mSignUpPassword=findViewById(R.id.signuppassword);
        mSignUp=findViewById(R.id.button);
        mGoToLogIn=findViewById(R.id.gotologin);

        firebaseAuth=FirebaseAuth.getInstance();

        mGoToLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });
        mSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String mail=mSignUpEmail.getText().toString().trim();
                String password=mSignUpPassword.getText().toString().trim();

                if(mail.isEmpty() || password.isEmpty()){
                    Toast.makeText(getApplicationContext(),"All fields are Required",
                            Toast.LENGTH_SHORT).show();
                }
                else if(password.length()<7){
                    Toast.makeText(getApplicationContext(),
                            "Password length should be greater than 7 digits",
                            Toast.LENGTH_SHORT).show();
                }
                else{

                    firebaseAuth.createUserWithEmailAndPassword(mail,password)
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {

                                    if(task.isSuccessful()){
                                        Toast.makeText(getApplicationContext(),
                                                "Registration Succesfull",
                                                Toast.LENGTH_SHORT).show();
                                        sendEmailVerification();
                                    }
                                    else{
                                        Toast.makeText(getApplicationContext(),
                                                "Failed To Register",
                                                Toast.LENGTH_SHORT).show();
                                    }

                                }
                            });

                }



            }
        });

    }


    //send email verification
    private void sendEmailVerification(){
        FirebaseUser firebaseUser=firebaseAuth.getCurrentUser();
        if(firebaseUser!=null){
            firebaseUser.sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    Toast.makeText(getApplicationContext(),
                            "Verification Email is Sent, " +
                                    "Verify and Log In Again",
                            Toast.LENGTH_SHORT).show();
                    firebaseAuth.signOut();
                    finish();
                    startActivity(new Intent(RegisterActivity.this,MainActivity.class));
                }
            });
        }
        else{
            Toast.makeText(getApplicationContext(),
                    "Failed To Send Verification Email",
                    Toast.LENGTH_SHORT).show();
        }
    }





    public void mainActivity(View view) {
        startActivity(new Intent(RegisterActivity.this, MainActivity.class));

    }
}