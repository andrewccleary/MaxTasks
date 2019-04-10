package edu.louisville.maxtasks;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;

import edu.louisville.maxtasks.Model.Task;
import edu.louisville.maxtasks.Model.TaskList;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private ImageButton mAddTaskButton;
    private TaskList tasks;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tasks = new TaskList();

        tasks.Add("MongoDB Exam",1,"Exam", "MongoDB in a Distributed Setting");
        tasks.Add("CECS 550 Homework 4",3,"Homework","Submit by April 17");
        tasks.Add("Capstone Team Meeting",3,"Activity","April 19, 2019");
        tasks.Add("SQL Injection Paper",4,"Homework","Complete Final Draft");
        tasks.Add("Open Source Security Project",5,"Project","Group Project w/ Celine");
        tasks.Add("Finish MaxTasks",6,"Project","Please hurry!");

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.ic_menu);

        mDrawerLayout = findViewById(R.id.drawer_layout);
        mAddTaskButton = findViewById(R.id.new_task_button);

        listView = findViewById(R.id.simpleListView);
        ListViewAdapter adapter = new ListViewAdapter(getApplicationContext(), tasks);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, CreateTaskActivity.class).putExtra("Task", tasks.GetTask(i));
                startActivityForResult(intent, 2);
            }
        });

        mAddTaskButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CreateTaskActivity.class);
                startActivityForResult(intent, 1);
            }
        });

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        // set item as selected to persist highlight
                        menuItem.setChecked(true);
                        // close drawer when item is tapped
                        mDrawerLayout.closeDrawers();

                        // Add code here to update the UI based on the item selected
                        // For example, swap UI fragments here
                        if(menuItem.getItemId() == R.id.nav_tasks){
                            Intent intent = new Intent(MainActivity.this, TaskViewActivity.class);
                            startActivity(intent);
                        }else if(menuItem.getItemId() == R.id.nav_analysis){
                            Intent intent = new Intent(MainActivity.this, TaskAnalysisActivity.class);
                            startActivity(intent);
                        }
                        return true;
                    }
                });


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if(resultCode == RESULT_OK) {
                Task task = (Task)data.getSerializableExtra("Task");
                tasks.Add(task);
            }
        }else if (requestCode ==2){
            if(resultCode == RESULT_OK) {
                Task task = (Task)data.getSerializableExtra("Task");
                tasks.Add(task);
            }
        }
    }
}
