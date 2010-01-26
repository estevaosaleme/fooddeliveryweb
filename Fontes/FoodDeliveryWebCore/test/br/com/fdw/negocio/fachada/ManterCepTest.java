
package br.com.fdw.negocio.fachada;

import br.com.fdw.negocio.entidades.Cep;
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
        List result = instance.listarCeps();
        assertTrue("Ok", result.size() > 0);
    }

    @Test
    public void testListarCep() {
        System.out.println("ListarCep");
        ManterCep instance = new ManterCep();
        Cep result = instance.listarCep(1);
        assertNotNull(result);
    }

    @Test
    public void testIncluirCep() {
        System.out.println("IncluirCep");
        ManterCep instance = new ManterCep();
        Cep cep = new Cep();
        cep.setNomeBairro("Praia do Canto");
        cep.setNomeCidade("Vitória");
        cep.setNomeLogradouro("Rua Aleixo Neto");
        cep.setNumeroCep("29051-000");
        cep.setSiglaEstado("ES");

        Cep result = instance.incluirCep(cep);

        assertNotNull(result);
    }

    @Test
    public void testAlterarCep() {
        System.out.println("AlterarCep");
        ManterCep instance = new ManterCep();
        Cep cep = instance.listarCep(2);
        cep.setNomeLogradouro("Rua Chapot Prevot");
        cep.setNumeroCep("29051-005");

        Cep result = instance.alterarCep(cep);

        assertNotNull(result);
    }

}