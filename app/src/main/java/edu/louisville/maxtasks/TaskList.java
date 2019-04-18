package edu.louisville.maxtasks;

import java.util.ArrayList;
import java.util.List;

import edu.louisville.maxtasks.Model.Task;

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

    public void setTask(List<Task> tasks)
    {
        this.tasks = tasks;
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