package com.example.gabriella.gabriellaapriliana_1202150272_modul3;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {
    TextView mainTitle, count, air;
    ImageView mainImage;
    int water, max, min;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        //initialize the ImageView and title TextView
        TextView mainTitle = (TextView) findViewById(R.id.titleDetail);
        ImageView mainImage = (ImageView) findViewById(R.id.ImageDetail);
        ImageView air = (ImageView) findViewById(R.id.air);

        int water = 0; //memberi nilai awal pada variabel water
        air.setImageLevel(water); //set level pada gambar dengan id air
        Toast.makeText(this, "Air Sedikit", Toast.LENGTH_SHORT).show(); //menampilkan toast

        //menampilkan gambar yang dipilih dari halaman sebelumnya
        Drawable drawable = ContextCompat.getDrawable(this, getIntent().getIntExtra(Main.IMAGE_KEY, 0));

        //membuat objek dan set warna pada objek GradientDrawable
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.GRAY);

        //mengecek drawable kosong atau tidak
        if (drawable != null){
            gradientDrawable.setSize(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }
        //menampilkan title
        mainTitle.setText(getIntent().getStringExtra(Main.TITLE_KEY));

        //Use Glide to load the image into the ImageView
        Glide.with(this).load(getIntent().getIntExtra(Main.IMAGE_KEY, 0)).placeholder(gradientDrawable).into(mainImage);
    }

    public void DecreaseScore(View view) { //method untuk mengurangi bnyak air
        ImageView air = (ImageView) findViewById(R.id.air);
        count = (TextView) findViewById(R.id.count);

        int min = 0; //set value min
        if (water > 0){
            water--; //decrement
            air.setImageLevel(water);
            count.setText(String.valueOf(water) + " L " );
            if ( water == min ){ //jika water mencapai minimal
                Toast.makeText(this, "Air Sedikit", Toast.LENGTH_SHORT).show();//muncul toast
            }
        }

    }
    public void IncreaseScore(View view) { //method untuk menambah banyak air
        ImageView air = (ImageView) findViewById(R.id.air); //referensi ImageView
        count = (TextView) findViewById(R.id.count); //referensi TextView

        int max = 6; //menset value pada variabel max
        if (water < max){ //mangatur kondisi
            water++;//incerement
            air.setImageLevel(water); //setting level
            count.setText(String.valueOf(water) + " L "); //menampilkan text pada variabel count
            if (water == max){ //kondisi jika water mencapai maximal
                Toast.makeText(this, "Air Sudah Penuh", Toast.LENGTH_SHORT).show();//menampilkan toast air penuh
            }
        }
    }
}