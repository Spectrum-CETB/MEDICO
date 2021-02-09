package com.example.coderspot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class prescription extends AppCompatActivity {
EditText patientphone,patient,disease,medicines;
Button btnsavepres;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prescription);
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference(user.getUid()).child("reports");

        EditText patientphone = findViewById(R.id.patientphone);
        EditText patient = findViewById(R.id.patient);
        EditText disease= findViewById(R.id.diseasename);
        EditText medicines = findViewById(R.id.medicines);
        Button btnsavepres = findViewById(R.id.btnsavepres);


      btnsavepres.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              String phone = patientphone.getText().toString().trim();
              String diseasename = disease.getText().toString().trim();
              String name = patient.getText().toString().trim();
              String medicine = medicines.getText().toString().trim();
              prescriptionstorage prescriptionstorage = new prescriptionstorage(phone,diseasename,name,medicine);
              myRef.child(diseasename).setValue(prescriptionstorage);
              Toast.makeText(prescription.this, "ADDED TO FOLDER", Toast.LENGTH_SHORT).show();
          }
      });


    }
}