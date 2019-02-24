package edu.louisville.maxtasks;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;

public class CreateTaskActivity extends AppCompatActivity {

    private Spinner mTaskTypeSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_task);

        mTaskTypeSpinner = findViewById(R.id.task_type_spinner);

    }
}
