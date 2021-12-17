package com.example.nasaearthimagerydatabase;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class nav_about extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nav_about);


        //    Toast about_us Jones
        Button btnjones = (Button) findViewById(R.id.jones);
        btnjones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(nav_about.this, "Andrew Jones: 041026305", Toast.LENGTH_LONG ).show();
            }
        });

        //    Toast about_us Barton
        Button btnbarton = (Button) findViewById(R.id.barton);
        btnbarton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(nav_about.this, "Andrew Barton: 041026297", Toast.LENGTH_LONG ).show();
            }
        });
    }
}
