package com.example.telegram.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.telegram.Chat;
import com.example.telegram.R;
import com.example.telegram.database.AppDatabase;
import com.example.telegram.database.TelegramList;

import java.util.ArrayList;
import java.util.List;

public class TelegramAdapter extends RecyclerView.Adapter <TelegramAdapter.MyViewHolder>{
    private Context context;
    private  List<TelegramList> telegramListInfo;
   // private List<TelegramList> telegramListInfo = new ArrayList<>();
    AppDatabase db;

    public TelegramAdapter(Context context , List<TelegramList> telegramListInfo) {
        Log.d("adapter", "TelegramAdapter  TelegramAdapter constructor");
        this.context = context;
        this.telegramListInfo = telegramListInfo;
        db = AppDatabase.getInMemoryDatabase(context);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d("adapter", "TelegramAdapter  onCreateViewHolder");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.items_main,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        List<TelegramList> telegramListInfo=db.dao().getTelegramListInfo();

        for (int i = 0; i < telegramListInfo.size(); i++) {
        }

        holder.textViewText.setText(telegramListInfo.get(holder.getAdapterPosition()).getText());
        holder.textViewTime.setText(telegramListInfo.get(holder.getAdapterPosition()).getTime());
        holder.textViewName.setText(telegramListInfo.get(holder.getAdapterPosition()).getName());

        holder.textViewAmPm.setText(telegramListInfo.get(holder.getAdapterPosition()).getAm_pm());
        if(telegramListInfo.get(holder.getAdapterPosition()).getMessage_number()>0){
            holder.textViewMessageNumber.setVisibility(View.VISIBLE);
            holder.textViewMessageNumber.setText(String.valueOf(telegramListInfo.get(holder.getAdapterPosition()).getMessage_number()));
        }

       if (telegramListInfo.get(holder.getAdapterPosition()).getSent()){
           holder.imageViewCheckMarkGray.setBackgroundResource(R.drawable.checkmark_gray);
           holder.imageViewCheckMarkGray.setVisibility(View.VISIBLE);
       }

        if (telegramListInfo.get(holder.getAdapterPosition()).getReceived()){
            holder.imageViewDoubleCheckMarkGray.setBackgroundResource(R.drawable.double_check_gray);
            holder.imageViewDoubleCheckMarkGray.setVisibility(View.VISIBLE);
        }

        if (telegramListInfo.get(holder.getAdapterPosition()).getSeen()){
            holder.imageViewDoubleCheckMarkGreen.setBackgroundResource(R.drawable.double_check_green);
            holder.imageViewDoubleCheckMarkGreen.setVisibility(View.VISIBLE);
        }

        if(telegramListInfo.get(holder.getAdapterPosition()).getImage_mute()){
            holder.imageViewMute.setVisibility(View.VISIBLE);
            holder.imageViewMute.setBackgroundResource(R.drawable.mute);
        }

       // holder.imageViewProfile.setBackgroundResource(telegramListInfo.get(holder.getAdapterPosition()).getImage_profile());
          holder.imageViewProfile.setImageDrawable(context.getResources().getDrawable(telegramListInfo.get(holder.getAdapterPosition()).getImage_profile()));
       // holder.imageViewProfile.setLayerType(View.LAYER_TYPE_SOFTWARE, null);


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("adapter", "TelegramAdapter  onClick");
                Log.d("adapter", "TelegramAdapter  onClick  holder.getAdapterPosition()"+holder.getAdapterPosition());
                Log.d("adapter", "TelegramAdapter  onClick  telegramListInfo.get(position).getIdList()"+telegramListInfo.get(position).getIdList());
                Log.d("adapter", "TelegramAdapter  onClick telegramListInfo.get(holder.getAdapterPosition()).getIdList() "+telegramListInfo.get(holder.getAdapterPosition()).getIdList());
                Log.d("adapter", "TelegramAdapter  onClick position  "+position);

                Intent intent = new Intent(context, Chat.class);
                intent.putExtra("contactId",telegramListInfo.get(position).getContactId());
                context.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        Log.d("adapter", "TelegramAdapter  getItemCount");
        return telegramListInfo.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView imageViewDoubleCheckMarkGreen , imageViewDoubleCheckMarkGray , imageViewCheckMarkGray,
        imageViewMute ,imageViewProfile;

        TextView  textViewName , textViewAmPm , textViewMessageNumber , textViewTime , textViewText;

        public MyViewHolder(@NonNull View itemView) {

            super(itemView);
            Log.d("adapter", "TelegramAdapter  MyViewHolder");
            imageViewDoubleCheckMarkGreen=itemView.findViewById(R.id.image_double_checkmark_green);
            imageViewDoubleCheckMarkGray=itemView.findViewById(R.id.image_double_checkmark_gray);
            imageViewCheckMarkGray=itemView.findViewById(R.id.image_checkmark_gray);
            imageViewMute=itemView.findViewById(R.id.image_mute);
            imageViewProfile=itemView.findViewById(R.id.image_profile);

            textViewName=itemView.findViewById(R.id.txt_name);
            textViewAmPm=itemView.findViewById(R.id.txt_AM_PM);
            textViewMessageNumber=itemView.findViewById(R.id.txt_message_number);
            textViewTime=itemView.findViewById(R.id.txt_time);
            textViewText= itemView.findViewById(R.id.txt_text);

        }
    }

}
