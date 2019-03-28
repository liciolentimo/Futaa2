package com.lentimosystems.licio.futaa2.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.lentimosystems.licio.futaa2.R;
import com.lentimosystems.licio.futaa2.fragments.next_event_fragment;
import com.lentimosystems.licio.futaa2.fragments.results_fragment;
import com.lentimosystems.licio.futaa2.fragments.standing_fragment;



import java.util.Objects;

public class TeamActivity extends AppCompatActivity {

String title;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment=null;
            switch (item.getItemId()) {
                    case R.id.navigation_home:
                    fragment= new standing_fragment();
                    pushFragment(fragment);
                    return true;
                case R.id.navigation_dashboard:
                    fragment=new results_fragment();
                    pushFragment(fragment);
                    return true;
                case R.id.navigation_notifications:
                    fragment=new next_event_fragment();
                    pushFragment(fragment);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team);
        gettitle();
        settoolbar();
        Fragment fragment=new standing_fragment();
        pushFragment(fragment);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    protected void pushFragment(Fragment fragment) {
        if (fragment == null)
            return;

        FragmentManager fragmentManager = getSupportFragmentManager();
        if (fragmentManager != null) {
            FragmentTransaction ft = fragmentManager.beginTransaction();
            if (ft != null) {
                ft.replace(R.id.team_frame_layout, fragment);
                ft.commit();
            }
        }
    }
    public void settoolbar(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.team_toolbar);
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
    public void gettitle(){
        Intent intent =getIntent();
        title= intent.getStringExtra("TeamName");
    }


}
