package com.example.android.quakereport;

import android.content.res.Resources;
import android.text.format.DateFormat;

import java.util.Date;

public class Terremoto {
    private double mMagnitudo;
    private String mCitta;
    private String mDistanza;
    private long mData;

    public Terremoto(double magnitudo,String citta, long data) {
        mMagnitudo=magnitudo;
        mData=data;
        if (citta.contains(" of ")) {
            String[] splitted = citta.split(" of ");
            mDistanza = splitted[0]+" of";
            mCitta = splitted[1];
        }
        else {
            mCitta = citta;
            mDistanza = "Nearby the";
        }
    }

    public double getMagnitudo(){
        return mMagnitudo;
    }

    public String getCitta(){
        return mCitta;
    }

    public String getDistanza() {
        return mDistanza;
    }

    public long getData(){
        return mData;
    }

    public String getNiceData() {
        return DateFormat.format("hh:mm:ss\ndd MMM yyyy", new Date(mData)).toString();
    }
}
