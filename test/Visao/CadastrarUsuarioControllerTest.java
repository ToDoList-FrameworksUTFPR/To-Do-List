/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Visao;

import Controle.CadastrarUsuarioController;
import java.net.URL;
import java.sql.Savepoint;
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
public class CadastrarUsuarioControllerTest {
    
    public CadastrarUsuarioControllerTest() {
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
     * Test of cancelarAcao method, of class CadastrarUsuarioController.
     */
    @Test
    public void testCancelarAcao() {
        System.out.println("cancelarAcao");
        CadastrarUsuarioController instance = new CadastrarUsuarioController();
        instance.cancelarAcao();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cadastrarAcao method, of class CadastrarUsuarioController.
     */
    @Test
    public void testCadastrarAcao() {
        System.out.println("cadastrarAcao");
        CadastrarUsuarioController instance = new CadastrarUsuarioController();
        instance.cadastrarAcao();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of initialize method, of class CadastrarUsuarioController.
     */
    @Test
    public void testInitialize() {
        System.out.println("initialize");
        URL url = null;
        ResourceBundle rb = null;
        CadastrarUsuarioController instance = new CadastrarUsuarioController();
        instance.initialize(url, rb);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}