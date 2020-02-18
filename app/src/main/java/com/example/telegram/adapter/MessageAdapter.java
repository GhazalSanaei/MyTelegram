package com.example.telegram.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.telegram.R;
import com.example.telegram.database.AppDatabase;
import com.example.telegram.database.TelegramMessage;

import java.util.List;

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.MyViewHolder> {

    Context context;
    List<TelegramMessage> telegramMessageList;
    AppDatabase db;

    public MessageAdapter(Context context, List<TelegramMessage> telegramMessageList) {
        this.context = context;
        this.telegramMessageList = telegramMessageList;
        db = AppDatabase.getInMemoryDatabase(context);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.items_chat, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Log.d("aaaa", " -------------------- chatAdapter   position "+position);
        if (telegramMessageList.get(position) != null) {

            if (telegramMessageList.get(position).getPosition().equals("right")) {
                //me

            /*Resources res = context.getResources(); //resource handle
            Drawable drawable = res.getDrawable(R.drawable.background_chat_me); //new Image that was added to the res folder

            holder.relativeLayout.setBackground(drawable);*/

                // holder.relativeLayout.setBackground(context.getResources().getDrawable(R.drawable.background_chat_me));

                holder.linearLayout.setBackgroundColor(Color.parseColor("#e6ffe6"));


                RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                params.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
                holder.relativeLayout.setLayoutParams(params);

                if (telegramMessageList.get(holder.getAdapterPosition()).getSent()) {
                    holder.imageViewCheckMarkGrayMe.setBackgroundResource(R.drawable.checkmark_gray);
                    holder.imageViewCheckMarkGrayMe.setVisibility(View.VISIBLE);
                }

                if (telegramMessageList.get(holder.getAdapterPosition()).getReceived()) {
                    holder.imageViewDoubleCheckMarkGrayMe.setBackgroundResource(R.drawable.double_check_gray);
                    holder.imageViewDoubleCheckMarkGrayMe.setVisibility(View.VISIBLE);
                }

                if (telegramMessageList.get(holder.getAdapterPosition()).getSeen()) {
                    holder.imageViewDoubleCheckMarkGreenMe.setBackgroundResource(R.drawable.double_check_green);
                    holder.imageViewDoubleCheckMarkGreenMe.setVisibility(View.VISIBLE);
                }


            } else {
            /*Resources res = context.getResources(); //resource handle
            Drawable drawable = res.getDrawable(R.drawable.background_chat_you); //new Image that was added to the res folder

            holder.relativeLayout.setBackground(drawable);*/

                // holder.relativeLayout.setBackground(context.getResources().getDrawable(R.drawable.background_chat_you));

                holder.linearLayout.setBackgroundColor(Color.parseColor("#FFFFFF"));

                RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                params.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
                holder.relativeLayout.setLayoutParams(params);

            }


            holder.textViewAmPm.setText(telegramMessageList.get(position).getAmPm());
            holder.textViewTime.setText(telegramMessageList.get(position).getTime());
            holder.textViewText.setText(telegramMessageList.get(position).getText());


        }else{

            holder.relativeLayout.setVisibility(View.GONE);
        }

    }

    @Override
    public int getItemCount() {
        return telegramMessageList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView imageViewDoubleCheckMarkGreenMe, imageViewDoubleCheckMarkGrayMe, imageViewCheckMarkGrayMe;

        TextView textViewAmPm, textViewTime, textViewText;

        LinearLayout linearLayout;
        RelativeLayout relativeLayout, relativeLayoutParent;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageViewCheckMarkGrayMe = itemView.findViewById(R.id.image_checkmark_gray_chat);
            imageViewDoubleCheckMarkGrayMe = itemView.findViewById(R.id.image_double_checkmark_gray_chat);
            imageViewDoubleCheckMarkGreenMe = itemView.findViewById(R.id.image_double_checkmark_green_chat);

            linearLayout = itemView.findViewById(R.id.linearLayoutChat);
            relativeLayout = itemView.findViewById(R.id.relativeLayoutChat);
            relativeLayoutParent = itemView.findViewById(R.id.relativeLayoutChatParent);

            textViewText = itemView.findViewById(R.id.txtTextChat);
            textViewTime = itemView.findViewById(R.id.txtTimeChat);
            textViewAmPm = itemView.findViewById(R.id.txtAmPmChat);


        }
    }
}
