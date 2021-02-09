package com.example.coderspot;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;

public class register extends AppCompatActivity {

    private static final String TAG = "register";
    private TextView mDisplayDate;
    private DatePickerDialog.OnDateSetListener mDateSetListener;
    FirebaseDatabase database = FirebaseDatabase.getInstance();

    public static boolean isAlpha(String s) {
        if (s == null) {
            return false;
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!(c >= 'A' && c <= 'Z') && !(c >= 'a' && c <= 'z')) {
                return false;
            }
        }
        return true;
    }

    private FirebaseAuth firebaseAuth;

    private EditText etmail,etpass,etpass2,etfname,etlname,etphno;
    private TextView etdob;
    private ProgressBar progressBar;

    Button btnregister;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);



        //dob selection

        setContentView(R.layout.activity_register);
        mDisplayDate = (TextView) findViewById(R.id.etdob);

        mDisplayDate.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Calendar dob = Calendar.getInstance();
                int year = dob.get(Calendar.YEAR);
                int month = dob.get(Calendar.MONTH);
                int day = dob.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog db = new DatePickerDialog(
                        register.this,
                        android.R.style.Theme_Holo_Dialog_MinWidth,
                        mDateSetListener,
                        year, month, day);
                db.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                db.show();

            }
        });

        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                Log.d(TAG, "onDateSet: mm/dd/yyyy: " + month + "/" + day + "/" + year);

                String date = month + "/" + day + "/" + year;
                mDisplayDate.setText(date);
            }
        };

        //registration form

        etmail =  findViewById(R.id.etmail);
        etpass =  findViewById(R.id.etpass);
        etfname =  findViewById(R.id.etfname);
        etlname =  findViewById(R.id.etfname);
        etdob = (TextView) findViewById(R.id.etdob);
        etphno =  findViewById(R.id.etphno);
        etpass2 =  findViewById(R.id.etpass2);
        progressBar = findViewById(R.id.progressBar);
        progressBar.setVisibility(View.GONE);

        btnregister =  findViewById(R.id.btnregister);

        firebaseAuth = FirebaseAuth.getInstance();

        btnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (btnregister.getId()){
                    case R.id.btnregister:
                        registerUser();
                        break;
                }
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (firebaseAuth.getCurrentUser() != null) {
            startActivity(new Intent(register.this, tabactivity.class));
        }
    }
    //  btnregister.setOnClickListener(new View.OnClickListener() {
          //  @Override
           // public void onClick(View v) {

            private void registerUser(){


                //getting all values frm txt field

               // final String lname = etlname.getText().toString().trim();
                final String fname = etfname.getText().toString().trim();
                final String email = etmail.getText().toString().trim();
                final String phno = etphno.getText().toString().trim();
                final String dob = etdob.getText().toString().trim();
                String password = etpass.getText().toString().trim();
                String password2 = etpass2.getText().toString().trim();

                if (TextUtils.isEmpty(fname)){
                    Toast.makeText(register.this, "This Field Cannot Be Empty" ,Toast.LENGTH_SHORT).show();
                    return;
                }
              /*  if (TextUtils.isEmpty(lname)){

                    Toast.makeText(register.this, "This Field Cannot Be Empty" ,Toast.LENGTH_SHORT).show();
                    return;
                }*/
                if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                    Toast.makeText(register.this, "This Field Cannot Be Empty" ,Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(phno)){
                    Toast.makeText(register.this, "Please Enter Valid Email" ,Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(dob)){
                    Toast.makeText(register.this, "This Field Cannot Be Empty" ,Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(password)){
                    Toast.makeText(register.this, "This Field Cannot Be Empty" ,Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(password2)){
                    Toast.makeText(register.this, "This Field Cannot Be Empty" ,Toast.LENGTH_SHORT).show();
                    return;
                }

                if(password.length()<6){
                    Toast.makeText(register.this, "Password Too Short" , Toast.LENGTH_SHORT).show();
                }
                if (phno.length() != 10){

                    Toast.makeText(register.this, "Phone No must be 0f 10 digit" , Toast.LENGTH_SHORT).show();
                }




                //password verify and signup
                if(password.equals(password2)) {

                        progressBar.setVisibility(View.VISIBLE);
                        firebaseAuth.createUserWithEmailAndPassword(email, password)
                                .addOnCompleteListener(register.this, new OnCompleteListener<AuthResult>() {
                                    @Override
                                    public void onComplete(@NonNull Task<AuthResult> task) {
                                        progressBar.setVisibility(View.GONE);
                                        if (task.isSuccessful()) {
                                            // Sign in success, update UI with the signed-in user's information
                                            NewReg userreg =new NewReg (
                                                    fname,
                                                    email,
                                                    phno,
                                                    dob
                                            );
                                            FirebaseDatabase.getInstance().getReference("user")
                                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                                    .setValue(userreg).addOnCompleteListener(new OnCompleteListener<Void>() {
                                                @Override
                                                public void onComplete(@NonNull Task<Void> task) {
                                                    if (task.isSuccessful()) {
                                                        Toast.makeText(register.this, "Resister Success", Toast.LENGTH_LONG).show();
                                                        startActivity(new Intent(register.this, tabactivity.class));

                                                    }
                                                    else {
                                                        Toast.makeText(register.this, "Resister Not Successfull" ,Toast.LENGTH_LONG).show();
                                                    }
                                                }
                                            });

                                        } else {
                                            // If sign in fails, display a message to the user.
                                            Toast.makeText(register.this, "Authentication Failed", Toast.LENGTH_SHORT).show();
                                        }

                                        // ...
                                    }
                                });


                        }
                        else{
                            Toast.makeText(register.this, "Passwords do not match", Toast.LENGTH_SHORT).show();
                        }
                    }
                }







