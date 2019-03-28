package com.lentimosystems.licio.futaa2.activities;

import android.app.ProgressDialog;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.gson.Gson;
import com.lentimosystems.licio.futaa2.R;
import com.lentimosystems.licio.futaa2.adapter.PlayerAdapter;
import com.lentimosystems.licio.futaa2.models.Player;
import com.lentimosystems.licio.futaa2.utils.Constants;
import com.lentimosystems.licio.futaa2.utils.MySingleton;



import net.steamcrafted.loadtoast.LoadToast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PlayerActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutmanager;
    private PlayerAdapter mPlayerAdapter;
    private List<Player> mListitem =new ArrayList<>();
    LoadToast loadToast;
    private CardView mCardView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);
        mCardView = findViewById(R.id.card_player_error);
        loadToast = new LoadToast(this);
        settoolbar(getIntent().getStringExtra("teamName"));
        mRecyclerView =findViewById(R.id.player_list);
        mLayoutmanager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutmanager);
        mPlayerAdapter = new PlayerAdapter(this, mListitem);
        getplayers();
    }


    public void getplayers(){
        loadToast.setTranslationY(200)
                .setText("loading data...")
                .setBackgroundColor(Color.BLACK)
                .setProgressColor(Color.WHITE)
                .setTextColor(Color.WHITE)
                .show();
        String url = Constants.BASE_URL+"lookup_all_players.php?id="+getIntent().getStringExtra("teamId");
        JSONObject jsonObject = new JSONObject();
        JsonObjectRequest jsObjRequest = new JsonObjectRequest(Request.Method.GET, url, jsonObject, new Response.Listener<JSONObject>() {


            @Override
            public void onResponse(JSONObject response) {
                try {

                    JSONArray array = response.getJSONArray("player");
                    if (array != null && array.length()>0) {
                        Gson gson = new Gson();
                        for (int i = 0; i < array.length(); i++) {
                            mListitem.add(gson.fromJson(array.getJSONObject(i).toString(), Player.class));

                        }
                        if (mListitem == null || mListitem.isEmpty()) {
                            loadToast.error();
                            setError();

                        } else {
                            loadToast.success();
                            mRecyclerView.setAdapter(mPlayerAdapter);
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
        MySingleton.getInstance(PlayerActivity.this).addToRequestQueue(jsObjRequest);
    }
    public void settoolbar(String title){
        Toolbar toolbar = (Toolbar) findViewById(R.id.player_toolbar);
        setSupportActionBar(toolbar);
        setTitle(title);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
    public void setError(){
        mCardView.setVisibility(View.VISIBLE);
    }
}
