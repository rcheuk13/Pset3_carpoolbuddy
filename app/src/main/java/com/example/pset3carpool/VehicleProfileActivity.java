package com.example.pset3carpool;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class VehicleProfileActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private FirebaseUser mUser;
    private com.example.pset3carpool.Vehicle vehicleInfo;
    TextView model;
    TextView id;
    TextView remainCapacity;
    TextView discountedPrice;
    TextView open;

    com.example.pset3carpool.Vehicle choose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicle_profile);
        mAuth = FirebaseAuth.getInstance();
        mUser = FirebaseAuth.getInstance().getCurrentUser();
        //this.vehicleInfo = new Vehicle(vehicleInfo.getOwner(),vehicleInfo.getModel(),vehicleInfo.getVehicleID(),vehicleInfo.getVehicleType(),vehicleInfo.getCapacity(),vehicleInfo.isOpen(),vehicleInfo.getBasePrice());
        model = findViewById(R.id.Model);
        id = findViewById(R.id.ID);
        remainCapacity = findViewById(R.id.RemainCapacity);
        discountedPrice = findViewById(R.id.DiscountedPrice);
        open = findViewById(R.id.Open);

        choose = com.example.pset3carpool.VehiclesInfoActivity.vehicleP;
    }

    public void setUpButton(View v) {
        String modelName = choose.getModel();
        String idName = choose.getVehicleID();
        String capacityName = choose.getCapacity().toString();
        String priceName = choose.getBasePrice().toString();
        String openName = choose.isOpen().toString();

        model.setText(modelName);
        id.setText(idName);
        remainCapacity.setText(capacityName);
        discountedPrice.setText(priceName);
        open.setText(openName);
    }

    public void Book(View v){
        Integer newCapacity = choose.getCapacity() - 1;
        String resultCapacity = newCapacity.toString();

        remainCapacity.setText(resultCapacity);
        Toast.makeText(this, "You have just booked a seat!", Toast.LENGTH_SHORT).show();
    }

    public void goBack(View v) {
        Intent startActivity = new Intent(this, com.example.pset3carpool.MainActivity.class);
        startActivity(startActivity);
    }
}