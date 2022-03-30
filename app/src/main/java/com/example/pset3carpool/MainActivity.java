package com.example.pset3carpool;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);
    }

    //go to AddVehicle Activity
    public void goAddVehicle(View v) {
        Intent startActivity = new Intent(this, com.example.pset3carpool.AddVehicleActivity.class);
        startActivity(startActivity);
    }

    //go to VehicleInfo Activity
    public void goVehicleInfo(View v) {
        Intent startActivity = new Intent(this, com.example.pset3carpool.VehiclesInfoActivity.class);
        startActivity(startActivity);
    }

    public void signOut(View v) {
        //sign out the account and go back to AuthActivity
        FirebaseAuth.getInstance().signOut();
        Intent startActivity = new Intent(this, com.example.pset3carpool.AuthActivity.class);
        startActivity(startActivity);
        //send message to user
        Toast messageUser = Toast.makeText(getApplicationContext(), "Successfully signed out with Email!", Toast.LENGTH_LONG);
        messageUser.show();
    }
}