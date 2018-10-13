package com.example.tornado.listviewcustomz.model;

/**
 * Created by tornado on 10/13/2018.
 */

public class Contact {

    private String name = "";
    private String image = "";
    private String message = "";
    private String date = "";
    private boolean isSeen = false;

    public Contact (String name, String image, String message, String date, boolean isSeen)
    {
        this.name = name;
        this.image = image;
        this.message = message;
        this.date = date;
        this.isSeen = isSeen;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public String getImage ()
    {
        return image;
    }

    public void setImage (String image)
    {
        this.image = image;
    }

    public String getMessage ()
    {
        return message;
    }

    public void setMessage (String message)
    {
        this.message = message;
    }

    public String getDate ()
    {
        return date;
    }

    public void setDate (String date)
    {
        this.date = date;
    }

    public boolean isSeen ()
    {
        return isSeen;
    }

    public void setSeen (boolean seen)
    {
        isSeen = seen;
    }
}


