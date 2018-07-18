package com.example.vardan.week3exercices1.kingPager;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.vardan.week3exercices1.R;
import com.example.vardan.week3exercices1.TabActivity;

import java.util.List;

public class PokerPagerAdapter extends PagerAdapter {

    private Context context;
    private List<Poker> kings;

    PokerPagerAdapter(Context context, List<Poker> kings) {
        this.context = context;
        this.kings = kings;
    }

    @Override
    public int getCount() {
        return kings.size();
    }


    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        final LayoutInflater inflater =
                (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        assert inflater != null;
        final View view = inflater.inflate(R.layout.poker_item, container, false);
        final ImageView imageView = view.findViewById(R.id.poker_image);
        final TextView textView = view.findViewById(R.id.poker_text);
        final Button button = view.findViewById(R.id.skipButtonId);
        final Poker king = kings.get(position);
        imageView.setImageResource(king.getImageId());
        textView.setText(king.getName());
        container.addView(view);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, TabActivity.class);
                context.startActivity(intent);
            }
        });
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }
}
