package org.example;

public class Customer {


    private String  ad;

    public String getAd() {
        return ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public int getNumara() {
        return numara;
    }

    private String soyad;
    private int numara;



      public  Customer(String ad, String soyad, int numara){
        this.ad=ad;
        this.soyad=soyad;
        this.numara=numara;


    }




}
