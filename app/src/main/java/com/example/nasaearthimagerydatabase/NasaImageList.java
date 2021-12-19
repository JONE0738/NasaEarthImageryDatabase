package com.example.nasaearthimagerydatabase;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


public class NasaImageList extends ArrayAdapter {
    private String[] imageNames;
    private String[] imageDesc;
    private Integer[] imageid;
    private Activity context;

    public NasaImageList(Activity context, String[] imageNames, String[] imageDesc, Integer[] imageid) {
        super(context, R.layout.row_item, imageNames);
        this.context = context;
        this.imageNames = imageNames;
        this.imageDesc = imageDesc;
        this.imageid = imageid;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row=convertView;
        LayoutInflater inflater = context.getLayoutInflater();
        if(convertView==null)
            row = inflater.inflate(R.layout.row_item, null, true);
        TextView textViewImageName = (TextView) row.findViewById(R.id.textViewImageName);
        TextView textViewImageDesc = (TextView) row.findViewById(R.id.textViewImageDesc);
        ImageView imageViewNasa = (ImageView) row.findViewById(R.id.imageViewNasa);

        textViewImageName.setText(imageNames[position]);
        textViewImageDesc.setText(imageDesc[position]);
        imageViewNasa.setImageResource(imageid[position]);
        return  row;
    }
}