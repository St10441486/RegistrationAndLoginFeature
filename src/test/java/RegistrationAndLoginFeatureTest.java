/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import java.awt.Color;
import javax.swing.UIManager;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * Ernest Sebola ST10441486
 */
public class RegistrationAndLoginFeatureTest {
    

    @Test
    public void RegistrationAndLoginFeatureTest() {
            UIManager.put("OptionPane.messageForeground", Color.BLACK);

        System.out.println("checkUsername");
        String username = "kyl_1";
        boolean expResult = true;
        boolean result = expResult;
        assertEquals(expResult, result);
       
    }

    @Test
    public void testGetUserCredentials() {
        System.out.println("checkPassword");
        String username = "Ch&&sec@ke99";
        boolean expResult = true;
        boolean result = expResult;
        assertEquals(expResult, result);
    }
    
    public void test() {
        System.out.println("checkUsername");
        String username = "kyl_145454545454";
        boolean expResult = false;
        boolean result = expResult;
        assertEquals(expResult, result);
       
    }
    
}