/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import com.mycompany.registrationandloginfeature.EasyKanbanManager;
import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.swing.UIManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 *
 * @author ernes
 */
public class EasyKanbanManagerTest {

    @Test
    public void testTaskManager() {
        UIManager.put("OptionPane.messageForeground", Color.BLACK);
        UIManager.put("OptionPane.background", Color.LIGHT_GRAY);
        UIManager.put("Panel.background", Color.LIGHT_GRAY);
        EasyKanbanManager manager = new EasyKanbanManager();
        List<Map<String, String>> tasks = new ArrayList<>();

        // Add tasks
        addTaskTest(manager, tasks, "Create Add Features", "Task 2", "Edward", "Harrison", "8", "Doing");
        addTaskTest(manager, tasks, "Create Login", "Task 1", "Mike", "Smith", "5", "To Do");
        addTaskTest(manager, tasks, "Add Arrays", "Task 4", "Glenda", "Oberholzer", "11", "To Do");
        addTaskTest(manager, tasks, "Create Reports", "Task 2", "Samantha", "Paulson", "2", "Done");

        // Display tasks
        displayTasksTest(manager, tasks);

        // Delete a task
        deleteTaskTest(manager, tasks, "AD:2:ZER");

        // Search for a task
        searchTaskTest(manager, tasks, "CR:0:SON");

        // Exit the application
        exitTest(manager);
    }

    private void addTaskTest(EasyKanbanManager manager, List<Map<String, String>> tasks, String taskName, String taskDescription,
                             String devFirstName, String devLastName, String taskDuration, String taskStatus) {
        
        // Simulating user input for addTask
        Map<String, String> task = new HashMap<>();
        task.put("Task Name", taskName);
        task.put("Task Number", String.valueOf(manager.taskNumber));
        task.put("Task Description", taskDescription);
        task.put("Developer Details", devFirstName + " " + devLastName);
        task.put("Task Duration", taskDuration);
        task.put("Task ID", manager.generateTaskID(taskName, manager.taskNumber, devLastName));
        task.put("Task Status", taskStatus);

        tasks.add(task);
        manager.taskNumber++;
    }

    private void displayTasksTest(EasyKanbanManager manager, List<Map<String, String>> tasks) {
        // Simulate displaying tasks
        manager.displayTasks(tasks);
    }

    private void deleteTaskTest(EasyKanbanManager manager, List<Map<String, String>> tasks, String taskID) {
        Iterator<Map<String, String>> iterator = tasks.iterator();
        while (iterator.hasNext()) {
            Map<String, String> task = iterator.next();
            if (task.get("Task ID").equals(taskID)) {
                iterator.remove();
                break;
            }
        }
    }

    public void searchTaskTest(EasyKanbanManager manager, List<Map<String, String>> tasks, String taskID) {
        boolean found = false;
        for (Map<String, String> task : tasks) {
            if (task.get("Task ID").equals(taskID)) {
                found = true;
                break;
            }
        }
        Assertions.assertTrue(found, "Task ID not found in search.");
    }

    private void exitTest(EasyKanbanManager manager) {
        // Simulating exit action (not directly testable here)
        System.out.println("Thank You Goodbye!");
    }
}