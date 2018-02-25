package com.example.gabriella.gabriellaapriliana_1202150272_modul3;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.DrawableRes;

class Main {

    private final String title;
    private final String info;
    private final int imageResource;

    static final String TITLE_KEY = "Title";
    static final String IMAGE_KEY = "Image Resource";

    Main(String title, String info, int imageResource){
        this.title = title;
        this.info = info;
        this.imageResource = imageResource;
    }
    String getTitle()  //method untuk menampilkan title
    {
        return title; //menampilkan title
    }
    String getInfo() //method untuk menampilkan info
    {
        return info; //menampilkan info
    }
    int getImageResource() //method untuk menampilkan gambar
    {
        return imageResource; //menampilkan gambar
    }
    static Intent starter(Context context, String title, @DrawableRes int imageResId){
        Intent detailIntent = new Intent(context, DetailActivity.class); //pindah ke halaman DetailActivity.java
        detailIntent.putExtra(TITLE_KEY, title); //menampilkan title
        detailIntent.putExtra(IMAGE_KEY, imageResId); // dan menampilkan gambar yang dipilih pada halaman DetailActivity.java
        return detailIntent;
    }
}