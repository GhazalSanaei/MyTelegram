package com.example.telegram.database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import java.util.List;

import static androidx.room.ForeignKey.CASCADE;


@Entity

public class TelegramChat {


    @PrimaryKey(autoGenerate = true)
    private  Integer idChat;

    @ColumnInfo(name = "idContact")
    private  Integer idContact;

    @ColumnInfo(name = "lastSeen")
    private  String lastSeen;

    @ColumnInfo(name = "messages")
    private String messages;

    public Integer getIdChat() {
        return idChat;
    }

    public void setIdChat(Integer idChat) {
        this.idChat = idChat;
    }

    public Integer getIdContact() {
        return idContact;
    }

    public void setIdContact(Integer idContact) {
        this.idContact = idContact;
    }

    public String getLastSeen() {
        return lastSeen;
    }

    public void setLastSeen(String lastSeen) {
        this.lastSeen = lastSeen;
    }

    public String getMessages() {
        return messages;
    }

    public void setMessages(String messages) {
        this.messages = messages;
    }
}
