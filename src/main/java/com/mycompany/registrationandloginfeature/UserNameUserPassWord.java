/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.registrationandloginfeature;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * Ernest Sebola ST10441486
 */
public class UserNameUserPassWord {
    private Map<String, String> userCredentials;
    
    public UserNameUserPassWord() {
        this.userCredentials = new HashMap<>(); //Initaialize the map
    } 
    
    public void signup() {
        UIManager.put("OptionPane.messageForeground", Color.BLACK);
        
        String username;
        String password;
        boolean myUsername = false;
        boolean myPassword = false;
        
        do{
            
            username = JOptionPane.showInputDialog("Enter a new username : (contains an underscore and is at least 5 characters in length.) ");
            password = JOptionPane.showInputDialog("Enter a password: (password contains at least 8 characters, a capital letter, a number, and a special character.) ");
            
            if (username == null || password == null){
            //User cancelled the registration
            return;
        }
            //UserName and format
            if ( username.length() >= 6 || !username.contains("_")) {
                JOptionPane.showMessageDialog(null, "Username is not correctly formatted. Please ensure that your username contains an underscore and is at least 5 characters in length.");
            }else{
                JOptionPane.showMessageDialog(null, "Username successfully captured");
                // store username and password to the hashmap (userCredentials.put) 
                userCredentials.put(username, password); 
                myUsername = true;
            }
            //Password and format
            if (password.length() < 8 || !password.matches("^(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]).{8,}$")) {
                JOptionPane.showMessageDialog(null, "Password is not correctly formatted. Please ensure that the password contains at least 8 characters, a capital letter, a number, and a special character.");   
            }else {
                JOptionPane.showMessageDialog(null, "Password successfully captured");
                myPassword = true;
            }
        }while (!myUsername || !myPassword);
        //after user has successfully sign up the user can add they First Name and Last Name
        String firstName = JOptionPane.showInputDialog("Enter your First Name: ");
        String lastName = JOptionPane.showInputDialog("Enter your Last Name: ");
        
        //Store first name and last name in the HashMap
        userCredentials.put("First Name", firstName);
        userCredentials.put("Last Name", lastName);
        
        //Display the information using JOption Pane
        JOptionPane.showMessageDialog(null, "First Name: " + userCredentials.get("First Name") + "\nLast Name: " + userCredentials.get("Last Name"));
        
        }
        public Map<String, String> getUserCredentials() {
            return userCredentials;    
        }
}
