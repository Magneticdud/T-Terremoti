package com.example.android.quakereport;

import android.text.format.DateFormat;

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
        return DateFormat.format("hh:mm:ss\ndd/MM/yyyy", new Date(mData)).toString();
    }
}
