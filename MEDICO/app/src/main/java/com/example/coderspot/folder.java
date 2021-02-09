package com.example.coderspot;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class folder extends AppCompatActivity {
EditText folderName;
Button savefolder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_folder);
        Button savefolder= findViewById(R.id.folder);
        EditText foldername = findViewById(R.id.foldername);
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference(user.getUid()).child("folders");
        savefolder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
myRef.child(foldername.getText().toString().toUpperCase()).setValue(foldername.getText().toString().toUpperCase());
            }
        });
    }
}