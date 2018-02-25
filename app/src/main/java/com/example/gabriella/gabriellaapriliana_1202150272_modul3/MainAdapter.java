package com.example.gabriella.gabriellaapriliana_1202150272_modul3;


import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;


import java.util.ArrayList;


public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainViewHolder>{
    private ArrayList<Main> mMainData;
    private Context mContext;
    private GradientDrawable mGradientDrawable;

    MainAdapter (Context context, ArrayList<Main> MainData){
        this.mMainData = MainData;
        this.mContext = context;

        mGradientDrawable = new GradientDrawable();
        mGradientDrawable.setColor(Color.GRAY);
    }

    @Override
    public MainViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MainViewHolder(mContext, LayoutInflater.from(mContext).inflate(R.layout.activity_main2, parent, false), mGradientDrawable);
    }

    @Override
    public void onBindViewHolder(MainViewHolder holder, int position) {
        Main currentMain = mMainData.get(position);
        holder.bindTo(currentMain);
    }

    @Override
    public int getItemCount() {
        return mMainData.size();
    }

    public class MainViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView mTitleText;
        private TextView mInfoText;
        private ImageView mMainImage;
        private Main mCurrentMain;
        private Context mContext;
        private GradientDrawable mGradientDrawable;

        MainViewHolder(Context context, View itemView, GradientDrawable gradientDrawable) {
            super(itemView);

            mTitleText = (TextView)itemView.findViewById(R.id.title);
            mInfoText = (TextView)itemView.findViewById(R.id.newsTitle);
            mMainImage = (ImageView)itemView.findViewById(R.id.mainImage);

            mContext = context ;
            mGradientDrawable = gradientDrawable;

            itemView.setOnClickListener(this);

        }

        public void bindTo(Main currentMain) {
            mTitleText.setText((currentMain.getTitle()));
            mInfoText.setText(currentMain.getInfo());

            mCurrentMain = currentMain;

            Glide.with(mContext).load(currentMain.
                    getImageResource()).placeholder(mGradientDrawable).into(mMainImage);
        }

        @Override
        public void onClick(View view) {
            Intent detailIntent = Main.starter(mContext, mCurrentMain.getTitle(),mCurrentMain.getImageResource());
            mContext.startActivity(detailIntent);
        }
    }
}
