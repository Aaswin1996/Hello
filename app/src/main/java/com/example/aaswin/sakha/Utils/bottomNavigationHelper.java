package com.example.aaswin.sakha.Utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.view.MenuItem;

import com.example.aaswin.sakha.HomeActivity;
import com.example.aaswin.sakha.LikesandGroupActivity;
import com.example.aaswin.sakha.Profile.ProfileActivity;
import com.example.aaswin.sakha.R;
import com.example.aaswin.sakha.SearchActivity;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

/**
 * Created by aaswin on 7/1/18.
 */

public class bottomNavigationHelper {
    public void utilfunctions(BottomNavigationViewEx obj)
    {
       obj.enableAnimation(false);
        obj.enableShiftingMode(false);
        obj.enableItemShiftingMode(false);
    }

    public  void enableNavigation(final Context context, BottomNavigationViewEx obj)
    {
        obj.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.bbn_item1:
                        Intent intent1=new Intent(context, HomeActivity.class);
                        context.startActivity(intent1);
                        ((Activity) context).overridePendingTransition(0,0);
                        break;
                    case R.id.bbn_item2:
                        Intent intent2=new Intent(context, SearchActivity.class);
                        context.startActivity(intent2);
                        ((Activity) context).overridePendingTransition(0,0);
                        break;
                    case R.id.bbn_item3:
                        Intent intent3=new Intent(context, ProfileActivity.class);
                        context.startActivity(intent3);
                        ((Activity) context).overridePendingTransition(0,0);
                        break;
                    case R.id.bbn_item4:
                        Intent intent4=new Intent(context, LikesandGroupActivity.class);
                        context.startActivity(intent4);
                        ((Activity) context).overridePendingTransition(0,0);
                        break;



                }
                return false;
            }
        });
    }
}
