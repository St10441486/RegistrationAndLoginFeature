/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.registrationandloginfeature;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * Ernest Sebola ST10441486
 */
public class EasyKanbanManager {
    public int taskNumber; // To keep track of the task numbers

    public EasyKanbanManager() {
        this.taskNumber = 0; // Initialize task number
    }

    public void Taskmanager() {
        UIManager.put("OptionPane.messageForeground", Color.BLACK);
        UIManager.put("OptionPane.background", Color.LIGHT_GRAY);
        UIManager.put("Panel.background", Color.LIGHT_GRAY);
        JOptionPane.showMessageDialog(null, "Finally Login in to EasyKanban. How can we help you?");
        
        boolean exit = false;
        List<Map<String, String>> tasks = new ArrayList<>();

        while (!exit) {
            String menu = "Choose an option:\n1) Add tasks\n2) Show report\n3) Display tasks\n4) Delete task\n5) Search task\n6) Quit"; 
            String choice = JOptionPane.showInputDialog(menu); 
            switch (choice) { 
                case "1": 
                    addTasks(tasks); 
                    break; 
                case "2": 
                    showReport(); 
                    break; 
                case "3": 
                    displayTasks(tasks); 
                    break; 
                case "4": 
                    deleteTask(tasks); 
                    break; 
                case "5": 
                    searchTask(tasks); 
                    break; 
                case "6": 
                    JOptionPane.showMessageDialog(null, "Goodbye!"); 
                    exit = true;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Invalid choice. Please select a valid option.");
            }
        }
    }

    private void addTasks(List<Map<String, String>> tasks) {
        int numTasks = Integer.parseInt(JOptionPane.showInputDialog("How many tasks would you like to enter?"));

        for (int i = 0; i < numTasks; i++) {
            Map<String, String> task = new HashMap<>();
            
            // Task Name
            String taskName = JOptionPane.showInputDialog("Enter task name:");
            task.put("Task Name", taskName);
            
            // Task Number
            task.put("Task Number", String.valueOf(taskNumber));
            
            // Task Description
            String taskDescription;
            do {
                taskDescription = JOptionPane.showInputDialog("Enter task description (max 50 characters):");
                if (taskDescription.length() > 50) {
                    JOptionPane.showMessageDialog(null, "Please enter a task description of less than 50 characters.");
                }
            } while (taskDescription.length() > 50);
            task.put("Task Description", taskDescription);
            JOptionPane.showMessageDialog(null, "Task successfully captured");

            // Developer Details
            String developerFirstName = JOptionPane.showInputDialog("Enter developer's first name:");
            String developerLastName = JOptionPane.showInputDialog("Enter developer's last name:");
            String developerFullName = developerFirstName + " " + developerLastName;
            task.put("Developer Details", developerFullName);

            // Task Duration
            String taskDuration = JOptionPane.showInputDialog("Enter task duration in hours:");
            task.put("Task Duration", taskDuration);

            // Task ID
            String taskID = generateTaskID(taskName, taskNumber, developerLastName);
            task.put("Task ID", taskID);

            // Display the Task ID to the user
            JOptionPane.showMessageDialog(null, "Task ID: " + taskID);

            // Task Status
            String[] statuses = {"To Do", "Done", "Doing"};
            String taskStatus = (String) JOptionPane.showInputDialog(null, "Choose task status:", "Task Status",
                                JOptionPane.QUESTION_MESSAGE, null, statuses, statuses[0]);
            task.put("Task Status", taskStatus);

            tasks.add(task);
            taskNumber++; // Increment task number for the next task
        }
    }

    public String generateTaskID(String taskName, int taskNumber, String developerLastName) {
        String taskNamePart = taskName.length() >= 2 ? taskName.substring(0, 2) : taskName;
        String taskNumberPart = String.valueOf(taskNumber);
        String developerLastNamePart = developerLastName.length() >= 3 ? developerLastName.substring(developerLastName.length() - 3) : developerLastName;
        return (taskNamePart + ":" + taskNumberPart + ":" + developerLastNamePart).toUpperCase();
    }

    public void showReport() {
        JOptionPane.showMessageDialog(null, "Coming Soon");
    }

    public void displayTasks(List<Map<String, String>> tasks) {
        StringBuilder taskList = new StringBuilder(); 
        for (Map<String, String> task : tasks) { 
            taskList.append("Task Name: ").append(task.get("Task Name")).append("\n"); 
            taskList.append("Task Number: ").append(task.get("Task Number")).append("\n"); 
            taskList.append("Task Description: ").append(task.get("Task Description")).append("\n"); 
            taskList.append("Developer Details: ").append(task.get("Developer Details")).append("\n"); 
            taskList.append("Task Duration: ").append(task.get("Task Duration")).append("\n"); 
            taskList.append("Task ID: ").append(task.get("Task ID")).append("\n"); 
            taskList.append("Task Status: ").append(task.get("Task Status")).append("\n\n"); 
        } 
        JOptionPane.showMessageDialog(null, taskList.toString()); 
    }

    public void deleteTask(List<Map<String, String>> tasks) {
        String taskID = JOptionPane.showInputDialog("Enter the Task ID to delete:");
        Iterator<Map<String, String>> iterator = tasks.iterator();
        boolean found = false;
        while (iterator.hasNext()) {
            Map<String, String> task = iterator.next();
            if (task.get("Task ID").equals(taskID)) {
                iterator.remove();
                found = true;
                JOptionPane.showMessageDialog(null, "Task deleted successfully.");
                break;
            }
        }
        if (!found) {
            JOptionPane.showMessageDialog(null, "Task ID not found.");
        }
    }

    public void searchTask(List<Map<String, String>> tasks) {
        String taskID = JOptionPane.showInputDialog("Enter the Task ID to search:");
        boolean found = false;
        for (Map<String, String> task : tasks) {
            if (task.get("Task ID").equals(taskID)) {
                StringBuilder taskDetails = new StringBuilder();
                taskDetails.append("Task Name: ").append(task.get("Task Name")).append("\n");
                taskDetails.append("Task Number: ").append(task.get("Task Number")).append("\n");
                taskDetails.append("Task Description: ").append(task.get("Task Description")).append("\n");
                taskDetails.append("Developer Details: ").append(task.get("Developer Details")).append("\n");
                taskDetails.append("Task Duration: ").append(task.get("Task Duration")).append("\n");
                taskDetails.append("Task ID: ").append(task.get("Task ID")).append("\n");
                taskDetails.append("Task Status: ").append(task.get("Task Status")).append("\n\n");
                JOptionPane.showMessageDialog(null, taskDetails.toString());
                found = true;
                break;
            }
        }
        if (!found) {
            JOptionPane.showMessageDialog(null, "Task ID not found.");
        }
    }

}