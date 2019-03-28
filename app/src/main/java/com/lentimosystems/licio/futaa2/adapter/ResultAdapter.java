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
import com.lentimosystems.licio.futaa2.models.Result;
import com.lentimosystems.licio.futaa2.models.ResultViewHolder;
import com.squareup.picasso.Picasso;


import java.util.List;

public class ResultAdapter extends RecyclerView.Adapter<ResultViewHolder>{
    Context mContext;
    List<Result> mResultList;
    private int lastPosition=-1;

    public ResultAdapter(Context mContext, List<Result> mResultList) {
        this.mContext = mContext;
        this.mResultList = mResultList;
    }



    @NonNull
    @Override
    public ResultViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(mContext).inflate(R.layout.adapter_results,null);
        return new ResultViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ResultViewHolder holder, int position) {
        holder.text_match_name.setText(mResultList.get(position).getStrEvent());
        holder.text_date.setText(mResultList.get(position).getDateEvent());
        holder.text_home_team.setText(mResultList.get(position).getIntHomeScore());
        holder.text_away_team.setText(mResultList.get(position).getIntAwayScore());
        Picasso.with(mContext).load(R.drawable.badge2).into(holder.img_home);
        Picasso.with(mContext).load(R.drawable.badge3).into(holder.img_away);
        setAnimation(holder.itemView,position);
    }

    @Override
    public int getItemCount() {
        return mResultList.size();
    }

    private void setAnimation(View viewToAnimate, int position)
    {
        // If the bound view wasn't previously displayed on screen, it's animated
        if (position > lastPosition)
        {
            Animation animation = AnimationUtils.loadAnimation(mContext, R.anim.item_animation_fall_down);
            viewToAnimate.startAnimation(animation);
            lastPosition = position;
        }
    }
}
