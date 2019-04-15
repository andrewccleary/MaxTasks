package edu.louisville.maxtasks;

import org.junit.Test;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

import edu.louisville.maxtasks.Model.Task;

import static org.junit.Assert.assertEquals;

public class TaskUnitTest {

    @Test
    public void Create_Task_Name() {

        Task task = new Task("Task Name", 1, "Activity", "Task Notes");

        String expected_name = "Task Name";

        assertEquals(expected_name, task.getTaskName());
    }

    @Test
    public void Create_Task_Priority() {

        Task task = new Task("Task Name", 1, "Activity", "Task Notes");

        int expected_priority = 1;

        assertEquals(expected_priority, task.getPriority());
    }

    @Test
    public void Create_Task_Category() {

        Task task = new Task("Task Name", 1, "Activity", "Task Notes");

        String expected_category = "Activity";

        assertEquals(expected_category, task.getCategory());
    }

    @Test
    public void Create_Task_Notes() {

        Task task = new Task("Task Name", 1, "Activity", "Task Notes");

        String expected_notes = "Task Notes";

        assertEquals(expected_notes, task.getNotes());
    }

    @Test
    public void Create_Task_Completed() {

        Task task = new Task("Task Name", 1, "Activity", "Task Notes");
        task.setCompleted(true);

        Boolean expected_completed = true;

        assertEquals(expected_completed, task.isCompleted());
    }
}
