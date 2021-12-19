package com.example.nasaearthimagerydatabase;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class nav_favourites extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    //array variables - did not end up initializing toast for image details due to time constraints
    private final String[] imageNames = {
            "EarthRise",
            "Hubble shot",
            "Venus"
    };

    private final String[] imageDesc = {
            "Famous picture from the Moon",
            "Famous Hubble Telescope picture",
            "Image of Venus"
    };

    private final Integer[] imageid = {
            R.drawable.earthrise,
            R.drawable.hubble,
            R.drawable.venus,
    };

    NavigationView navigationView;
    public DrawerLayout drawerLayout;
    public ActionBarDrawerToggle actionBarDrawerToggle;


    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nav_favourites);

        drawerLayout = findViewById(R.id.my_drawer_layout_favourites);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close);

        //listener to toggle button
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        //make nav icon appear on action bar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //initialize navigation view for handling nav menu onclicks
        navigationView = findViewById(R.id.navigation_favourites);
        navigationView.setNavigationItemSelectedListener(this);

        //setting header
        TextView textView = new TextView(this);
        textView.setTypeface(Typeface.DEFAULT_BOLD);
        textView.setText("List of Nasa Images");

        ListView listView= findViewById(R.id.theList);
        listView.addHeaderView(textView);

        //populating list data
        NasaImageList nasaImageList = new NasaImageList(this, imageNames, imageDesc, imageid);
        listView.setAdapter(nasaImageList);

    }

        //method to handle menu item selection
    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_about:
                Intent intentAbout = new Intent(this, nav_about.class);
                this.startActivity(intentAbout);
                break;


            case R.id.nav_favourites:
                Intent intentFavourites = new Intent(this, nav_favourites.class);
                this.startActivity(intentFavourites);
                break;


            case R.id.nav_coordinates:
                Intent intentCoordinates = new Intent(this, nav_coordinates.class);
                this.startActivity(intentCoordinates);
                break;

        }
        return true;
    }

    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        //make items appear in nav drawer
        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    public void favouritesHelpDialog(View view) {
        //setup the alert builder
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Help menu:");
        builder.setMessage("Welcome to the Favourites page. When you save an image as a favourite, it will show up here. Click the image to see additional details.");
        //add a button
        builder.setPositiveButton("OK", null);
        //create and show the alert dialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
