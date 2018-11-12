package com.impulsedigita.vehicleassistant.util;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.support.design.widget.BottomNavigationView;
import android.view.Window;
import android.view.WindowManager;

import com.impulsedigita.vehicleassistant.R;

public class Utils {
    private static final String TAG = Utils.class.getName();

    public static void changeThemeColor(Activity activity, BottomNavigationView navigation, int color){
        //navigation.setItemBackgroundResource(R.color.colorAccent);
        navigation.setBackgroundColor(activity.getResources().getColor(color));
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = activity.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(activity.getResources().getColor(color));
        }
    }
}
