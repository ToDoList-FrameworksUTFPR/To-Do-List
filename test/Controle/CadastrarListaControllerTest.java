/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import java.net.URL;
import java.util.ResourceBundle;
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
public class CadastrarListaControllerTest {
    
    public CadastrarListaControllerTest() {
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
     * Test of cancelarAcao method, of class CadastrarListaController.
     */
    @Test
    public void testCancelarAcao() {
        System.out.println("cancelarAcao");
        CadastrarListaController instance = new CadastrarListaController();
        instance.cancelarAcao();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cadastrarAcao method, of class CadastrarListaController.
     */
    @Test
    public void testCadastrarAcao() {
        System.out.println("cadastrarAcao");
        CadastrarListaController instance = new CadastrarListaController();
        instance.cadastrarAcao();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of initialize method, of class CadastrarListaController.
     */
    @Test
    public void testInitialize() {
        System.out.println("initialize");
        URL url = null;
        ResourceBundle rb = null;
        CadastrarListaController instance = new CadastrarListaController();
        instance.initialize(url, rb);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}