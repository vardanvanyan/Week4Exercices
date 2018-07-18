package com.example.vardan.week3exercices1;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.example.vardan.week3exercices1.Adapters.PagerAdapter;
import com.example.vardan.week3exercices1.Fragment.CallFragment;
import com.example.vardan.week3exercices1.Fragment.EmailFragment;
import com.example.vardan.week3exercices1.Fragment.UserFragment;

import java.util.Objects;

public class TabActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ViewPager viewPager = findViewById(R.id.view_pager);
        TabLayout tabLayout = findViewById(R.id.tab);


        final PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new UserFragment(), "User");
        adapter.addFragment(new CallFragment(), "Call");
        adapter.addFragment(new EmailFragment(), "Email");
        viewPager.setAdapter(adapter);

        tabLayout.setupWithViewPager(viewPager);

        Objects.requireNonNull(tabLayout.getTabAt(0)).setIcon(R.drawable.user_24dp);
        Objects.requireNonNull(tabLayout.getTabAt(1)).setIcon(R.drawable.call_24dp);
        Objects.requireNonNull(tabLayout.getTabAt(2)).setIcon(R.drawable.email_24dp);
    }

}