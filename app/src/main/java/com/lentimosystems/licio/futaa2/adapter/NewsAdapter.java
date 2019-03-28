package com.lentimosystems.licio.futaa2.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;


import com.lentimosystems.licio.futaa2.R;
import com.lentimosystems.licio.futaa2.models.News;
import com.lentimosystems.licio.futaa2.models.NewsViewHolder;

import com.squareup.picasso.Picasso;

import java.util.List;

import static android.view.animation.AnimationUtils.loadAnimation;

public class NewsAdapter extends RecyclerView.Adapter<NewsViewHolder> {
    Context mContext;
    List<News> newsList;
    private int lastPosition = -1;

    public NewsAdapter(Context mContext, List<News> newsList) {
        this.mContext = mContext;
        this.newsList = newsList;
    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(mContext).inflate(R.layout.adapter_news,null);
        return new NewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder newsViewHolder, int position) {
        newsViewHolder.text_description.setText(newsList.get(position).getDescription());
        newsViewHolder.text_title.setText(newsList.get(position).getTitle());
        Picasso.with(mContext).load(newsList.get(position).getUrlToImage()).into(newsViewHolder.img_news);
        setAnimation(newsViewHolder.itemView,position);
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }
    private void setAnimation(View viewToAnimate, int position)
    {
        // If the bound view wasn't previously displayed on screen, it's animated
        if (position > lastPosition)
        {
            Animation animation = AnimationUtils.loadAnimation(mContext, R.anim.item_animation_from_bottom);
            viewToAnimate.startAnimation(animation);
            lastPosition = position;
        }
    }
}
