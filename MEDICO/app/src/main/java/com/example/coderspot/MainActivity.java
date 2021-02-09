package com.example.coderspot;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {





    private static int time = 2000;
    RelativeLayout rellayout, rellayout2;
    Handler handler = new Handler();
    private FirebaseAuth mAuth;
    Button btnlogin;
    EditText etpassword, etusername;
    TextView btnregister;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);
        mAuth = FirebaseAuth.getInstance();
        if (mAuth.getCurrentUser() != null) {
            // User is signed in (getCurrentUser() will be null if not signed in)
            Intent intent = new Intent(MainActivity.this, tabactivity.class);
            startActivity(intent);
            finish();
        }
        final RelativeLayout rellayout = findViewById(R.id.rellayout);
        final RelativeLayout rellayout2 = findViewById(R.id.rellayout2);
        final EditText etusername = findViewById(R.id.etusername);
        final EditText etpassword = findViewById(R.id.etpassword);
        Button btnlogin = findViewById(R.id.btnlogin);

        TextView btnregister = findViewById(R.id.btnregister);
        btnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, register.class));
            }
        });

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAuth = FirebaseAuth.getInstance();
                final FirebaseAuth mAuth = FirebaseAuth.getInstance();
                String email = etusername.getText().toString().trim();
                String password = etpassword.getText().toString().trim();
                Toast.makeText(MainActivity.this, "LOADING....", Toast.LENGTH_SHORT).show();
                mAuth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information

                                    FirebaseUser user = mAuth.getCurrentUser();
                                    startActivity(new Intent(MainActivity.this, tabactivity.class));

                                } else {
                                    // If sign in fails, display a message to the user.

                                    Toast.makeText(MainActivity.this, "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();

                                }

                                // ...
                            }
                        });
            }


        });
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                rellayout.setVisibility(View.VISIBLE);
                rellayout2.setVisibility(View.VISIBLE);
            }
        }, time);
    }
}






