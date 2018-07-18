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

public class EmailAdapter extends RecyclerView.Adapter<EmailAdapter.EmailViewHolder> {

    private Context context;
    private List<UserModel> userList;

    public EmailAdapter(Context context, List<UserModel> userList) {
        this.context = context;
        this.userList = userList;
    }

    @Override
    public EmailViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater =
                (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        assert inflater != null;
        final View view = inflater.inflate(R.layout.email_item, parent, false);
        return new EmailAdapter.EmailViewHolder(view);
    }

    @Override
    public void onBindViewHolder(EmailViewHolder holder, int position) {
        final UserModel user = userList.get(position);
        holder.userName.setText(user.getName());
        holder.email.setText(user.getEmail());
        Picasso.get()
                .load(user.getImage())
                .placeholder(R.drawable.ic_airline_24dp)
                .error(R.mipmap.ic_launcher)
                .into(holder.circleUserImage);
        holder.imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:" + user.getEmail()));
                context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    class EmailViewHolder extends RecyclerView.ViewHolder {
        TextView userName;
        CircleImageView circleUserImage;
        TextView email;
        ImageButton imageButton;

        EmailViewHolder(View itemView) {
            super(itemView);
            userName = itemView.findViewById(R.id.email_text);
            circleUserImage = itemView.findViewById(R.id.circle_email_image);
            imageButton = itemView.findViewById(R.id.email_image_button);
            email = itemView.findViewById(R.id.email_sms);
        }
    }
}
