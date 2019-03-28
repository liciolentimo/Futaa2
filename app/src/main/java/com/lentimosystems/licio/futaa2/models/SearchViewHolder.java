package com.lentimosystems.licio.futaa2.models;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.lentimosystems.licio.futaa2.R;


public class SearchViewHolder extends RecyclerView.ViewHolder {

    public TextView text_sreach_name;
    public TextView text_search_stadium;
    public TextView text_search_league;
    public TextView text_search_sport;
    public CardView card_search;
    public ImageView img_home_badge;
    public ImageView img_home_jersy;

    public SearchViewHolder(View itemView) {
        super(itemView);

        this.text_sreach_name=itemView.findViewById(R.id.card_search_team_name);
        this.text_search_stadium=itemView.findViewById(R.id.card_search_team_stadium);
        this.text_search_league=itemView.findViewById(R.id.card_search_team_league);
        this.text_search_sport=itemView.findViewById(R.id.card_search_team_sport);
        this.card_search=itemView.findViewById(R.id.card_search_list);
        this.img_home_jersy=itemView.findViewById(R.id.card_search_event_home_team_jersey);
        this.img_home_badge=itemView.findViewById(R.id.card_next_event_home_team_badge);
        }
}
