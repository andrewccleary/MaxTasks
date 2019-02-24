package edu.louisville.maxtasks.Model;

import java.util.Date;

public class Activity extends Task {
    private Date startDate;
    private Date endDate;
    private String activityType;

    public Activity(String taskName, int priority, String notes, Date startDate, Date endDate, String activityType){
        super(taskName, priority, notes);
        this.startDate = startDate;
        this.endDate = endDate;
        this.activityType = activityType;
    }

    public Date getStartDate(){
        return this.startDate;
    }

    public void setStartDate(Date d){
        this.startDate = d;
    }

    public Date getEndDate(){
        return this.endDate;
    }

    public void setEndDate(Date d){
        this.endDate = d;
    }

    public String getActivityType(){
        return this.activityType;
    }

    public void setActivityType(String s){
        this.activityType = s;
    }
}

