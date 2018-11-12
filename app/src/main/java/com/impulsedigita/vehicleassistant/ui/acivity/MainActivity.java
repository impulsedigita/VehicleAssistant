package com.impulsedigita.vehicleassistant.ui.acivity;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import com.impulsedigita.vehicleassistant.R;
import com.impulsedigita.vehicleassistant.constant.Constant;
import com.impulsedigita.vehicleassistant.ui.fragment.HomeFragment;
import com.impulsedigita.vehicleassistant.ui.fragment.StatisticFragment;
import com.impulsedigita.vehicleassistant.ui.fragment.TimeLineFragment;
import com.impulsedigita.vehicleassistant.ui.fragment.WeFragment;
import com.impulsedigita.vehicleassistant.util.Utils;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getName();
    private Toolbar toolbar;
    private int color = 0;
    private BottomNavigationView navigation;
    private Activity context;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment = null;

            switch (item.getItemId()) {
                case R.id.navigation_home:
                    fragment = new HomeFragment();
                    color = Constant.THEME1;
                    break;
                case R.id.navigation_statistic:
                    fragment = new StatisticFragment();
                    color = Constant.THEME2;
                    break;
                case R.id.navigation_timeline:
                    fragment = new TimeLineFragment();
                    color = Constant.THEME3;
                    break;
                case R.id.navigation_we:
                    fragment = new WeFragment();
                    color = Constant.THEME4;
                    break;
            }
            return loadFragment(fragment,navigation,color);
        }
    };

    private boolean loadFragment(Fragment fragment,BottomNavigationView navigation,int color) {
        if(fragment != null){
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container,fragment);
            fragmentTransaction.commit();
            //change color theme
            if(navigation != null && color != 0 && context != null){
                Utils.changeThemeColor(context,navigation,color);
            }else{
                Log.d(TAG,"Either navigation, color, context is null");
            }

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

        context = MainActivity.this;

        toolbar = (Toolbar)findViewById(R.id.toolbar);
        TextView mTitle = (TextView) toolbar.findViewById(R.id.toolbar_title);

        navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        loadFragment(new HomeFragment(),navigation,Constant.THEME1);
    }

}
