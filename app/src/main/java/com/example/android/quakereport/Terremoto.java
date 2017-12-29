package com.example.android.quakereport;

public class Terremoto {
    private double mMagnitudo;
    private String mCitta;
    private int mData;

    public Terremoto(double magnitudo,String citta, int data) {
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

    public int getData(){
        return mData;
    }
}
