package com.example.sendandretrievedatatestfirebase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    EditText emailET,passwordET;
    TextView emailTV,passwordTV;
    Button getBTN;
    String value1;
    String value2;
    FirebaseDatabase database;
    DatabaseReference myRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emailET = findViewById(R.id.emailEV);
        passwordET = findViewById(R.id.passwordET);
        emailTV = findViewById(R.id.emailAreaTV);
        passwordTV = findViewById(R.id.passwordAreaTV);
        // Write a message to the database
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("messages");

//        myRef.setValue("aasim");

        getBTN = findViewById(R.id.getBTN);

        getBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                emailTV.setText(value1);
                passwordTV.setText(value2);
            }
        });
        // Read from the database

        myRef = database.getReference("messages");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                value1 = dataSnapshot.getValue(String.class);


            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value

            }
        });


        myRef = database.getReference("message");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                value2 = dataSnapshot.getValue(String.class);


            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value

            }
        });


    }
}