package com.lentimosystems.licio.futaa2.models;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.lentimosystems.licio.futaa2.R;


public class NextViewHolder extends RecyclerView.ViewHolder {
    public TextView text_next_event;
    public TextView text_next_date;
    public TextView text_next_time;
    public TextView text_next_stadium;
    public ImageView img_home_jersey;
    public ImageView img_away_jersey;
    public NextViewHolder(View itemView) {
        super(itemView);
        this.text_next_event=itemView.findViewById(R.id.card_next_event_name);
        this.text_next_stadium=itemView.findViewById(R.id.card_next_event_stadium);
        this.text_next_date=itemView.findViewById(R.id.card_next_event_date);
        this.text_next_time=itemView.findViewById(R.id.card_next_event_time);
        this.img_home_jersey=itemView.findViewById(R.id.card_next_event_home_team_jersey);
        this.img_away_jersey=itemView.findViewById(R.id.card_next_event_away_team_jersey);
    }
}
