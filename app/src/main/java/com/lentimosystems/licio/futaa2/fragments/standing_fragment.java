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

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.gson.Gson;
import com.lentimosystems.licio.futaa2.R;
import com.lentimosystems.licio.futaa2.adapter.StandingAdapter;
import com.lentimosystems.licio.futaa2.models.StandingLeagueTable;
import com.lentimosystems.licio.futaa2.utils.Constants;
import com.lentimosystems.licio.futaa2.utils.MySingleton;


import net.steamcrafted.loadtoast.LoadToast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class standing_fragment extends Fragment {
    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutmanager;
    private List<StandingLeagueTable> mStandingList = new ArrayList<>();
    private StandingAdapter mStandingAdapter;
    private LoadToast loadToast;
    private CardView mCardView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_standing, container, false);
        mRecyclerView = view.findViewById(R.id.standing_list);
        mCardView = view.findViewById(R.id.card_standing_error);
        loadToast = new LoadToast(Objects.requireNonNull(getActivity()));
        mLayoutmanager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutmanager);
        mStandingAdapter = new StandingAdapter(getContext(), mStandingList);
        getstandinglist();
        return view;

    }

    public void getstandinglist() {
        loadToast.setTranslationY(200)
                .setText("loading data...")
                .setBackgroundColor(Color.BLACK)
                .setProgressColor(Color.WHITE)
                .setTextColor(Color.WHITE)
                .show();

        String url = Constants.BASE_URL+"lookuptable.php?l="+getActivity().getIntent().getStringExtra("leagueId");
        JSONObject jsonObject = new JSONObject();
        JsonObjectRequest jsObjRequest = new JsonObjectRequest(Request.Method.GET, url, jsonObject, new Response.Listener<JSONObject>() {


            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray array = response.getJSONArray("table");
                    if(array != null && array.length()>0) {
                        Gson gson = new Gson();
                        for (int i = 0; i < array.length(); i++) {
                            mStandingList.add(gson.fromJson(array.getJSONObject(i).toString(), StandingLeagueTable.class));

                        }
                        if (mStandingList == null || mStandingList.isEmpty()) {
                            loadToast.error();
                            setError();
                        } else {
                            loadToast.success();
                            mRecyclerView.setAdapter(mStandingAdapter);

                        }
                    } else {
                        loadToast.error();
                        setError();
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
        mCardView.setVisibility(View.VISIBLE);
    }
}
