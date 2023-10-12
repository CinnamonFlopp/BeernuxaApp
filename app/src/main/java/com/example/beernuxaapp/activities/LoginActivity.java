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

public class LoginActivity extends AppCompatActivity {

    private EditText mLogInEmail, mLogInPassword;
    private Button mLogIn;

    private TextView mGoToSignUp;

    private FirebaseAuth firebaseAuth;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        mLogInEmail=findViewById(R.id.signinemail);
        mLogInPassword=findViewById(R.id.signinpassword);
        mLogIn=findViewById(R.id.button);
        mGoToSignUp=findViewById(R.id.gotosingup);




        firebaseAuth=FirebaseAuth.getInstance();
        FirebaseUser firebaseUser=firebaseAuth.getCurrentUser();

        if(firebaseUser!=null){
            finish();
            startActivity(new Intent(LoginActivity.this,MainActivity.class));
        }
        mGoToSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
            }
        });

        mLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mail=mLogInEmail.getText().toString().trim();
                String password=mLogInPassword.getText().toString().trim();

                if(mail.isEmpty() || password.isEmpty()){
                    Toast.makeText(getApplicationContext(),"All Fields Are Required",
                            Toast.LENGTH_SHORT).show();
                }
                else{
                    // Login the user

                    firebaseAuth.signInWithEmailAndPassword(mail,password).
                            addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {

                                    if(task.isSuccessful()){
                                        checkMailVerification();
                                    }
                                    else{
                                        Toast.makeText(getApplicationContext(),
                                                        "Account Doesn't Exist", Toast.LENGTH_SHORT)
                                                .show();
                                    }


                                }
                            });


                }


            }
        });

    }
    private void checkMailVerification(){
        FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();

        if(firebaseUser.isEmailVerified()==true){
            Toast.makeText(getApplicationContext(),
                            "Logged In", Toast.LENGTH_SHORT)
                    .show();
            finish();
            startActivity(new Intent(LoginActivity.this,MainActivity.class));
        }
        else{
            Toast.makeText(getApplicationContext(),
                            "Verify your mail first", Toast.LENGTH_SHORT)
                    .show();
            firebaseAuth.signOut();
        }
    }


}
