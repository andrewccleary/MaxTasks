package edu.louisville.maxtasks;

import org.junit.Test;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

import edu.louisville.maxtasks.Model.Exam;

import static org.junit.Assert.assertEquals;

public class ExamUnitTest {

    @Test
    public void Create_Exam_Name() {

        String s = "1/1/1900";
        String e = "1/1/1900";
        Date start_date =new SimpleDateFormat("dd/MM/yyyy").parse(s, new ParsePosition(5));
        Date end_date =new SimpleDateFormat("dd/MM/yyyy").parse(e, new ParsePosition(5));

        Exam exam = new Exam("Task Name", 1,"Task Notes", start_date, end_date, "CECS 550");

        String expected_name = "Task Name";

        assertEquals(expected_name, exam.getTaskName());
    }

    @Test
    public void Create_Exam_Priority() {

        String s = "1/1/1900";
        String e = "1/1/1900";
        Date start_date =new SimpleDateFormat("dd/MM/yyyy").parse(s, new ParsePosition(5));
        Date end_date =new SimpleDateFormat("dd/MM/yyyy").parse(e, new ParsePosition(5));

        Exam exam = new Exam("Task Name", 1,"Task Notes", start_date, end_date, "CECS 550");

        int expected_priority = 1;

        assertEquals(expected_priority, exam.getPriority());
    }

    @Test
    public void Create_Exam_Notes() {

        String s = "1/1/1900";
        String e = "1/1/1900";
        Date start_date =new SimpleDateFormat("dd/MM/yyyy").parse(s, new ParsePosition(5));
        Date end_date =new SimpleDateFormat("dd/MM/yyyy").parse(e, new ParsePosition(5));

        Exam exam = new Exam("Task Name", 1,"Task Notes", start_date, end_date, "CECS 550");

        String expected_notes = "Task Notes";

        assertEquals(expected_notes, exam.getNotes());
    }

    @Test
    public void Create_Exam_Start_Date() {

        String s = "1/1/1900";
        String e = "1/1/1900";
        Date start_date =new SimpleDateFormat("dd/MM/yyyy").parse(s, new ParsePosition(5));
        Date end_date =new SimpleDateFormat("dd/MM/yyyy").parse(e, new ParsePosition(5));

        Exam exam = new Exam("Task Name", 1,"Task Notes", start_date, end_date, "CECS 550");

        Date expected_start_date = start_date;

        assertEquals(expected_start_date, exam.getStartTime());
    }


    @Test
    public void Create_Exam_End_Date() {

        String s = "1/1/1900";
        String e = "1/1/1900";
        Date start_date =new SimpleDateFormat("dd/MM/yyyy").parse(s, new ParsePosition(5));
        Date end_date =new SimpleDateFormat("dd/MM/yyyy").parse(e, new ParsePosition(5));

        Exam exam = new Exam("Task Name", 1,"Task Notes", start_date, end_date, "CECS 550");

        Date expected_end_date = end_date;

        assertEquals(expected_end_date, exam.getEndTime());
    }

    @Test
    public void Create_Exam_Class_Name() {

        String s = "1/1/1900";
        String e = "1/1/1900";
        Date start_date =new SimpleDateFormat("dd/MM/yyyy").parse(s, new ParsePosition(5));
        Date end_date =new SimpleDateFormat("dd/MM/yyyy").parse(e, new ParsePosition(5));

        Exam exam = new Exam("Task Name", 1,"Task Notes", start_date, end_date, "CECS 550");

        String expected_class_name = "CECS 550";

        assertEquals(expected_class_name, exam.getClassName());
    }

    @Test
    public void Create_Exam_Grade() {

        String s = "1/1/1900";
        String e = "1/1/1900";
        Date start_date =new SimpleDateFormat("dd/MM/yyyy").parse(s, new ParsePosition(5));
        Date end_date =new SimpleDateFormat("dd/MM/yyyy").parse(e, new ParsePosition(5));

        Exam exam = new Exam("Task Name", 1,"Task Notes", start_date, end_date, "CECS 550");
        exam.setGrade((float)99);

        Float expected_grade = (float)99;

        assertEquals(expected_grade, exam.getGrade(), (float)0);
    }
}
