/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.registrationandloginfeature;

import java.awt.Color;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * Ernest Sebola ST10441486
 */
public class LoginUser {
    private Map<String, String> userCredentials;
    public LoginUser(Map<String, String> userCredentials) {
        this.userCredentials = userCredentials;
    }

    public boolean inlog() {
        UIManager.put("OptionPane.messageForeground", Color.BLACK);
        String username = JOptionPane.showInputDialog("Enter your username: ");
        String password = JOptionPane.showInputDialog("Enter your Password: ");

        if (userCredentials.containsKey(username) && userCredentials.get(username).equals(password)) {
            // Retrieving first and last name from the userCredentials map
            String firstName = userCredentials.get("First Name");
            String lastName = userCredentials.get("Last Name");
            // Successful login logic (e.g, display welcome message)
            JOptionPane.showMessageDialog(null, "Welcome, " + firstName + " " + lastName + "!");
            // Proceed to main application screen or perform other actions
            
            EasyKanbanManager Task = new EasyKanbanManager();
            Task.Taskmanager();
            return true;
        } else {
            // Failed login logic (e.g., display error message)
            JOptionPane.showMessageDialog(null, "Invalid username or password. Please try again.");
            // You can also handle additional cases (e.g., account lockout after multiple failed attempts)
            return false;
        }
    }

}