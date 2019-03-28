package com.lentimosystems.licio.futaa2.adapter;

import android.annotation.SuppressLint;
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
import com.lentimosystems.licio.futaa2.activities.PlayerActivity;
import com.lentimosystems.licio.futaa2.models.StandingLeagueTable;
import com.lentimosystems.licio.futaa2.models.StandingViewHolder;
import com.squareup.picasso.Picasso;

import java.util.List;

public class StandingAdapter extends RecyclerView.Adapter<StandingViewHolder> {

    private Context mContext;
    private List<StandingLeagueTable> mStandinglist;

    private int lastPosition=-1;
    public StandingAdapter(Context mContext, List<StandingLeagueTable> mStandinglist) {
        this.mContext = mContext;
        this.mStandinglist = mStandinglist;
    }

    @NonNull
    @Override
    public StandingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(mContext).inflate(R.layout.adapter_standing,null);
        return new StandingViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull StandingViewHolder holder, final int position) {
        holder.text_teamname.setText(mStandinglist.get(position).getName()+"\nGames");
        holder.text_win.setText(String.valueOf(mStandinglist.get(position).getWin())+"\nWin");
        holder.text_draw.setText(String.valueOf(mStandinglist.get(position).getDraw())+"\nDraw");
        holder.text_played.setText(String.valueOf(mStandinglist.get(position).getPlayed())+"\nPlayed");
        holder.text_loss.setText(String.valueOf(mStandinglist.get(position).getLoss())+"\nLoss");


       // Picasso.with(mContext).load(mBadgeList.get(position).getStrTeamBadge());
        Picasso.with(mContext).load(R.drawable.badge).into(holder.img_badge);
        holder.standing_cardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(mContext, PlayerActivity.class);
               intent.putExtra("teamId",String.valueOf(mStandinglist.get(position).getTeamid()))
                     .putExtra("teamName",mStandinglist.get(position).getName());
               mContext.startActivity(intent);
            }
        });
        setAnimation(holder.itemView,position);
    }

    @Override
    public int getItemCount() {
        return mStandinglist.size() ;
    }

    private void setAnimation(View viewToAnimate, int position)
    {
        // If the bound view wasn't previously displayed on screen, it's animated
        if (position > lastPosition)
        {
            Animation animation = AnimationUtils.loadAnimation(mContext, android.R.anim.slide_in_left);
            viewToAnimate.startAnimation(animation);
            lastPosition = position;
        }
    }



}
