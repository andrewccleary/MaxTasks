package edu.louisville.maxtasks;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import edu.louisville.maxtasks.Model.Task;

public class CreateTaskActivity extends AppCompatActivity   {

    private Spinner mTaskPriority, mTaskTypeSpinner;
    private EditText mTaskName, mTaskNotes;
    private Button mSaveButton;
    private Task task;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_task);

        mTaskPriority = findViewById(R.id.priority_spinner);
        mTaskTypeSpinner = findViewById(R.id.task_type_spinner);
        mTaskName = findViewById(R.id.taskName);
        mTaskNotes = findViewById(R.id.taskNotes);
        mSaveButton = findViewById(R.id.save_task_button);

        Intent intent = getIntent();

        if(intent != null)
        {
            this.task = (Task)intent.getSerializableExtra("Task");

            if(task != null){
                this.mTaskName.setText(task.getTaskName());
                this.mTaskPriority.setSelection(((ArrayAdapter<String>)mTaskPriority.getAdapter()).getPosition((Integer.toString(task.getPriority()))));
                this.mTaskTypeSpinner.setSelection(((ArrayAdapter<String>)mTaskTypeSpinner.getAdapter()).getPosition(task.getCategory()));
                this.mTaskNotes.setText(task.getNotes());
            }
        }

        mSaveButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                if(task != null){
                    task.setTaskName(mTaskName.getText().toString());
                    task.setPriority(Integer.parseInt(mTaskPriority.getSelectedItem().toString()));
                    task.setCategory(mTaskTypeSpinner.getSelectedItem().toString());
                    task.setNotes(mTaskNotes.getText().toString());
                }else{
                    task = new Task(mTaskName.getText().toString(),
                            Integer.parseInt(mTaskPriority.getSelectedItem().toString()),
                            mTaskTypeSpinner.getSelectedItem().toString(),
                            mTaskNotes.getText().toString());
                }

                Intent intent = new Intent();
                intent.putExtra("Task", task);
                setResult(RESULT_OK, intent);
                finish();
            }
        });

    }
}
