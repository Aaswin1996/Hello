package com.example.aaswin.sakha.Profile;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.aaswin.sakha.LoginActivity;
import com.example.aaswin.sakha.R;
import com.example.aaswin.sakha.Utils.bottomNavigationHelper;
import com.facebook.login.LoginManager;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;


public class ProfileActivity extends AppCompatActivity {
    private Integer Activity_num=2;
    FirebaseAuth mAuth=FirebaseAuth.getInstance();
    FirebaseUser currentuser=mAuth.getCurrentUser();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        setupBottomNavigationView();


    }
    private void setupBottomNavigationView(){
        Toast.makeText(this,"setupBottomNavigationView starts",Toast.LENGTH_SHORT).show();
        BottomNavigationViewEx bottom=(BottomNavigationViewEx)findViewById(R.id.bottom_nav_view);
        bottomNavigationHelper bottomNavigationHelper=new bottomNavigationHelper();
        bottomNavigationHelper.utilfunctions(bottom);
        bottomNavigationHelper.enableNavigation(ProfileActivity.this,bottom);
        Menu menu=bottom.getMenu();
        MenuItem menuitem=menu.getItem(Activity_num);
        menuitem.setChecked(true);
    }

    @Override
    protected void onStart() {
        super.onStart();
        if(currentuser==null)
        {
            updateUI();
        }
    }

    private void updateUI() {
        startActivity(new Intent(ProfileActivity.this,LoginActivity.class));
        finish();
    }


    public void SettingsNav(View view) {
        startActivity(new Intent(ProfileActivity.this,AccountSettingsActivity.class));
        overridePendingTransition(0,0);

    }
}
