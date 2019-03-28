package com.lentimosystems.licio.futaa2.models;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.androidstudy.daraja.Daraja;
import com.lentimosystems.licio.futaa2.R;

import butterknife.BindView;


public class LeagueViewHolder extends RecyclerView.ViewHolder {

    public TextView text_league_name;
    public TextView text_league_country;
    public ImageView img_badge;
    public CardView cardView;


    public LeagueViewHolder(View itemView) {

        super(itemView);

        this.text_league_name=itemView.findViewById(R.id.card_league_league_name);
        this.text_league_country=itemView.findViewById(R.id.card_league_league_name_country);
        this.img_badge=itemView.findViewById(R.id.card_league_league_badge);
        this.cardView=itemView.findViewById(R.id.card);
    }
}
