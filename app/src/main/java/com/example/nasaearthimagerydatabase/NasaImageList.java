package com.example.nasaearthimagerydatabase;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


public class NasaImageList extends ArrayAdapter {
    private final String[] imageNames;
    private final String[] imageDesc;
    private final Integer[] imageid;
    private final Activity context;

    public NasaImageList(Activity context, String[] imageNames, String[] imageDesc, Integer[] imageid) {
        super(context, R.layout.row_item, imageNames);
        this.context = context;
        this.imageNames = imageNames;
        this.imageDesc = imageDesc;
        this.imageid = imageid;

    }

    @SuppressLint("InflateParams")
    //inflating the views
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row=convertView;
        LayoutInflater inflater = context.getLayoutInflater();
        if(convertView==null)
            row = inflater.inflate(R.layout.row_item, null, true);
        TextView textViewImageName = row.findViewById(R.id.textViewImageName);
        TextView textViewImageDesc = row.findViewById(R.id.textViewImageDesc);
        ImageView imageViewNasa = row.findViewById(R.id.imageViewNasa);

        textViewImageName.setText(imageNames[position]);
        textViewImageDesc.setText(imageDesc[position]);
        imageViewNasa.setImageResource(imageid[position]);
        return  row;
    }
}