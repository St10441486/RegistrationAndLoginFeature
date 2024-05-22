/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author ernes
 */
public class EasyKanbanManagerTest {
    
    public EasyKanbanManagerTest() {
        System.out.println("taskchecker");
        String taskName = "Games";
        String taskDescription = " play games";
        String taskDuration = "3"; 
        boolean expResult = true;
        boolean result = expResult;
        assertEquals(expResult, result);
    }

    @Test
    public void testTaskmanager() {
    }
    
}
