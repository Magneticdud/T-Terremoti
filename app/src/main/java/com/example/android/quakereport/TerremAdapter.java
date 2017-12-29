package com.example.android.quakereport;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

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
        magnitudoTextView.setText(String.valueOf(currenTerremoto.getMagnitudo()));

        // Find the TextView in the list_item.xml layout with the ID meaning
        TextView cittaTextView = (TextView) listItemView.findViewById(R.id.citta);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView
        cittaTextView.setText(currenTerremoto.getCitta());

        TextView dataTextView = (TextView) listItemView.findViewById(R.id.data);
        dataTextView.setText(String.valueOf(currenTerremoto.getData()));

        // Return the whole list item layout so that it can be shown in the ListView
        return listItemView;
    }
}