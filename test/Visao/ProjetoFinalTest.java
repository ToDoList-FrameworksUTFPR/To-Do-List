/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Visao;

import Modelo.Item;
import Modelo.Lista;
import Modelo.Subitem;
import Modelo.Usuario;
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
     * Test of instanciarUsuario method, of class ProjetoFinal.
     */
    @Test
    public void testInstanciarUsuario() {
        System.out.println("instanciarUsuario");
        Usuario u = null;
        ProjetoFinal instance = new ProjetoFinal();
        instance.instanciarUsuario(u);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of retornarUsuario method, of class ProjetoFinal.
     */
    @Test
    public void testRetornarUsuario() {
        System.out.println("retornarUsuario");
        ProjetoFinal instance = new ProjetoFinal();
        Usuario expResult = null;
        Usuario result = instance.retornarUsuario();
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

    /**
     * Test of getListaTemp method, of class ProjetoFinal.
     */
    @Test
    public void testGetListaTemp() {
        System.out.println("getListaTemp");
        ProjetoFinal instance = new ProjetoFinal();
        Lista expResult = null;
        Lista result = instance.getListaTemp();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setListaTemp method, of class ProjetoFinal.
     */
    @Test
    public void testSetListaTemp() {
        System.out.println("setListaTemp");
        Lista listaTemp = null;
        ProjetoFinal instance = new ProjetoFinal();
        instance.setListaTemp(listaTemp);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getItemTemp method, of class ProjetoFinal.
     */
    @Test
    public void testGetItemTemp() {
        System.out.println("getItemTemp");
        ProjetoFinal instance = new ProjetoFinal();
        Item expResult = null;
        Item result = instance.getItemTemp();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setItemTemp method, of class ProjetoFinal.
     */
    @Test
    public void testSetItemTemp() {
        System.out.println("setItemTemp");
        Item itemTemp = null;
        ProjetoFinal instance = new ProjetoFinal();
        instance.setItemTemp(itemTemp);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSubItemTemp method, of class ProjetoFinal.
     */
    @Test
    public void testGetSubItemTemp() {
        System.out.println("getSubItemTemp");
        ProjetoFinal instance = new ProjetoFinal();
        Subitem expResult = null;
        Subitem result = instance.getSubItemTemp();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSubItemTemp method, of class ProjetoFinal.
     */
    @Test
    public void testSetSubItemTemp() {
        System.out.println("setSubItemTemp");
        Subitem subItemTemp = null;
        ProjetoFinal instance = new ProjetoFinal();
        instance.setSubItemTemp(subItemTemp);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}