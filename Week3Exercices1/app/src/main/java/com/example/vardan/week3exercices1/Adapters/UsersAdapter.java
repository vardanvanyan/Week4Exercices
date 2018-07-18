package com.example.vardan.week3exercices1.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.vardan.week3exercices1.ChatActivity;
import com.example.vardan.week3exercices1.Models.UserModel;
import com.example.vardan.week3exercices1.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.UserViewHolder> {

   public static final String KEY = "key" ;
    private Context context;
    private List<UserModel> userList;

    public UsersAdapter(Context context, List<UserModel> userList) {
        this.context = context;
        this.userList = userList;
    }

    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater =
                (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        assert inflater != null;
        final View view = inflater.inflate(R.layout.user_item, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(UserViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        final UserModel user = userList.get(position);
        holder.userName.setText(user.getName());
        Picasso.get()
                .load(user.getImage())
                .placeholder(R.drawable.ic_airline_24dp)
                .error(R.mipmap.ic_launcher)
                .into(holder.circleUserImage);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ChatActivity.class);
                intent.putExtra(KEY,position);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    class UserViewHolder extends RecyclerView.ViewHolder {

        TextView userName;
        CircleImageView circleUserImage;

        UserViewHolder(View itemView) {
            super(itemView);
            userName = itemView.findViewById(R.id.user_text);
            circleUserImage = itemView.findViewById(R.id.circle_user_image);
        }
    }
}
