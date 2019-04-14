package edu.louisville.maxtasks;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.zip.Inflater;

import edu.louisville.maxtasks.Model.Task;
import edu.louisville.maxtasks.TaskList;

public class ListViewAdapter extends BaseAdapter {
    Context context;
    TaskList tasks;
    LayoutInflater inflater;

    public ListViewAdapter(Context appContext, TaskList tasks)
    {
        this.context = appContext;
        this.tasks = tasks;
        inflater = (LayoutInflater.from(appContext));
    }

    @Override
    public Object getItem(int i)
    {
        return tasks.Tasks().get(i);
    }

    @Override
    public int getCount()
    {
        return tasks.Tasks().size();
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup)
    {
        view = inflater.inflate(R.layout.activity_listview, null);
        TextView taskView = (TextView)view.findViewById(R.id.textView);
        Task task = tasks.Tasks().get(i);
        taskView.setText(task.getTaskName());
        return view;

    }
}
