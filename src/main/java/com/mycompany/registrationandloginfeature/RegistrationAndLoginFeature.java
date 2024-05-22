/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.registrationandloginfeature;

import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author RC_Student_lab
 * //st10441486
 * //ErnestSebola
 */
public class RegistrationAndLoginFeature {

    public static void main(String[] args) {
        UIManager.put("OptionPane.messageForeground", Color.BLACK);
        UIManager.put("OptionPane.background", Color.LIGHT_GRAY);
        UIManager.put("Panel.background", Color.LIGHT_GRAY);
        boolean SignUpLogin = false;
        UserNameUserPassWord NamePassword = new UserNameUserPassWord();
        LoginUser login = new LoginUser(NamePassword.getUserCredentials());
        JOptionPane.showMessageDialog(null, "Welcome to EasyKanban SignUp first before Logging in");
        
        //Sign up , Login Page and exit
        while (!SignUpLogin) {
            String choice = JOptionPane.showInputDialog("Choose an option:\n1. Sign up\n2. Login\n3. Exit");
            switch (choice) {
                case "1":
                    NamePassword.signup();
                    break;
                case "2":
                    SignUpLogin = login.inlog();
                    break;
                case "3":
                    JOptionPane.showMessageDialog(null, "Goodbye!");
                    SignUpLogin = true;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Invalid choice. Please try again. ");
                    
            }
        }
        
        
    }
}