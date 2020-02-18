package com.example.telegram;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.telegram.adapter.MessageAdapter;
import com.example.telegram.database.AppDatabase;
import com.example.telegram.database.TelegramMessage;
import com.example.telegram.database.TelegramChat;
import com.example.telegram.database.TelegramList;

import java.util.ArrayList;
import java.util.List;

public class Chat extends AppCompatActivity {
    AppDatabase db;
    MessageAdapter adapter;
    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;

    List<TelegramMessage>telegramListAllMessages;

    TextView textViewName , textViewSeen;
    ImageView imageViewProfile , imageViewMute;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        db = AppDatabase.getInMemoryDatabase(Chat.this);

        recyclerView = findViewById(R.id.recyclerViewChat);

        textViewName= findViewById(R.id.txt_name_me);
        textViewSeen= findViewById(R.id.txt_seen);
        imageViewMute= findViewById(R.id.image_mute_me);
        imageViewProfile= findViewById(R.id.image_profile_me);



        telegramListAllMessages = new ArrayList<>();



        Intent intent = getIntent();
        int id = intent.getIntExtra("contactId" , -1);

        TelegramChat telegramChatInfoo = db.dao().getTelegramChatnfoById(id);
        textViewSeen.setText(telegramChatInfoo.getLastSeen());

        TelegramList telegramList= db.dao().getTelegramListInfoById(id);
        if(telegramList!=null){

            textViewName.setText(telegramList.getName());

            if(telegramList.getImage_mute()){
                imageViewMute.setVisibility(View.VISIBLE);
                imageViewMute.setBackgroundResource(R.drawable.mute);
            }

            imageViewProfile.setImageDrawable(getResources().getDrawable(telegramList.getImage_profile()));

        }

        List<TelegramChat> telegramChatInfo = db.dao().getTelegramChatnfo();
        String stringMessages = telegramChatInfo.get(id-1).getMessages();
        List<String> messageList = DataConverterTwo.stringToList(stringMessages);
        telegramListAllMessages = DataConverter.stringToList(messageList.get(id-1));


        linearLayoutManager = new LinearLayoutManager(Chat.this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new MessageAdapter(Chat.this, telegramListAllMessages);
        recyclerView.setAdapter(adapter);
        recyclerView.scrollToPosition(telegramListAllMessages.size()-1);
    }
}
