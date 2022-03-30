package com.example.pset3carpool;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class VehicleHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    protected TextView modelText;
    protected TextView idText;
    protected TextView typeText;
    com.example.pset3carpool.VehicleRecyclerViewAdapter.vehicleListener listener;

    public VehicleHolder(@NonNull View itemView, com.example.pset3carpool.VehicleRecyclerViewAdapter.vehicleListener listener2) {
        super(itemView);

        modelText = itemView.findViewById(R.id.VehicleModelTextView);
        idText = itemView.findViewById(R.id.IDtextView);
        typeText = itemView.findViewById(R.id.TypeTextView);

        listener = listener2;
        itemView.setOnClickListener(this);
    }

    public void onClick(View v){
        listener.vehicleOnClick(getAdapterPosition());
    }
}
