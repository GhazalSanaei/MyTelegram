package com.example.telegram.database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
@Entity

        (foreignKeys = @ForeignKey(entity = TelegramList.class,
                parentColumns = "idList",
                childColumns = "idContact",
                onDelete = ForeignKey.CASCADE))


public class TelegramMessage {



    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "idMessage")
    private  Integer idMessage;


    @ColumnInfo(name = "idContact")
    private  Integer idContact;

    @ColumnInfo(name = "text")
    private String text;

    @ColumnInfo(name = "position")
    private String position;

    @ColumnInfo(name = "AmPm")
    private String AmPm;

    @ColumnInfo(name = "time")
    private String time;

    @ColumnInfo(name = "isMyText")
    private Boolean isMyText;

    @ColumnInfo(name = "sent")
    private Boolean sent;

    @ColumnInfo(name = "received")
    private Boolean received;

    @ColumnInfo(name = "seen")
    private Boolean seen;

    public Boolean getMyText() {
        return isMyText;
    }

    public void setMyText(Boolean myText) {
        isMyText = myText;
    }

    public Boolean getSent() {
        return sent;
    }

    public void setSent(Boolean sent) {
        this.sent = sent;
    }

    public Boolean getReceived() {
        return received;
    }

    public void setReceived(Boolean received) {
        this.received = received;
    }

    public Boolean getSeen() {
        return seen;
    }

    public void setSeen(Boolean seen) {
        this.seen = seen;
    }

    public Integer getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(Integer idMessage) {
        this.idMessage = idMessage;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getAmPm() {
        return AmPm;
    }

    public void setAmPm(String amPm) {
        AmPm = amPm;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }


    public Integer getIdContact() {
        return idContact;
    }

    public void setIdContact(Integer idContact) {
        this.idContact = idContact;
    }
}
