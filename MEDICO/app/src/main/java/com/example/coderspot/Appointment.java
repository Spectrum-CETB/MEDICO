package com.example.coderspot;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.coderspot.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Appointment extends AppCompatActivity {
    EditText doctor,patient,number,disease;
    Button btn;
    FirebaseDatabase rootNode;
    DatabaseReference reference;
FirebaseUser user1 = FirebaseAuth.getInstance().getCurrentUser();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment);
        doctor=findViewById(R.id.doc_name);
        patient=findViewById(R.id.patient_name);
        number=findViewById(R.id.phone);
        disease=findViewById(R.id.disease);
        btn=findViewById(R.id.btnsave);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rootNode=FirebaseDatabase.getInstance();
                reference=rootNode.getReference("users").child(user1.getUid());
                String docName=doctor.getText().toString();
                String patientName=patient.getText().toString();
                String patientphone=number.getText().toString();
                String diseasecName=disease.getText().toString();

                if(docName.isEmpty())
                {
                    doctor.setError("Enter Name");
                    doctor.requestFocus();
                }
                else if (patientName.isEmpty())
                {
                    patient.setError("Enter patient Name");
                    patient.requestFocus();

                }
                else if (diseasecName.isEmpty())
                {
                    disease.setError("Enter Name");
                    disease.requestFocus();

                }


                User user =new User(docName,patientName,patientphone,diseasecName);

                reference.child(patientName).setValue(user);

                Toast.makeText(Appointment.this,"DETAILS SAVED",Toast.LENGTH_SHORT).show();
            }
        });


    }
}