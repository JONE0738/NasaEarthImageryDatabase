package com.example.nasaearthimagerydatabase;


import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

public class nav_favourites extends AppCompatActivity {

    public DrawerLayout drawerLayout;
    public ActionBarDrawerToggle actionBarDrawerToggle;

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
    }

    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        //make items appear in nav drawer
        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    public void favouritesHelpDialog(View view) {
        // setup the alert builder
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Help menu:");
        builder.setMessage("Welcome to the Favourites page. When you save an image as a favourite, it will show up here. Click the image to see additional details.");
        // add a button
        builder.setPositiveButton("OK", null);
        // create and show the alert dialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
