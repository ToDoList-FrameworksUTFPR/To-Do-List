/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Visao;

import java.net.URL;
import java.util.ResourceBundle;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author Rayan
 */
public class LoginControllerTest {
    
    public LoginControllerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of initialize method, of class LoginController.
     */
    @Test
    public void testInitialize() {
        System.out.println("initialize");
        URL url = null;
        ResourceBundle rb = null;
        LoginController instance = new LoginController();
        instance.initialize(url, rb);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of mouseDentro method, of class LoginController.
     */
    @Test
    public void testMouseDentro() {
        System.out.println("mouseDentro");
        LoginController instance = new LoginController();
        instance.mouseDentro();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of mouseFora method, of class LoginController.
     */
    @Test
    public void testMouseFora() {
        System.out.println("mouseFora");
        LoginController instance = new LoginController();
        instance.mouseFora();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of mouseClick method, of class LoginController.
     */
    @Ignore
    public void testMouseClick() {
        System.out.println("mouseClick");
        LoginController instance = new LoginController();
        instance.mouseClick();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}