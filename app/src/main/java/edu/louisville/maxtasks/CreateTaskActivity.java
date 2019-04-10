package edu.louisville.maxtasks;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import edu.louisville.maxtasks.Model.Task;

public class CreateTaskActivity extends AppCompatActivity   {

    private Spinner mTaskPriority, mTaskTypeSpinner;
    private EditText mTaskName, mTaskNotes;

    private Task task;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_task);

        mTaskPriority = findViewById(R.id.priority_spinner);
        mTaskTypeSpinner = findViewById(R.id.task_type_spinner);
        mTaskName = findViewById(R.id.taskName);
        mTaskNotes = findViewById(R.id.taskNotes);

        Intent i = getIntent();
        if(i != null)
        {
            this.task = (Task)i.getSerializableExtra("Task");
            this.mTaskName.setText(task.getTaskName());
            this.mTaskPriority.setSelection(((ArrayAdapter<String>)mTaskPriority.getAdapter()).getPosition((Integer.toString(task.getPriority()))));
            this.mTaskNotes.setText(task.getNotes());

        }

    }
}
