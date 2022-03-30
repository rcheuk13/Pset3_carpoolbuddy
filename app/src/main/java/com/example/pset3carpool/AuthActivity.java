package com.example.pset3carpool;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class AuthActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private EditText emailField;
    private EditText passwordField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);

        mAuth = FirebaseAuth.getInstance();
        emailField = findViewById(R.id.editTextEmail);
        passwordField = findViewById(R.id.editTextPassWord);
    }

    public void signIn(View v) {
        System.out.println("Sign in!");
        String emailName = emailField.getText().toString();
        String passwordValue = passwordField.getText().toString();

        //go to firebase and check if the Email and Password exist in the Authentication
        mAuth.signInWithEmailAndPassword(emailName, passwordValue).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {

                    Log.d("SIGN IN", "Successfully signed in with email and password!");
                    FirebaseUser currentUser = mAuth.getCurrentUser();
                    updateUI(currentUser);
                    //send the message to user
                    Toast messageUSer = Toast.makeText(getApplicationContext(), "Correct! Welcome " + emailName, Toast.LENGTH_LONG);
                    messageUSer.show();
                } else {
                    Log.d("SIGN IN", "Sign in with email and password failed.", task.getException());
                    updateUI(null);
                    //send the message to user
                    Toast messageUser = Toast.makeText(getApplicationContext(), "Your Email or Password is Incorrect, please try again.", Toast.LENGTH_LONG);
                    messageUser.show();
                }
            }
        });
    }

    public void userSignUp(View v) {
        //go to UserProfileActivity and sign up
      //  Intent starterPage = new Intent(this, com.example.pset3carpool.UserProfileActivity.class);
      //  startActivity(starterPage);

        System.out.println("xx");
    }

    public void updateUI(FirebaseUser currentUser) {
        if (currentUser != null) {
            //go to MainActivity
            Intent starterPage = new Intent(this, MainActivity.class);
            startActivity(starterPage);
        }
    }
}