/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import java.net.URL;
import java.util.ResourceBundle;
import org.easymock.EasyMock;
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
public class PrincipalControllerTest {
    
    public PrincipalControllerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        PrincipalController p = EasyMock.createMock(PrincipalController.class);        
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of initialize method, of class PrincipalController.
     */
    @Test
    public void testInitialize() {
        System.out.println("initialize");
        URL url = null;
        ResourceBundle rb = null;
        PrincipalController instance = new PrincipalController();
        instance.initialize(url, rb);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of alterarDados method, of class PrincipalController.
     */
    @Test
    public void testAlterarDados() {
        System.out.println("alterarDados");
        PrincipalController instance = new PrincipalController();
        instance.alterarDados();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of alterarDados_mouseEmCima method, of class PrincipalController.
     */
    @Test
    public void testAlterarDados_mouseEmCima() {
        System.out.println("alterarDados_mouseEmCima");
        PrincipalController instance = new PrincipalController();
        instance.alterarDados_mouseEmCima();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of alterarDados_mouseFora method, of class PrincipalController.
     */
    @Test
    public void testAlterarDados_mouseFora() {
        System.out.println("alterarDados_mouseFora");
        PrincipalController instance = new PrincipalController();
        instance.alterarDados_mouseFora();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}