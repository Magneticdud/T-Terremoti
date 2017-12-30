package com.example.android.quakereport;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;

import static java.lang.Math.log;

public class TerremAdapter extends ArrayAdapter<Terremoto> {
    public TerremAdapter(Activity context, ArrayList<Terremoto> terremoti) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, terremoti);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.terremolist, parent, false);
        }

        // Get the {@link Word} object located at this position in the list
        Terremoto currenTerremoto = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID hanzi
        TextView magnitudoTextView = (TextView) listItemView.findViewById(R.id.magnitudo);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        DecimalFormat formatter = new DecimalFormat("0.0");
        String convertito = formatter.format(currenTerremoto.getMagnitudo());
        magnitudoTextView.setText(convertito);

        // Find the TextView in the list_item.xml layout with the ID meaning
        TextView cittaTextView = (TextView) listItemView.findViewById(R.id.citta);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView
        cittaTextView.setText(currenTerremoto.getCitta());

        TextView distanzaTextView = (TextView) listItemView.findViewById(R.id.distanza);
        distanzaTextView.setText(currenTerremoto.getDistanza());

        TextView dataTextView = (TextView) listItemView.findViewById(R.id.data);
        dataTextView.setText(currenTerremoto.getNiceData());


        // Set the proper background color on the magnitude circle.
        // Fetch the background from the TextView, which is a GradientDrawable.
        GradientDrawable magnitudeCircle = (GradientDrawable) magnitudoTextView.getBackground();

        // Get the appropriate background color based on the current earthquake magnitude
        int magnitudeColor = getMagnitudeColor(currenTerremoto.getMagnitudo());

        // Set the color on the magnitude circle
        magnitudeCircle.setColor(magnitudeColor);

        // Return the whole list item layout so that it can be shown in the ListView
        return listItemView;
    }

    private int getMagnitudeColor(double magnitudo){
        //https://stackoverflow.com/questions/340209/generate-colors-between-red-and-green-for-a-power-meter
        //allora: magnitudo fino a 2, H tra 0.5 e 0.6
        //magnitudo fino a 3 si va a 0.4
        //magnitudo fino a 4 si va a 0.2
        //magnitudo di 10 si va a 0.0
        //se superiore a 8 brightness meno .3
        //curva che passa dai punti {{0,0.6},{2,0.5},{3,0.4},{4,0.2},{6,0.1},{10,0}}
        // -0.3*log(0.1*magnitudo)
        float[] HSV = new float [3];
        double H = -0.2*log(0.1*magnitudo)*360;
        if (H>=0.6*360) {
            //diventa blu
            H = 215;
        } else if (H<=0) {
            //diventa rosso
            H = 0;
        }
        HSV[0] = (float)H;
        HSV[1] = (float)0.9; // Saturation
        HSV[2] = (float)0.9; // Brightness
        if (magnitudo>7.0) {
            HSV[2] = HSV[2]-(float)0.3;
        }
        int colore = Color.HSVToColor(HSV);

        return colore;
    }
}