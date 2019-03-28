package com.lentimosystems.licio.futaa2.models;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.lentimosystems.licio.futaa2.R;


public class ResultViewHolder extends RecyclerView.ViewHolder {
   public TextView text_home_team;
    public TextView text_away_team;
    public TextView text_date;
    public TextView text_match_name;
    public ImageView img_home;
    public ImageView img_away;
    public ResultViewHolder(View itemView) {
        super(itemView);
        this.text_match_name=itemView.findViewById(R.id.card_event_match_name);
        this.text_home_team=itemView.findViewById(R.id.card_event_home_team_score);
        this.text_away_team=itemView.findViewById(R.id.card_event_away_team_score);
        this.text_date=itemView.findViewById(R.id.card_event_match_date);
        this.img_home=itemView.findViewById(R.id.card_event_home_team_badge);
        this.img_away=itemView.findViewById(R.id.card_event_away_team_badge);

    }
}
