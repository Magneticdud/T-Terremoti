package com.example.android.quakereport;

import android.content.AsyncTaskLoader;
import android.content.Context;

import java.util.List;

public class EarthquakeLoader extends AsyncTaskLoader<List<Terremoto>> {

    /** Query URL */
    private String mUrl;

    public EarthquakeLoader(Context context, String url) {
        super(context);
        mUrl=url;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Override
    public List<Terremoto> loadInBackground() {
        if (mUrl==null) {
            return null;
        }
        // Perform the network request, parse the response, and extract a list of earthquakes.
        List<Terremoto> earthquakes = QueryUtils.fetchEarthquakeData(mUrl);
        return earthquakes;
    }
}