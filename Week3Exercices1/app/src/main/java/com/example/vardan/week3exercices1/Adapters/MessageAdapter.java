package com.example.vardan.week3exercices1.Adapters;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.vardan.week3exercices1.ChatActivity;
import com.example.vardan.week3exercices1.Fragment.ProfileFragment;
import com.example.vardan.week3exercices1.Models.MessageModel;
import com.example.vardan.week3exercices1.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class MessageAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public static final String FR2_KEY = "fr2_key";
    private final Context context;
    private final List<MessageModel> message;
    private final String userImage;

    public MessageAdapter(Context context, List<MessageModel> message, String userImage) {
        this.context = context;
        this.message = message;
        this.userImage = userImage;
    }

    @Override
    public int getItemViewType(int position) {
        final MessageModel messageModel = message.get(position);
        if (messageModel.isMine()) {
            return 0;
        }
        return 1;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final LayoutInflater inflater =
                (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view;
        if (0 == viewType) {
            assert inflater != null;
            view = inflater.inflate(R.layout.send_message, parent, false);
            return new SendViewHolder(view);
        }
        assert inflater != null;
        view = inflater.inflate(R.layout.receive_message, parent, false);
        return new ReceiveViewHolder(view);
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final MessageModel model = message.get(position);
        if (model.isMine()) {
            ((SendViewHolder) holder).bind(model);
        } else {
            ((ReceiveViewHolder) holder).bind(model);
        }
    }

    @Override
    public int getItemCount() {
        return message.size();
    }

    class SendViewHolder extends RecyclerView.ViewHolder {

        TextView sendText;

        SendViewHolder(View itemView) {
            super(itemView);
            sendText = itemView.findViewById(R.id.send_text);
        }

        void bind(MessageModel message) {
            sendText.setText(message.getText());
        }
    }

    class ReceiveViewHolder extends RecyclerView.ViewHolder {

        TextView receiveText;
        CircleImageView receiveUserImage;

        ReceiveViewHolder(View itemView) {
            super(itemView);
            receiveText = itemView.findViewById(R.id.receive_text);
            receiveUserImage = itemView.findViewById(R.id.receive_image);
        }

        void bind(MessageModel message) {
            receiveText.setText(message.getText());
            Picasso.get()
                    .load(userImage)
                    .placeholder(R.drawable.ic_airline_24dp)
                    .error(R.mipmap.ic_launcher)
                    .into(receiveUserImage);
            final int position = ((ChatActivity) context).getIntent().getIntExtra(UsersAdapter.KEY, 0);
            receiveUserImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ProfileFragment profileFragment = new ProfileFragment();
                    Bundle bundle = new Bundle();
                    bundle.putInt(FR2_KEY, position);
                    profileFragment.setArguments(bundle);
                    ((ChatActivity) context)
                            .getSupportFragmentManager()
                            .beginTransaction().replace(R.id.chat_container, profileFragment).commit();
                }
            });
        }
    }
}