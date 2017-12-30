package com.example.android.quakereport;

import android.text.format.DateFormat;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Terremoto {
    private double mMagnitudo;
    private String mCitta;
    private long mData;

    public Terremoto(double magnitudo,String citta, long data) {
        mMagnitudo=magnitudo;
        mCitta=citta;
        mData=data;
    }

    public double getMagnitudo(){
        return mMagnitudo;
    }

    public String getCitta(){
        return mCitta;
    }

    public long getData(){
        return mData;
    }

    public String getNiceData() {
        Date dateObject = new Date(mData);

        SimpleDateFormat dateFormatter = new SimpleDateFormat("hh:mm:ss\ndd MMM yyyy");
        String dateToDisplay = dateFormatter.format(dateObject);

        return dateToDisplay;
    }
}
