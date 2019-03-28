package com.lentimosystems.licio.futaa2.models;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.lentimosystems.licio.futaa2.R;


public class PlayerViewHolder extends RecyclerView.ViewHolder {
    public TextView text_player_name;
    public TextView text_nationality;
    public TextView text_player_position;
    public TextView text_player_height;
    public TextView text_player_weight;
    public TextView text_player_birth;
    public ImageView img_player;

    public Button btnBuy;
    public PlayerViewHolder(View itemView) {
        super(itemView);
        this.img_player=itemView.findViewById(R.id.card_player_cutout);
        this.text_player_name=itemView.findViewById(R.id.card_player_name);
        this.text_nationality=itemView.findViewById(R.id.card_player_nationality);
        this.text_player_position=itemView.findViewById(R.id.card_player_position);
        this.text_player_height=itemView.findViewById(R.id.card_player_height);
        this.text_player_weight=itemView.findViewById(R.id.card_player_weight);
        this.text_player_birth=itemView.findViewById(R.id.card_player_birthday);

        this.btnBuy=itemView.findViewById(R.id.btnBuy);

    }
}
