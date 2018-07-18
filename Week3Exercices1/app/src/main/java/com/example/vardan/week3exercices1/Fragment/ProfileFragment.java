package com.example.vardan.week3exercices1.Fragment;


import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.vardan.week3exercices1.Adapters.MessageAdapter;
import com.example.vardan.week3exercices1.Models.UserModel;
import com.example.vardan.week3exercices1.MyProvider;
import com.example.vardan.week3exercices1.R;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends android.support.v4.app.Fragment {


    public ProfileFragment() {
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        assert getArguments() != null;
        final int userPosition = getArguments().getInt(MessageAdapter.FR2_KEY);
        final UserModel user = MyProvider.getUserByPosition(userPosition);
        TextView textView = view.findViewById(R.id.profile_name);
        textView.setText(user.getName());
        TextView textView1 = view.findViewById(R.id.profile_age);
        textView1.setText(user.getAge());
        TextView textView2 = view.findViewById(R.id.profile_trophy);
        textView2.setText(user.getTrophy());
        CircleImageView imageView = view.findViewById(R.id.profile_image);
        Picasso.get()
                .load(user.getImage())
                .placeholder(R.drawable.ic_airline_24dp)
                .error(R.mipmap.ic_launcher)
                .into(imageView);
        return view;
    }

}
