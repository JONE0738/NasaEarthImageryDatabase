package com.example.nasaearthimagerydatabase;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageButton;
import android.widget.Toast;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.snackbar.Snackbar;


public class nav_about extends AppCompatActivity {

    public DrawerLayout drawerLayout;
    public ActionBarDrawerToggle actionBarDrawerToggle;


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

        Button btnbartonimage = (Button) findViewById(R.id.bartonimage);
        btnbartonimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar snackbar1 = Snackbar.make(btnbartonimage, "Andrew Barton, resides in Burlington, Ontario", Snackbar.LENGTH_LONG);
                        snackbar1.show();
            }
        });

        Button btnjonesimage = (Button) findViewById(R.id.jonesimage);
        btnjonesimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar snackbar1 = Snackbar.make(btnjonesimage, "Andrew Jones, resides in St. Catharines, Ontario", Snackbar.LENGTH_LONG);
                snackbar1.show();
            }
        });


        drawerLayout = findViewById(R.id.my_drawer_layout_about);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close);

        //listener to toggle button
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        //make nav icon appear on action bar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }


    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_about:

                Intent intent = new Intent(this, nav_about.class);
                startActivity(intent);
                return true;
        }
            //make items appear in nav drawer
        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }



    public void aboutHelpDialog(View view) {
        // setup the alert builder
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Help menu:");
        builder.setMessage("Welcome to the About page. If you would like to learn more about the authors, please click the button below their name. For additional information, feel free to click on their pictures.");
        // add a button
        builder.setPositiveButton("OK", null);
        // create and show the alert dialog
        AlertDialog dialog = builder.create();
        dialog.show();

    }
}
