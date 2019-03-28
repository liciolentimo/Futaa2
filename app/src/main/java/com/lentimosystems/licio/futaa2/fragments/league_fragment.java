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
import com.lentimosystems.licio.futaa2.adapter.LeagueAdapter;
import com.lentimosystems.licio.futaa2.models.League;
import com.lentimosystems.licio.futaa2.utils.Constants;
import com.lentimosystems.licio.futaa2.utils.MySingleton;



import net.steamcrafted.loadtoast.LoadToast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class league_fragment extends Fragment {
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager mLayoutmanager;
    private LeagueAdapter mAdapter;
    private List<League> mListitem =new ArrayList<>();
    private LoadToast loadToast;
    private CardView mCardView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_league,container,false);
        loadToast = new LoadToast(getActivity());
        recyclerView=view.findViewById(R.id.list);
        mCardView=view.findViewById(R.id.league_error);
        mLayoutmanager=new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutmanager);
        mAdapter =new LeagueAdapter(getContext(),mListitem);
        getlist();
        return view;
    }

    public void getlist(){
        loadToast.setTranslationY(200)
                    .setText("loading data...")
                    .setBackgroundColor(Color.BLACK)
                    .setProgressColor(Color.WHITE)
                    .setTextColor(Color.WHITE)
                    .show();
        String url= Constants.BASE_URL+"search_all_leagues.php?s=soccer";
        JSONObject jsonObject = new JSONObject();
        JsonObjectRequest jsObjRequest = new JsonObjectRequest(Request.Method.GET, url, jsonObject, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {

                try {

                    JSONArray array = response.getJSONArray("countrys");
                    if(array != null && array.length()>0) {
                        Gson gson = new Gson();
                        for (int i = 0; i < array.length(); i++) {
                            mListitem.add(gson.fromJson(array.getJSONObject(i).toString(), League.class));
                        }
                        if (mListitem == null || mListitem.isEmpty()) {
                            loadToast.error();
                            setError();
                        } else {
                            loadToast.success();
                            recyclerView.setAdapter(mAdapter);
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

        MySingleton.getInstance(getActivity()).addToRequestQueue(jsObjRequest);

    }
    public void setError(){
        mCardView.setVisibility(View.VISIBLE);
    }
}
