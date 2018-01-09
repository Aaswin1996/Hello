package com.example.aaswin.sakha;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.aaswin.sakha.Utils.bottomNavigationHelper;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

/**
 * Created by aaswin on 7/1/18.
 */

public class LikesandGroupActivity extends AppCompatActivity {
    private Integer Activity_num=3;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_likesandgroup);
        setupBottomNavigationView();
    }
    private void setupBottomNavigationView(){
        Toast.makeText(this,"setupBottomNavigationView starts",Toast.LENGTH_SHORT).show();
        BottomNavigationViewEx bottom=(BottomNavigationViewEx)findViewById(R.id.bottom_nav_view);
        bottomNavigationHelper bottomNavigationHelper=new bottomNavigationHelper();
        bottomNavigationHelper.utilfunctions(bottom);
        bottomNavigationHelper.enableNavigation(LikesandGroupActivity.this,bottom);
        Menu menu=bottom.getMenu();
        MenuItem menuitem=menu.getItem(Activity_num);
        menuitem.setChecked(true);
    }
}

