package com.example.aaswin.sakha.Profile;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.aaswin.sakha.LoginActivity;
import com.example.aaswin.sakha.R;
import com.facebook.login.LoginManager;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class AccountSettingsActivity extends AppCompatActivity {
    FirebaseAuth mAuth=FirebaseAuth.getInstance();
    FirebaseUser currentuser=mAuth.getCurrentUser();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_settings);
    }

    public void backNav(View view) {
        startActivity(new Intent(AccountSettingsActivity.this,ProfileActivity.class));
        overridePendingTransition(0,0);
        finish();
    }

    public void Signout(View view) {
                mAuth.signOut();
                LoginManager.getInstance().logOut();
                updateUI();

            }

    private void updateUI() {
        startActivity(new Intent(AccountSettingsActivity.this,LoginActivity.class));
        finish();
    }

    }
