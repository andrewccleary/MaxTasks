package edu.louisville.maxtasks;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.support.v4.app.NotificationCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

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
        final ViewHolder holder;

        if(view == null) {
            holder = new ViewHolder();

            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.activity_listview, null,true);
            holder.imageButton = (ImageButton) view.findViewById(R.id.editButton);
            holder.checkBox = (CheckBox)view.findViewById(R.id.checkbox);
            holder.textView = (TextView)view.findViewById(R.id.description);
            view.setTag(holder);
        }
        else
        {
            holder = (ViewHolder)view.getTag();
        }
        Task task = tasks.Tasks().get(i);
        holder.checkBox.setText(task.getTaskName());
        holder.textView.setText(task.getNotes());

        holder.imageButton.setTag(R.integer.btn_edit, view);
        holder.imageButton.setTag(R.integer.btn_pos, i);
        holder.imageButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Integer pos = (Integer)holder.imageButton.getTag(R.integer.btn_pos);
                Intent intent = new Intent(context, CreateTaskActivity.class).putExtra("Task", tasks.GetTask(pos));
                context.startActivity(intent);
            }
        });

        holder.checkBox.setTag(R.integer.chk, view);
        holder.checkBox.setTag(R.integer.chk_pos, i);
        holder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Integer pos = (Integer)holder.checkBox.getTag(R.integer.chk_pos);
                if(b == true)
                {
                    compoundButton.setPaintFlags(compoundButton.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
                }
                else
                {
                    compoundButton.setPaintFlags(compoundButton.getPaintFlags() & (~Paint.STRIKE_THRU_TEXT_FLAG));
                }
            }
        });

        return view;

    }
    private class ViewHolder {

        protected  ImageButton imageButton;
        protected  CheckBox checkBox;
        protected  TextView textView;
    }
}
