package com.lentimosystems.licio.futaa2.fragments;

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
import com.lentimosystems.licio.futaa2.adapter.SearchTeamAdapter;
import com.lentimosystems.licio.futaa2.models.Team;
import com.lentimosystems.licio.futaa2.utils.Constants;
import com.lentimosystems.licio.futaa2.utils.MySingleton;


import net.steamcrafted.loadtoast.LoadToast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class search_team_fragment extends Fragment {

    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutmanager;
    private SearchTeamAdapter mSearchAdapter;
    private List<Team> mListitem =new ArrayList<>();
    LoadToast loadToast;
    private CardView mCardView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_search_team,container,false);
        mRecyclerView =view.findViewById(R.id.search_team_list);
        loadToast = new LoadToast((getActivity()));
        mCardView = view.findViewById(R.id.card_search_team_error);
        mLayoutmanager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutmanager);
        mSearchAdapter = new SearchTeamAdapter(getActivity(), mListitem);
        getTeams();
        return view;
    }

    public void getTeams(){
        loadToast.setTranslationY(200)
                .setText("loading data...")
                .setBackgroundColor(Color.BLACK)
                .setProgressColor(Color.WHITE)
                .setTextColor(Color.WHITE)
                .show();
        String url = Constants.BASE_URL+"searchteams.php?s=soccer&t="+ Objects.requireNonNull(getActivity()).getIntent().getStringExtra("Query");

        JSONObject jsonObject = new JSONObject();
        JsonObjectRequest jsObjRequest = new JsonObjectRequest(Request.Method.GET, url, jsonObject, new Response.Listener<JSONObject>() {


            @Override
            public void onResponse(JSONObject response) {

                try {
                    JSONArray array = response.getJSONArray("teams");
                    if(array != null && array.length()>0) {

                        Gson gson = new Gson();
                        for (int i = 0; i < array.length(); i++) {
                            mListitem.add(gson.fromJson(array.getJSONObject(i).toString(), Team.class));

                        }
                        if (mListitem.isEmpty() || mListitem == null) {
                            loadToast.error();
                            setError();
                        } else {
                            loadToast.success();
                            mRecyclerView.setAdapter(mSearchAdapter);
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
