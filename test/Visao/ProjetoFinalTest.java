/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Visao;

import javafx.stage.Stage;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Rayan
 */
public class ProjetoFinalTest {
    
    public ProjetoFinalTest() {
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
     * Test of getInstance method, of class ProjetoFinal.
     */
    @Test
    public void testGetInstance() {
        System.out.println("getInstance");
        ProjetoFinal expResult = null;
        ProjetoFinal result = ProjetoFinal.getInstance();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of goTo method, of class ProjetoFinal.
     */
    @Test
    public void testGoTo() {
        System.out.println("goTo");
        String arquivo = "";
        ProjetoFinal instance = new ProjetoFinal();
        instance.goTo(arquivo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of start method, of class ProjetoFinal.
     */
    @Test
    public void testStart() throws Exception {
        System.out.println("start");
        Stage stage = null;
        ProjetoFinal instance = new ProjetoFinal();
        instance.start(stage);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class ProjetoFinal.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        ProjetoFinal.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}