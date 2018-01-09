package com.example.aaswin.sakha;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.aaswin.sakha.Utils.SectionPagerAdapter;
import com.example.aaswin.sakha.differentSignUpOptions.emailRegisterFragment;
import com.example.aaswin.sakha.differentSignUpOptions.phoneRegisterFragment;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        SectionPagerAdapter mPagerAdapter=new SectionPagerAdapter(getSupportFragmentManager());
        ViewPager viewPager=(ViewPager)findViewById(R.id.Container);
        setupViewPager(viewPager);



        TabLayout tabLayout=(TabLayout)findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setText("Email");
        tabLayout.getTabAt(1).setText("Phone No");



    }
    public void setupViewPager(ViewPager viewPager)
    {
        SectionPagerAdapter adapter=new SectionPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new emailRegisterFragment());
        adapter.addFragment(new phoneRegisterFragment());
        viewPager.setAdapter(adapter);

    }

}
