package edu.louisville.maxtasks;

import java.util.Date;

enum FrequencyType{
    MINUTE, HOUR, DAY
}

public class Notification {
    private String title;
    private Date notificationTime;
    private FrequencyType frequencyType;
    private int frequency;

    public Notification(String title, Date notificationTime, FrequencyType frequencyType, int frequency){
        this.title = title;
        this.notificationTime = notificationTime;
        this.frequencyType = frequencyType;
        this.frequency = frequency;
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
