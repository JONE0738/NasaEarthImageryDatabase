package com.example.nasaearthimagerydatabase;


import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class nav_coordinates extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nav_coordinates);


        //    Search button for nav_coordinates.xml
        Button btn = (Button)findViewById(R.id.search);
    }
}
