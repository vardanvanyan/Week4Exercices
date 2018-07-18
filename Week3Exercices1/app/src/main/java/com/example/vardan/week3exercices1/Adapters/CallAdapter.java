package com.example.vardan.week3exercices1.Adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.vardan.week3exercices1.Models.UserModel;
import com.example.vardan.week3exercices1.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class CallAdapter extends RecyclerView.Adapter<CallAdapter.CallViewHolder> {


    private Context context;
    private List<UserModel> userList;

    public CallAdapter(Context context, List<UserModel> userList) {
        this.context = context;
        this.userList = userList;
    }

    @Override
    public CallViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater =
                (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        assert inflater != null;
        final View view = inflater.inflate(R.layout.call_item, parent, false);
        return new CallViewHolder(view);

    }

    @Override
    public void onBindViewHolder(CallViewHolder holder, final int position) {
        final UserModel user = userList.get(position);
        holder.userName.setText(user.getName());
        holder.phone.setText(user.getPhone());
        Picasso.get()
                .load(user.getImage())
                .placeholder(R.drawable.ic_airline_24dp)
                .error(R.mipmap.ic_launcher)
                .into(holder.circleUserImage);
        holder.imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + user.getPhone()));
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    class CallViewHolder extends RecyclerView.ViewHolder {
        TextView userName;
        CircleImageView circleUserImage;
        TextView phone;
        ImageButton imageButton;

        CallViewHolder(View itemView) {
            super(itemView);
            userName = itemView.findViewById(R.id.call_text);
            circleUserImage = itemView.findViewById(R.id.circle_call_image);
            imageButton = itemView.findViewById(R.id.call_image_button);
            phone = itemView.findViewById(R.id.call_phone);
        }
    }
}
