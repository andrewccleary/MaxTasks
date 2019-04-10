package edu.louisville.maxtasks.Model;

import java.util.Date;

public class Exam extends Task {
    private Date startTime;
    private Date endTime;
    private String className;
    private float grade;

    public Exam(String taskName, int priority, String notes, Date startTime, Date endTime, String className){
        super(taskName, priority,"Exam", notes);
        this.startTime = startTime;
        this.endTime = endTime;
        this.className = className;
    }

    public Date getStartTime(){
        return this.startTime;
    }

    public void setStartTime(Date d){
        this.startTime = d;
    }

    public Date getEndTime(){
        return this.endTime;
    }

    public void setEndTime(Date d){
        this.endTime = d;
    }

    public String getClassName(){
        return this.className;
    }

    public void setClassName(String s){
        this.className = s;
    }

    public float getGrade(){
        return this.grade;
    }

    public void setGrade(float g){
        this.grade = g;
    }
}
