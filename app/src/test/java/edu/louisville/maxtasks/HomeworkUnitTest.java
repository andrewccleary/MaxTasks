package edu.louisville.maxtasks;

import org.junit.Test;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

import edu.louisville.maxtasks.Model.Homework;

import static org.junit.Assert.assertEquals;

public class HomeworkUnitTest {

    @Test
    public void Create_Homework_Name() {

        String s = "1/1/1900";
        String e = "1/1/1900";
        Date due_date =new SimpleDateFormat("dd/MM/yyyy").parse(s, new ParsePosition(5));
        Date start_date =new SimpleDateFormat("dd/MM/yyyy").parse(e, new ParsePosition(5));

        Homework homework = new Homework("Task Name", 1, "Task Notes", due_date, start_date, 4, "CECS 550");

        String expected_name = "Task Name";

        assertEquals(expected_name, homework.getTaskName());
    }

    @Test
    public void Create_Homework_Priority() {

        String s = "1/1/1900";
        String e = "1/1/1900";
        Date due_date =new SimpleDateFormat("dd/MM/yyyy").parse(s, new ParsePosition(5));
        Date start_date =new SimpleDateFormat("dd/MM/yyyy").parse(e, new ParsePosition(5));

        Homework homework = new Homework("Task Name", 1, "Task Notes", due_date, start_date, 4, "CECS 550");

        int expected_priority = 1;

        assertEquals(expected_priority, homework.getPriority());
    }

    @Test
    public void Create_Homework_Due_Date() {

        String s = "1/1/1900";
        String e = "1/1/1900";
        Date due_date =new SimpleDateFormat("dd/MM/yyyy").parse(s, new ParsePosition(5));
        Date start_date =new SimpleDateFormat("dd/MM/yyyy").parse(e, new ParsePosition(5));

        Homework homework = new Homework("Task Name", 1, "Task Notes", due_date, start_date, 4, "CECS 550");

        Date expected_due_date = due_date;

        assertEquals(expected_due_date, homework.getDueDate());
    }

    @Test
    public void Create_Homework_Start_Date() {

        String s = "1/1/1900";
        String e = "1/1/1900";
        Date due_date =new SimpleDateFormat("dd/MM/yyyy").parse(s, new ParsePosition(5));
        Date start_date =new SimpleDateFormat("dd/MM/yyyy").parse(e, new ParsePosition(5));

        Homework homework = new Homework("Task Name", 1, "Task Notes", due_date, start_date, 4, "CECS 550");

        Date expected_start_date = start_date;

        assertEquals(expected_start_date, homework.getDueDate());
    }

    @Test
    public void Create_Homework_Duration() {

        String s = "1/1/1900";
        String e = "1/1/1900";
        Date due_date =new SimpleDateFormat("dd/MM/yyyy").parse(s, new ParsePosition(5));
        Date start_date =new SimpleDateFormat("dd/MM/yyyy").parse(e, new ParsePosition(5));

        Homework homework = new Homework("Task Name", 1, "Task Notes", due_date, start_date, 4, "CECS 550");

        int expected_duration = 4;

        assertEquals(expected_duration, homework.getExpectedDuration());
    }

    @Test
    public void Create_Homework_Class_Name() {

        String s = "1/1/1900";
        String e = "1/1/1900";
        Date due_date =new SimpleDateFormat("dd/MM/yyyy").parse(s, new ParsePosition(5));
        Date start_date =new SimpleDateFormat("dd/MM/yyyy").parse(e, new ParsePosition(5));

        Homework homework = new Homework("Task Name", 1, "Task Notes", due_date, start_date, 4, "CECS 550");

        String expected_class_name = "CECS 550";

        assertEquals(expected_class_name, homework.getClassName());
    }
}
