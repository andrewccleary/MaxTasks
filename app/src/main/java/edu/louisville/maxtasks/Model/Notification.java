package edu.louisville.maxtasks.Model;

import java.util.Date;

enum FrequencyType{
    MINUTE, HOUR, DAY
}

public class Notification {
    private String title;
    private Date notificationTime;
    private FrequencyType frequencyType;
    private int frequency;

    public Notification(Date notificationTime){

        this.notificationTime = notificationTime;

    }

    public String getTitle(){
        return this.title;
    }

    public void setTitle(String s){
        this.title = s;
    }

    public Date getNotificationTime() {
        return this.notificationTime;
    }

    public void setNotificationTime(Date d){
        this.notificationTime = d;
    }

    public FrequencyType getFrequencyType(){
        return this.frequencyType;
    }

    public void setFrequencyType(FrequencyType ft){
        this.frequencyType = ft;
    }

    public int getFrequency(){
        return this.frequency;
    }

    public void setFrequency(int f){
        this.frequency = f;
    }
}
