package com.example.vardan.week3exercices1.kingPager;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.vardan.week3exercices1.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewPager viewPager = findViewById(R.id.viewPager);
        final PokerPagerAdapter kingPagerAdapter = new PokerPagerAdapter(this, getList());
        viewPager.setAdapter(kingPagerAdapter);
        TabLayout tabLayout = findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager, true);
    }

    private List<Poker> getList() {
        final List<Poker> list = new ArrayList<>();
        list.add(new Poker("Poker is life", R.drawable.first));
        list.add(new Poker("Join us", R.drawable.second));
        list.add(new Poker("Play now", R.drawable.third));
        return list;
    }
}
