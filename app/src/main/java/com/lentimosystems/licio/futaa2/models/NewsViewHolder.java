package com.lentimosystems.licio.futaa2.models;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.lentimosystems.licio.futaa2.R;


public class NewsViewHolder extends RecyclerView.ViewHolder
{

    public TextView text_title;
    public TextView text_description;
    public ImageView img_news;
    public CardView card_view;

    public NewsViewHolder(View itemView) {
        super(itemView);
        this.text_description=itemView.findViewById(R.id.news_description);
        this.text_title=itemView.findViewById(R.id.news_title);
        this.img_news=itemView.findViewById(R.id.news_image);
        this.card_view=itemView.findViewById(R.id.card_news);

    }
}
