package com.example.nasaearthimagerydatabase;


import android.app.DownloadManager;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.telephony.mbms.DownloadProgressListener;
import android.widget.Button;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Timer;
import java.util.TimerTask;

public class nav_coordinates extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    NavigationView navigationView;
    public DrawerLayout drawerLayout;
    public ActionBarDrawerToggle actionBarDrawerToggle;



    EditText num1, num2;
    Button btn;
    String strUrl;
    ImageView imageView;
    ProgressBar pb;
    int counter = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nav_coordinates);



        //    Search button for nav_coordinates.xml
        Button btn = (Button)findViewById(R.id.search);

        drawerLayout = findViewById(R.id.my_drawer_layout_coordinates);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close);

        //listener to toggle button
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        //make nav icon appear on action bar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //initialize navigation view for handling nav menu onclicks
        navigationView = (NavigationView) findViewById(R.id.navigation_coordinates);
        navigationView.setNavigationItemSelectedListener(this);





        num1 = (EditText) findViewById(R.id.xaxis);
        num2 = (EditText) findViewById(R.id.yaxis);

        btn = (Button) findViewById(R.id.search);
        imageView = (ImageView) findViewById(R.id.imgView);
        btn.setOnClickListener(new View.OnClickListener() {

            // initializing variables for imagedownload
            @Override
            public void onClick(View view) {

                int i = Integer.parseInt(num1.getText().toString());
                int j = Integer.parseInt(num2.getText().toString());
                strUrl = "https://api.nasa.gov/planetary/earth/imagery?lon=" + i + "&lat=" + j  +"&date=2014-02-01&api_key=fEABokEsfpfxGol138RGYI97Vi6G48t0lvdmKsku";
                new ImageDownloader().execute(strUrl);


            }


        });
    }

        private class ImageDownloader extends AsyncTask<String, Void, Bitmap> {
            ProgressDialog progressDialog;
            HttpURLConnection httpURLConnection;

            @Override
            protected Bitmap doInBackground(String... strings) {

                try {
                    URL url = new URL(strings[0]);
                    httpURLConnection = (HttpURLConnection) url.openConnection();
                    InputStream inputStream = new BufferedInputStream(httpURLConnection.getInputStream());
                    Bitmap image = BitmapFactory.decodeStream(inputStream);
                    return image;


                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }finally {
                    httpURLConnection.disconnect();
                }
                return null;
            }

            @Override
            protected void onPostExecute(Bitmap bitmap) {
                if (bitmap != null) {
                    imageView.setImageBitmap(bitmap);
                    Toast.makeText(getApplication(), "Download Successful", Toast.LENGTH_SHORT).show();
                    progressDialog.setProgress(100);
                    progressDialog.hide();
                } else{
                    Toast.makeText(getApplication(), "Invalid Coordinates", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            protected void onProgressUpdate(Void... values) {

            }

            @Override
            protected void onPreExecute() {
                progressDialog = new ProgressDialog(nav_coordinates.this);
                progressDialog.setTitle("Downloading...");
                progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                progressDialog.setMax(100);
                progressDialog.setProgress(5);
                progressDialog.show();

            }
        }



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


    public void coordinatesHelpDialog(View view) {
        // setup the alert builder
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Help menu:");
        builder.setMessage("Welcome to the Coordinates page. Please input the appropriate X and Y coordinates to retrieve the image from Nasa Satellite Imagery");
        // add a button
        builder.setPositiveButton("OK", null);
        // create and show the alert dialog
        AlertDialog dialog = builder.create();
        dialog.show();

    }
}
