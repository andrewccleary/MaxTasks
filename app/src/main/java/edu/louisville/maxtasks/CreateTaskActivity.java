package edu.louisville.maxtasks;

import android.app.AlarmManager;
import android.app.Application;
import android.app.DatePickerDialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;


import java.util.Calendar;
import java.util.Date;

import edu.louisville.maxtasks.Model.Notification;
import edu.louisville.maxtasks.Model.Task;

public class CreateTaskActivity extends AppCompatActivity implements View.OnClickListener   {

    private Spinner mTaskPriority, mTaskTypeSpinner;
    private EditText mTaskName, mTaskNotes, mPickedDate;
    private Button mSaveButton;
    private Task task;
    private ImageButton mPickDateButton;
    private int mYear, mMonth, mDay, mHour, mMinute;
    private String hourOfDay;
    private TimePicker timePicker;

    @Override
    @SuppressWarnings("unchecked")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_task);

        mTaskPriority = findViewById(R.id.priority_spinner);
        mTaskTypeSpinner = findViewById(R.id.task_type_spinner);
        mTaskName = findViewById(R.id.taskName);
        mTaskNotes = findViewById(R.id.taskNotes);
        mSaveButton = findViewById(R.id.save_task_button);
        mPickDateButton = findViewById(R.id.btn_date);
        mPickedDate = findViewById(R.id.date_text);
        timePicker = findViewById(R.id.time_picker);

        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker timePicker, int i, int i1) {
                mHour = timePicker.getHour();
                mMinute = timePicker.getMinute();
                hourOfDay = "AM";
                if(i > 11){
                    hourOfDay = "PM";
                }
            }
        });

        Intent intent = getIntent();

        if(intent != null)
        {
            this.task = (Task)intent.getSerializableExtra("Task");

            if(task != null){
                this.mTaskName.setText(task.getTaskName());
                this.mTaskPriority.setSelection(((ArrayAdapter<String>)mTaskPriority.getAdapter()).getPosition((Integer.toString(task.getPriority()))));
                this.mTaskTypeSpinner.setSelection(((ArrayAdapter<String>)mTaskTypeSpinner.getAdapter()).getPosition(task.getCategory()));
                this.mTaskNotes.setText(task.getNotes());
                this.mPickedDate.setText(task.GetNotificationDateFormatted());
            }
        }

        mPickDateButton.setOnClickListener(this);
        mSaveButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v == mPickDateButton) {
            final Calendar c = Calendar.getInstance();
            mYear = c.get(Calendar.YEAR);
            mMonth = c.get(Calendar.MONTH);
            mDay = c.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog datePickerDialog = new DatePickerDialog(this,R.style.DialogTheme,
                    new DatePickerDialog.OnDateSetListener() {

                        @Override
                        public void onDateSet(DatePicker view, int year,
                                              int monthOfYear, int dayOfMonth) {

                            mPickedDate.setText((monthOfYear + 1) + "/" + dayOfMonth + "/" + year);

                        }
                    }, mYear, mMonth, mDay);

            datePickerDialog.show();
        }
        else if(v == mSaveButton)
        {
            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");

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

                Date d = new Date();
                try{
                     // here set the pattern as you date in string was containing like date/month/year
                    d = sdf.parse(mPickedDate.getText().toString());
                }catch(ParseException ex){
                    // handle parsing exception if date string was different from the pattern applying into the SimpleDateFormat contructor
                }
                task.setNotificationDate(d);
            }

            Intent nIntent = new Intent();
            nIntent.putExtra("Task", task);
            setResult(RESULT_OK, nIntent);
            if(task != null) {
                AlarmManager alarmMgr = (AlarmManager) getApplicationContext().getSystemService(Context.ALARM_SERVICE);
                Intent intent = new Intent(getApplicationContext(), AlarmReceiver.class).putExtra("Title", task.getTaskName()).putExtra("Desc", task.getNotes());

                PendingIntent alarmIntent = PendingIntent.getBroadcast(getApplicationContext(), 5454, intent, 0);

                Calendar calendar = Calendar.getInstance();
                calendar.setTimeInMillis(System.currentTimeMillis());
                calendar.set(Calendar.MONTH, this.mMonth);
                calendar.set(Calendar.DAY_OF_MONTH, this.mDay);
                calendar.set(Calendar.YEAR, this.mYear);
                calendar.set(Calendar.HOUR_OF_DAY, mHour);
                calendar.set(Calendar.MINUTE, mMinute);

                //int hour = hourOfDay == "PM" ? mHour + 12 : mHour;
                Log.d("hourOfDay:", hourOfDay);
                Log.d("hours: ", Integer.toString(mHour));
                calendar.set(Calendar.HOUR_OF_DAY, mHour);

                //Log.d("Current Time:", Long.toString(calendar.getTimeInMillis()) + "  " + mdformat.format(calendar.getTime()));

                Log.d("Calendar:", Long.toString(calendar.getTimeInMillis()));
                Log.d("Total:", Long.toString((calendar.getTimeInMillis() - System.currentTimeMillis())));

                alarmMgr.setInexactRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), AlarmManager.INTERVAL_DAY, alarmIntent);

            }
            finish();
        }
    }

}
