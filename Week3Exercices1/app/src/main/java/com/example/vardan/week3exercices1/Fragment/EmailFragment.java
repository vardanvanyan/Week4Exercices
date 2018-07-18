package com.example.vardan.week3exercices1.Fragment;


import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.vardan.week3exercices1.Adapters.EmailAdapter;
import com.example.vardan.week3exercices1.MyProvider;
import com.example.vardan.week3exercices1.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class EmailFragment extends android.support.v4.app.Fragment {


    public EmailFragment() {
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_email, container, false);
        final RecyclerView usersList = view.findViewById(R.id.email_item);
        usersList.setHasFixedSize(true);
        usersList.setLayoutManager(
                new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        final EmailAdapter adapter =
                new EmailAdapter(getContext(), MyProvider.getUsersList());
        usersList.setAdapter(adapter);
        return view;
    }

}
