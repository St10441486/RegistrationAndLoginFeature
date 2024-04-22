/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.registrationandloginfeature;

import javax.swing.JOptionPane;

/**
 *
 * @author RC_Student_lab
 * //st10441486
 * //Ernest Sebola
 */
public class RegistrationAndLoginFeature {

    public static void main(String[] args) {
        boolean SignUpLogin = false;
        UserNameUserPassWord NamePassword = new UserNameUserPassWord();
        LoginUser login = new LoginUser(NamePassword.getUserCredentials());
        
        while (!SignUpLogin) {
            String choice = JOptionPane.showInputDialog("Choose an option:\n1. Login\n2. Sign up\n3. Exit");
            switch (choice) {
                case "1":
                    SignUpLogin = login.main();
                    break;
                case "2":
                    NamePassword.main();
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


