package com.geocode.reversegeolocator.model;

public class ReturnObject
{
    int status;

    String message;

    public ReturnObject()
    {
    }

    public ReturnObject(int status, String message)
    {
        this.status = status;
        this.message = message;
    }


    public int getStatus()
    {
        return status;
    }

    public void setStatus(int status)
    {
        this.status = status;
    }

    public String getMessage()
    {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }
}
