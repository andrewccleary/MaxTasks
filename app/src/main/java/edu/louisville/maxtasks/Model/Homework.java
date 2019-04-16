package edu.louisville.maxtasks.Model;

import java.util.Date;

import edu.louisville.maxtasks.Model.Task;

public class Homework extends Task {
    private Date dueDate;
    private Date startDate;
    private int expectedDuration;
    private String className;
    private float grade;


    public Homework(String taskName, int priority, String notes, Date notification, Date dueDate, Date startDate, int expectedDuration, String className){
        super(taskName, priority, "Homework",notes);
        this.dueDate = dueDate;
        this.startDate = startDate;
        this.expectedDuration = expectedDuration;
        this.className = className;
    }

    public Date getDueDate(){
        return this.dueDate;
    }

    public void setDueDate(Date d){
        this.dueDate = d;
    }

    public Date getStartDate(){
        return this.startDate;
    }

    public void setStartDate(Date d){
        this.startDate = d;
    }

    public int getExpectedDuration(){
        return this.expectedDuration;
    }

    public void setExpectedDuration(int ed){
        this.expectedDuration = ed;
    }

    public String getClassName(){
        return this.className;
    }

    public void setClassName(String cn){
        this.className = cn;
    }

    public float getGrade(){
        return this.grade;
    }

    public void setGrade(float g){
        this.grade = g;
    }
}