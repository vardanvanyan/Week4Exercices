package com.example.vardan.week3exercices1.Fragment;


import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.vardan.week3exercices1.Adapters.CallAdapter;
import com.example.vardan.week3exercices1.MyProvider;
import com.example.vardan.week3exercices1.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class CallFragment extends android.support.v4.app.Fragment {


    public CallFragment() {
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_call, container, false);
        final RecyclerView usersList = view.findViewById(R.id.call_item);
        usersList.setHasFixedSize(true);
        usersList.setLayoutManager(
                new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        final CallAdapter adapter =
                new CallAdapter(getContext(), MyProvider.getUsersList());
        usersList.setAdapter(adapter);
        return view;
    }
}
