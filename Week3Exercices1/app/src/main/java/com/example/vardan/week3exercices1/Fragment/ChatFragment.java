package com.example.vardan.week3exercices1.Fragment;


import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.vardan.week3exercices1.Adapters.MessageAdapter;
import com.example.vardan.week3exercices1.ChatActivity;
import com.example.vardan.week3exercices1.Models.MessageModel;
import com.example.vardan.week3exercices1.Models.UserModel;
import com.example.vardan.week3exercices1.MyProvider;
import com.example.vardan.week3exercices1.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ChatFragment extends android.support.v4.app.Fragment {


    public ChatFragment() {
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_chat, container, false);
        if (getArguments() != null) {
            final int userPosition = getArguments().getInt(ChatActivity.FRAGMENT_KEY);
            final UserModel user = MyProvider.getUserByPosition(userPosition);
            TextView userName = view.findViewById(R.id.chat_user_name);
            userName.setText(user.getName());
            CircleImageView circleImageView = view.findViewById(R.id.user_chat_image);
            Picasso.get()
                    .load(user.getImage())
                    .placeholder(R.drawable.ic_airline_24dp)
                    .error(R.mipmap.ic_launcher)
                    .into(circleImageView);
            initializeMessagesList(view, user);

        }
        return view;
    }

    private void initializeMessagesList(View view, UserModel user) {
        final RecyclerView messagesList = view.findViewById(R.id.chat_item);
        messagesList.setHasFixedSize(true);
        final LinearLayoutManager manager =
                new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        messagesList.setLayoutManager(manager);
        final List<MessageModel> messages = user.getMessage();
        final MessageAdapter adapter = new MessageAdapter(getContext(), messages, user.getImage());
        messagesList.setAdapter(adapter);

        final EditText editText = view.findViewById(R.id.enter_message);
        final ImageButton send = view.findViewById(R.id.send);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                messages.add(new MessageModel(editText.getText().toString(), true));
                messages.add(new MessageModel("Royal Flush", false));
                editText.setText("");
                adapter.notifyDataSetChanged();
                messagesList.scrollToPosition(messages.size() - 1);
            }
        });
    }
}
