package edu.louisville.maxtasks;

import org.junit.Test;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import edu.louisville.maxtasks.Model.Activity;

public class ActivityUnitTest {

    @Test
    public void Create_Activity_Name() {

        String s = "1/1/1900";
        String e = "1/1/1900";
        Date start_date =new SimpleDateFormat("dd/MM/yyyy").parse(s, new ParsePosition(5));
        Date end_date =new SimpleDateFormat("dd/MM/yyyy").parse(e, new ParsePosition(5));

        Activity activity = new Activity("Task Name", 1, "Activity Notes", start_date, end_date, "Activity");

        String expected_name = "Task Name";

        assertEquals(expected_name, activity.getTaskName());
    }

    @Test
    public void Create_Activity_Priority() {

        String s = "1/1/1900";
        String e = "1/1/1900";
        Date start_date =new SimpleDateFormat("dd/MM/yyyy").parse(s, new ParsePosition(5));
        Date end_date =new SimpleDateFormat("dd/MM/yyyy").parse(e, new ParsePosition(5));

        Activity activity = new Activity("Task Name", 1, "Activity Notes", start_date, end_date, "Activity");

        int expected_priority = 1;

        assertEquals(expected_priority, activity.getPriority());
    }

    @Test
    public void Create_Activity_Notes() {

        String s = "1/1/1900";
        String e = "1/1/1900";
        Date start_date =new SimpleDateFormat("dd/MM/yyyy").parse(s, new ParsePosition(5));
        Date end_date =new SimpleDateFormat("dd/MM/yyyy").parse(e, new ParsePosition(5));

        Activity activity = new Activity("Task Name", 1, "Activity Notes", start_date, end_date, "Activity");

        String expected_notes = "Activity Notes";

        assertEquals(expected_notes, activity.getNotes());
    }

    @Test
    public void Create_Activity_Start_Date() {

        String s = "1/1/1900";
        String e = "1/1/1900";
        Date start_date =new SimpleDateFormat("dd/MM/yyyy").parse(s, new ParsePosition(5));
        Date end_date =new SimpleDateFormat("dd/MM/yyyy").parse(e, new ParsePosition(5));

        Activity activity = new Activity("Task Name", 1, "Activity Notes", start_date, end_date, "Activity");

        Date expected_start_date = start_date;

        assertEquals(expected_start_date, activity.getStartDate());
    }

    @Test
    public void Create_Activity_End_Date() {

        String s = "1/1/1900";
        String e = "1/1/1900";
        Date start_date =new SimpleDateFormat("dd/MM/yyyy").parse(s, new ParsePosition(5));
        Date end_date =new SimpleDateFormat("dd/MM/yyyy").parse(e, new ParsePosition(5));

        Activity activity = new Activity("Task Name", 1, "Activity Notes", start_date, end_date, "Activity");

        Date expected_end_date = end_date;

        assertEquals(expected_end_date, activity.getEndDate());
    }

    @Test
    public void Create_Activity_Activity_Type() {

        String s = "1/1/1900";
        String e = "1/1/1900";
        Date start_date =new SimpleDateFormat("dd/MM/yyyy").parse(s, new ParsePosition(5));
        Date end_date =new SimpleDateFormat("dd/MM/yyyy").parse(e, new ParsePosition(5));

        Activity activity = new Activity("Task Name", 1, "Activity Notes", start_date, end_date, "Activity");

        String expected_activity_type = "Activity";

        assertEquals(expected_activity_type, activity.getActivityType());
    }
}
