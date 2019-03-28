package com.lentimosystems.licio.futaa2.models;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.lentimosystems.licio.futaa2.R;


public class StandingViewHolder extends RecyclerView.ViewHolder {

    public TextView text_teamname;
    public TextView text_played;
    public TextView text_win;
    public TextView text_draw;
    public TextView text_loss;
    public ImageView img_badge;
    public CardView standing_cardview;


    public StandingViewHolder(View itemView) {
        super(itemView);
        this.text_teamname=itemView.findViewById(R.id.card_league_table_team_name);
        this.text_played=itemView.findViewById(R.id.card_league_table_played);
        this.text_win=itemView.findViewById(R.id.card_league_table_win);
        this.text_draw=itemView.findViewById(R.id.card_league_table_draw);
        this.text_loss=itemView.findViewById(R.id.card_league_table_loss);
        this.img_badge=itemView.findViewById(R.id.card_league_table_team_badge);
        this.standing_cardview=itemView.findViewById(R.id.standing_card);
    }
}
