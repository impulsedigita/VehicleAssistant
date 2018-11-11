package com.impulsedigita.vehicleassistant.ui.acivity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

import com.impulsedigita.vehicleassistant.R;
import com.impulsedigita.vehicleassistant.ui.fragment.HomeFragment;
import com.impulsedigita.vehicleassistant.ui.fragment.StatisticFragment;
import com.impulsedigita.vehicleassistant.ui.fragment.TimeLineFragment;
import com.impulsedigita.vehicleassistant.ui.fragment.WeFragment;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getName();
    private ActionBar toolbar;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment = null;

            switch (item.getItemId()) {
                case R.id.navigation_home:
                    toolbar.setTitle(R.string.title_home);
                    fragment = new HomeFragment();
                    break;
                case R.id.navigation_statistic:
                    toolbar.setTitle(R.string.title_statistic);
                    fragment = new StatisticFragment();
                    break;
                case R.id.navigation_timeline:
                    toolbar.setTitle(R.string.title_timeline);
                    fragment = new TimeLineFragment();
                    break;
                case R.id.navigation_we:
                    toolbar.setTitle(R.string.title_we);
                    fragment = new WeFragment();
                    break;
            }
            return loadFragment(fragment);
        }
    };

    private boolean loadFragment(Fragment fragment) {
        if(fragment != null){
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container,fragment);
            fragmentTransaction.commit();
            return true;
        }else{
            Log.d(TAG,"fragment is null");
            return false;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = getSupportActionBar();

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        loadFragment(new HomeFragment());
    }

}
