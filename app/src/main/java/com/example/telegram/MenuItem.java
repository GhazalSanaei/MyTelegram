package com.example.telegram;

public class MenuItem {


    private String name;
    private Integer icon;
    private Boolean switchCompat;

    public MenuItem( String name , Integer icon , Boolean switchCompat )
    {
        this.name = name;
        this.icon = icon;
        this.switchCompat = switchCompat;
    }



    public String getName()
    {
        return name;
    }

    public void setName( String name )
    {
        this.name = name;
    }

    public Integer getIcon()
    {
        return icon;
    }

    public void setIcon( Integer icon )
    {
        this.icon = icon;
    }


    public Boolean getSwitchCompat()
    {
        return switchCompat;
    }

    public void setSwitchCompat( Boolean switchCompat )
    {
        this.switchCompat = switchCompat;
    }
}
