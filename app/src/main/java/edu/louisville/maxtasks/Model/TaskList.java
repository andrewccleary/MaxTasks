package edu.louisville.maxtasks.Model;

import java.util.ArrayList;
import java.util.List;

public class TaskList {
    private List<Task> tasks;

    public TaskList()
    {
        tasks = new ArrayList<>();
    }

    public List<Task> Tasks()
    {
        return this.tasks;
    }

    public void Add(Task task)
    {
        tasks.add(task);
    }

    public void Add(String taskName, int priority, String category, String notes)
    {
        Task task = new Task(taskName, priority, category, notes);
        this.Add(task);
    }

    public Task GetTask(int index)
    {
        return tasks.get(index);
    }

    public void Update(Task task){

        for(int x = 0; x < tasks.size(); x++){
            if (tasks.get(x).getTaskName() == task.getTaskName()){
                tasks.set(x, task);
            }
        }
    }

}
