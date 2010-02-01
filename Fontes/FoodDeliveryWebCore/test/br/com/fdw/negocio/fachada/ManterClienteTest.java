/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.fdw.negocio.fachada;

import br.com.fdw.negocio.entidades.Cep;
import br.com.fdw.negocio.entidades.Cliente;
import java.sql.Date;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Paulo Daniel
 */
public class ManterClienteTest {

    public ManterClienteTest() {
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

    @Test
    public void testListarClientes() {
        System.out.println("ListarClientes");
        ManterCliente instance = new ManterCliente();
        List<Cliente> result = instance.listarClientes();
        for (int i=0; i<result.size(); i++) {
            System.out.println(result.get(i).getNomeCliente());
        }
        assertTrue("Ok", result.size() > 0);
    }

    @Test
    public void testListarCliente() {
        System.out.println("ListarCliente");
        ManterCliente instance = new ManterCliente();
        Cliente result = instance.listarCliente(1);
        System.out.println(result.getNomeCliente());
        assertNotNull(result);
    }

    @Test
    public void testIncluirCliente() {
        System.out.println("IncluirCliente");
        ManterCep instanceCep = new ManterCep();
        Cep cep = instanceCep.listarCep(1);
        ManterCliente instance = new ManterCliente();
        Cliente cliente = new Cliente();

        Date dataNascimento = new Date(2010, 01, 28);

        cliente.setCep(cep);
        cliente.setDataNascimento(dataNascimento);
        cliente.setEmail("email@email.com.br");
        cliente.setEndereco("Rua Cliente");
        cliente.setNomeCliente("Cliente");
        cliente.setNumeroCelular("8841-7154");
        cliente.setNumeroCpf("7234568654");
        cliente.setNumeroTelefoneFixo("3422-7465");
        cliente.setPontoReferencia("Asa Norte");
        cliente.setSenha("123456");
        cliente.setSexo('F');
        cliente.setStatus('A');
        
        Cliente result = instance.incluirCliente(cliente);
        assertNotNull(result);
    }

    @Test
    public void testAlterarCliente() {
        System.out.println("AlterarCliente");
        ManterCliente instance = new ManterCliente();
        Cliente cliente = instance.listarCliente(2);
        cliente.setEndereco("Rua de teste");
        cliente.setNumeroCelular("9982-7536");
        Cliente result = instance.alterarCliente(cliente);
        assertNotNull(result);
    }

/*
    @Test
    public void testRemoverCliente() {
        System.out.println("RemoverCliente");
        ManterCliente instance = new ManterCliente();
        Boolean result = instance.excluirCliente(3);
        assertNotSame(true,result);
    }
 */
}
