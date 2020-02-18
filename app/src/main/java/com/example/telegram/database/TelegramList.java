package com.example.telegram.database;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(indices = {@Index("idList")})
public class TelegramList {



    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "idList")
    private  Integer idList;

    @ColumnInfo(name = "contactId")
    private  Integer contactId;

    @ColumnInfo(name = "image_profile")
    private int image_profile;

    @ColumnInfo(name = "sent")
    private Boolean sent;

    @ColumnInfo(name = "received")
    private Boolean received;

    @ColumnInfo(name = "seen")
    private Boolean seen;

    @ColumnInfo(name = "image_mute")
    private Boolean image_mute;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "text")
    private String text;

    @ColumnInfo(name = "time")
    private String time;

    @ColumnInfo(name = "am_pm")
    private String am_pm;

    @ColumnInfo(name = "message_number")
    private int message_number;

    public Integer getContactId() {
        return contactId;
    }

    public void setContactId(Integer contactId) {
        this.contactId = contactId;
    }

    public Integer getIdList() {
        return idList;
    }

    public void setIdList(Integer idList) {
        this.idList = idList;
    }


    public int getImage_profile() {
        return image_profile;
    }

    public void setImage_profile(int image_profile) {
        this.image_profile = image_profile;
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

    public Boolean getImage_mute() {
        return image_mute;
    }

    public void setImage_mute(Boolean image_mute) {
        this.image_mute = image_mute;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getAm_pm() {
        return am_pm;
    }

    public void setAm_pm(String am_pm) {
        this.am_pm = am_pm;
    }

    public int getMessage_number() {
        return message_number;
    }

    public void setMessage_number(int message_number) {
        this.message_number = message_number;
    }
}
