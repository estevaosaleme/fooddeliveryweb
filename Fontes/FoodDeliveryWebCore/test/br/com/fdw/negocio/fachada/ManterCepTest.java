
package br.com.fdw.negocio.fachada;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class ManterCepTest {

    public ManterCepTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of ListarCeps method, of class ManterCep.
     */
    @Test
    public void testListarCeps() {
        System.out.println("ListarCeps");
        ManterCep instance = new ManterCep();
        List expResult = new ArrayList();
        List result = instance.ListarCeps();
        // banco deve estar vazio para passar no teste de conexão e listagem
        assertEquals(expResult.size(), result.size());
    }

}