package com.lentimosystems.licio.futaa2.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.lentimosystems.licio.futaa2.R;
import com.lentimosystems.licio.futaa2.adapter.NewsAdapter;
import com.lentimosystems.licio.futaa2.models.LiveScore;


import java.util.ArrayList;
import java.util.List;

public class livescore_fragment extends Fragment {
    RecyclerView recyclerView;
    RecyclerView.LayoutManager mLayoutmanager;
    NewsAdapter mNewsAdapter;
    List<LiveScore> mLivelist = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_livescore,container,false);

        return view;
    }
}
