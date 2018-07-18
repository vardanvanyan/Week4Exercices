package com.example.vardan.week3exercices1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.vardan.week3exercices1.Adapters.UsersAdapter;
import com.example.vardan.week3exercices1.Fragment.ChatFragment;


public class ChatActivity extends AppCompatActivity {

    public static final String FRAGMENT_KEY = "fr_key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        final int position = getIntent().getIntExtra(UsersAdapter.KEY, 0);
        ChatFragment chatFragment = new ChatFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(FRAGMENT_KEY, position);
        chatFragment.setArguments(bundle);
        getSupportFragmentManager().beginTransaction().replace(R.id.chat_container, chatFragment).commit();
    }
}
