package edu.louisville.maxtasks;

import org.junit.Test;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

import edu.louisville.maxtasks.Model.Project;

import static org.junit.Assert.assertEquals;

public class ProjectUnitTest {

    @Test
    public void Create_Project_Name() {

        String s = "1/1/1900";
        String e = "1/1/1900";
        Date due_date =new SimpleDateFormat("dd/MM/yyyy").parse(s, new ParsePosition(5));
        Date start_date =new SimpleDateFormat("dd/MM/yyyy").parse(e, new ParsePosition(5));

        Project project = new Project("Task Name", 1, "Task Notes", due_date, start_date, 4, "CECS 550");

        String expected_name = "Task Name";

        assertEquals(expected_name, project.getTaskName());
    }

    @Test
    public void Create_Project_Priority() {

        String s = "1/1/1900";
        String e = "1/1/1900";
        Date due_date =new SimpleDateFormat("dd/MM/yyyy").parse(s, new ParsePosition(5));
        Date start_date =new SimpleDateFormat("dd/MM/yyyy").parse(e, new ParsePosition(5));

        Project project = new Project("Task Name", 1, "Task Notes", due_date, start_date, 4, "CECS 550");

        int expected_priority = 1;

        assertEquals(expected_priority, project.getPriority());
    }

    @Test
    public void Create_Project_Notes() {

        String s = "1/1/1900";
        String e = "1/1/1900";
        Date due_date =new SimpleDateFormat("dd/MM/yyyy").parse(s, new ParsePosition(5));
        Date start_date =new SimpleDateFormat("dd/MM/yyyy").parse(e, new ParsePosition(5));

        Project project = new Project("Task Name", 1, "Task Notes", due_date, start_date, 4, "CECS 550");

        String expected_notes = "Task Notes";

        assertEquals(expected_notes, project.getNotes());
    }

    @Test
    public void Create_Project_Due_Date() {

        String s = "1/1/1900";
        String e = "1/1/1900";
        Date due_date =new SimpleDateFormat("dd/MM/yyyy").parse(s, new ParsePosition(5));
        Date start_date =new SimpleDateFormat("dd/MM/yyyy").parse(e, new ParsePosition(5));

        Project project = new Project("Task Name", 1, "Task Notes", due_date, start_date, 4, "CECS 550");

        Date expected_due_date = due_date;

        assertEquals(expected_due_date, project.getDueDate());
    }

    @Test
    public void Create_Project_Start_Date() {

        String s = "1/1/1900";
        String e = "1/1/1900";
        Date due_date =new SimpleDateFormat("dd/MM/yyyy").parse(s, new ParsePosition(5));
        Date start_date =new SimpleDateFormat("dd/MM/yyyy").parse(e, new ParsePosition(5));

        Project project = new Project("Task Name", 1, "Task Notes", due_date, start_date, 4, "CECS 550");

        Date expected_start_date = start_date;

        assertEquals(expected_start_date, project.getStartDate());
    }

    @Test
    public void Create_Project_Duration() {

        String s = "1/1/1900";
        String e = "1/1/1900";
        Date due_date =new SimpleDateFormat("dd/MM/yyyy").parse(s, new ParsePosition(5));
        Date start_date =new SimpleDateFormat("dd/MM/yyyy").parse(e, new ParsePosition(5));

        Project project = new Project("Task Name", 1, "Task Notes", due_date, start_date, 4, "CECS 550");

        int expected_duration = 4;

        assertEquals(expected_duration, project.getExpectedDuration());
    }

    @Test
    public void Create_Project_Class_Name() {

        String s = "1/1/1900";
        String e = "1/1/1900";
        Date due_date =new SimpleDateFormat("dd/MM/yyyy").parse(s, new ParsePosition(5));
        Date start_date =new SimpleDateFormat("dd/MM/yyyy").parse(e, new ParsePosition(5));

        Project project = new Project("Task Name", 1, "Task Notes", due_date, start_date, 4, "CECS 550");

        String expected_class_name = "CECS 550";

        assertEquals(expected_class_name, project.getClassName());
    }

    @Test
    public void Create_Project_Grade() {

        String s = "1/1/1900";
        String e = "1/1/1900";
        Date due_date =new SimpleDateFormat("dd/MM/yyyy").parse(s, new ParsePosition(5));
        Date start_date =new SimpleDateFormat("dd/MM/yyyy").parse(e, new ParsePosition(5));

        Project project = new Project("Task Name", 1, "Task Notes", due_date, start_date, 4, "CECS 550");
        project.setGrade((float)99);

        Float expected_grade = (float)99;

        assertEquals(expected_grade, project.getGrade(), 0);
    }
}
