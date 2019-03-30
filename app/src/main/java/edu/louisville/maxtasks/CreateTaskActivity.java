package edu.louisville.maxtasks;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import edu.louisville.maxtasks.Model.Task;

public class CreateTaskActivity extends AppCompatActivity   {

    private Spinner mTaskTypeSpinner;
    Task task;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_task);

        mTaskTypeSpinner = findViewById(R.id.task_type_spinner);

        Intent i = getIntent();
        if(i != null)
        {
            this.task = (Task)i.getSerializableExtra("Task");
        }

    }
}
