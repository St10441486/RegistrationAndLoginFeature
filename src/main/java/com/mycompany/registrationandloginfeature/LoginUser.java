/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.registrationandloginfeature;

import java.util.Map;
import javax.swing.JOptionPane;

/**
 *
 * @author RC_Student_lab
 */
public class LoginUser {
    private Map<String, String> userCredentials;
    
    public LoginUser(Map<String, String> userCredentials) {
        this.userCredentials = userCredentials; //Store the userCredentials map
    }
    
    public boolean main() {
        String username = JOptionPane.showInputDialog("Enter your username: ");
        String password = JOptionPane.showInputDialog("Enter your Password: ");
        
        if (userCredentials.containsKey(username) && userCredentials.get(username).equals(password)) {
            //Retrieving first and last name from the userCredentials map
            String firstName = userCredentials.get("First Name");
            String lastName = userCredentials.get("Last Name");
            //Successful login logic (e.g, display welcome message)
            JOptionPane.showMessageDialog(null, "Welcome, " + firstName + " " + lastName + "!");
            //Procced to main application screen or perform other actions
            return true;
        }else {
            //Failed login locgic (e.g., display error messe)
            JOptionPane.showMessageDialog(null, "Invalid username or password. Please try again.");
            //You can also handel additional cases ( e.g account lockout after multiple failed attempts)
            return false;
        }
    }
    
}
