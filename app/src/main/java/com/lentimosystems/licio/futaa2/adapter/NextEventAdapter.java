package com.lentimosystems.licio.futaa2.adapter;

import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;


import com.lentimosystems.licio.futaa2.R;
import com.lentimosystems.licio.futaa2.models.NextViewHolder;
import com.lentimosystems.licio.futaa2.models.Result;

import com.squareup.picasso.Picasso;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

public class NextEventAdapter extends RecyclerView.Adapter<NextViewHolder> {
    Context mContext;
    List<Result> mNextEvent;
    private int lastPosition = -1;

    public NextEventAdapter(Context mContext, List<Result> mNextEvent) {
        this.mContext = mContext;
        this.mNextEvent = mNextEvent;
    }

    @NonNull
    @Override
    public NextViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(mContext).inflate(R.layout.adapter_next_event,null);
        return new NextViewHolder(view);

    }


    @Override
    public void onBindViewHolder(@NonNull NextViewHolder holder, int position) {
        holder.text_next_event.setText(mNextEvent.get(position).getStrEvent());
        holder.text_next_time.setText(convertToCurrentTimeZone(holder,position));
        holder.text_next_date.setText(mNextEvent.get(position).getStrDate());
        Picasso.with(mContext).load(R.drawable.jersey).into(holder.img_away_jersey);
        Picasso.with(mContext).load(R.drawable.jersey2).into(holder.img_home_jersey);
        setAnimation(holder.itemView,position);

    }

    @Override
    public int getItemCount() {
        return mNextEvent.size();
    }

    private void setAnimation(View viewToAnimate, int position)
    {
        // If the bound view wasn't previously displayed on screen, it's animated
        if (position > lastPosition)
        {
            Animation animation = AnimationUtils.loadAnimation(mContext,R.anim.item_animation_from_right);
            viewToAnimate.startAnimation(animation);
            lastPosition = position;
        }
    }
    public String convertToCurrentTimeZone(NextViewHolder holder , int position) {
        String converted_date = "";
        try {

            DateFormat utcFormat = new SimpleDateFormat("HH:mm:ss");
            utcFormat.setTimeZone(TimeZone.getTimeZone("UTC"));

            Date date = utcFormat.parse(mNextEvent.get(position).getStrTime());

            DateFormat currentTFormat = new SimpleDateFormat("HH:mm:ss");
            currentTFormat.setTimeZone(TimeZone.getTimeZone(getCurrentTimeZone()));

            converted_date =  currentTFormat.format(date);
        }catch (Exception e){ e.printStackTrace();}

        return converted_date;
    }


    //get the current time zone

    public String getCurrentTimeZone(){
        TimeZone tz = Calendar.getInstance().getTimeZone();
        System.out.println(tz.getDisplayName());
        return tz.getID();
    }
}
