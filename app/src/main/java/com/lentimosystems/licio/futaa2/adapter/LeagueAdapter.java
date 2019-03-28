package com.lentimosystems.licio.futaa2.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;


import com.lentimosystems.licio.futaa2.R;
import com.lentimosystems.licio.futaa2.activities.TeamActivity;
import com.lentimosystems.licio.futaa2.models.League;
import com.lentimosystems.licio.futaa2.models.LeagueViewHolder;

import com.squareup.picasso.Picasso;

import java.util.List;


public class LeagueAdapter extends RecyclerView.Adapter<LeagueViewHolder> {
    private Context mContext;
    private List<League> mItemList;
    private int lastPosition = -1;

    public LeagueAdapter(Context mContext, List<League> mItemList) {
        this.mContext = mContext;
        this.mItemList = mItemList;
    }

    @NonNull
    @Override
    public LeagueViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(mContext).inflate(R.layout.adapter_league,null);
         LeagueViewHolder viewHolder=new LeagueViewHolder(view);
         return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final LeagueViewHolder holder, final int position) {

        holder.text_league_name.setText(mItemList.get(position).getStrLeague());
        holder.text_league_country.setText(mItemList.get(position).getStrCountry());
        Picasso.with(mContext).load(mItemList.get(position).getStrBadge()).into(holder.img_badge);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(mContext, TeamActivity.class);
                intent.putExtra("TeamName",mItemList.get(position).getStrLeague());
                intent.putExtra("leagueId",mItemList.get(position).getIdleague());
                mContext.startActivity(intent);
            }
        });
        setAnimation(holder.itemView,position);
    }

    @Override
    public int getItemCount() {
        return mItemList.size();
    }

    private void setAnimation(View viewToAnimate, int position)
    {
        // If the bound view wasn't previously displayed on screen, it's animated
        if (position > lastPosition)
        {
            Animation animation = AnimationUtils.loadAnimation(mContext,R.anim.item_animation_fall_down);
            animation.setDuration(500);
            viewToAnimate.startAnimation(animation);
            lastPosition = position;
        }
    }
}

