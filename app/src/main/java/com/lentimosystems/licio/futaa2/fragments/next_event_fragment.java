package com.lentimosystems.licio.futaa2.fragments;

import android.app.ProgressDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.gson.Gson;
import com.lentimosystems.licio.futaa2.R;
import com.lentimosystems.licio.futaa2.adapter.NextEventAdapter;
import com.lentimosystems.licio.futaa2.models.Result;
import com.lentimosystems.licio.futaa2.utils.Constants;
import com.lentimosystems.licio.futaa2.utils.MySingleton;


import net.steamcrafted.loadtoast.LoadToast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class next_event_fragment extends Fragment {


    RecyclerView recyclerView;
    RecyclerView.LayoutManager mLayoutmanager;
    NextEventAdapter mNextAdapter;
    List<Result> mNextList = new ArrayList<>();
    LoadToast loadToast;
    CardView card_error;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_next_event,container,false);
        recyclerView = view.findViewById(R.id.next_event_list);
        card_error=view.findViewById(R.id.next_event_error);
        loadToast = new LoadToast(Objects.requireNonNull(getActivity()));
        mLayoutmanager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutmanager);
        mNextAdapter=new NextEventAdapter(getContext(),mNextList);
        getNextEvent();
        return view;
    }

    public void getNextEvent(){
        loadToast.setTranslationY(200)
                .setText("loading data...")
                .setBackgroundColor(Color.BLACK)
                .setProgressColor(Color.WHITE)
                .setTextColor(Color.WHITE)
                .show();

        String url = Constants.BASE_URL+"eventsnextleague.php?id="+getActivity().getIntent().getStringExtra("leagueId");
        JSONObject jsonObject = new JSONObject();
        JsonObjectRequest jsObjRequest = new JsonObjectRequest(Request.Method.GET, url, jsonObject, new Response.Listener<JSONObject>() {


            @Override
            public void onResponse(JSONObject response) {
                try {


                    JSONArray array = response.getJSONArray("events");
                    if(array != null && array.length()>0) {
                        Gson gson = new Gson();
                        for (int i = 0; i < array.length(); i++) {
                            mNextList.add(gson.fromJson(array.getJSONObject(i).toString(), Result.class));

                        }
                        if (mNextList == null || mNextList.isEmpty()) {
                            loadToast.error();
                            card_error.setVisibility(View.VISIBLE);
                        } else {
                            loadToast.success();
                            recyclerView.setAdapter(mNextAdapter);
                        }
                    }else {
                        loadToast.error();
                        Toast.makeText(getContext(),"No data on Server",Toast.LENGTH_LONG).show();
                    }

                } catch (JSONException e) {
                    loadToast.error();
                    setError();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        MySingleton.getInstance(getContext()).addToRequestQueue(jsObjRequest);
    }
    public void setError(){
        card_error.setVisibility(View.VISIBLE);

    }
}
