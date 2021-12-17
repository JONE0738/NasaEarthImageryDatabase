package com.example.nasaearthimagerydatabase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;



import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

     NavigationView navigationView;
     DrawerLayout drawerLayout;
     ActionBarDrawerToggle actionBarDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //drawer toggle open/close
        drawerLayout = findViewById(R.id.my_drawer_layout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close);
        //listener to toggle button
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        //make nav icon appear on action bar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //initialize navigation view for handling nav menu onclicks
        navigationView = findViewById(R.id.navigation);



    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_about:
                Toast.makeText(this, "test", Toast.LENGTH_LONG);


            case R.id.nav_favourites:
                Intent intentFavourites = new Intent(this, nav_favourites.class);
                this.startActivity(intentFavourites);


            case R.id.nav_coordinates:
                Intent intentCoordinates = new Intent(this, nav_coordinates.class);
                this.startActivity(intentCoordinates);

        }
        return true;
    }

    //menu toggle on press
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        actionBarDrawerToggle.onOptionsItemSelected(item);
        return true;
    }

        public void mainHelpDialog (View view){
            // setup the alert builder
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Help menu:");
            builder.setMessage("Welcome to the Nasa Earth Imagery Database! To search for an image, go to Find Images. To check your favourites, go to the Favourites page. IF you'd like to learn more about the authors, please click on the About page!");
            // add a button
            builder.setPositiveButton("OK", null);
            // create and show the alert dialog
            AlertDialog dialog = builder.create();
            dialog.show();
        }



}


