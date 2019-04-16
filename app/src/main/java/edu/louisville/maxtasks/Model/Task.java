package edu.louisville.maxtasks.Model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Task implements Serializable {
    private String taskName;
    private int priority;
    private String category;
    private List<Notification> notifications;
    private boolean completed;
    private String notes;

    public Task(String taskName, int priority, String category, String notes){
        this.taskName = taskName;
        this.priority = priority;
        this.category = category;
        this.notes = notes;
        this.completed = false;

    }

    public String getTaskName(){
        return this.taskName;
    }

    public void setTaskName(String s){
        this.taskName = s;
    }

    public int getPriority(){
        return this.priority;
    }

    public void setPriority(int p){
        this.priority = p;
    }

    public boolean isCompleted() {
        return this.completed;
    }

    public void setCompleted(boolean b){
        this.completed = b;
    }

    public String getCategory(){
        return this.category;
    }

    public void setCategory(String s){
        this.category = s;
    }

    public String getNotes(){
        return this.notes;
    }

    public void setNotes(String s){
        this.notes = s;
    }


    public List<Notification> getNotifications(){
        return this.notifications;
    }

    public void addNotification(Notification n){
        this.notifications.add(n);
    }

    public Notification getNotification(int i){
        return this.notifications.get(i);
    }

    public void deleteNotification(Notification n){
        this.notifications.remove(n);
    }
}
