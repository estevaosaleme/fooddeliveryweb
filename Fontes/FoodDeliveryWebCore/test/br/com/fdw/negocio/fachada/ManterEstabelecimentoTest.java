/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.fdw.negocio.fachada;

import br.com.fdw.negocio.entidades.Cep;
import br.com.fdw.negocio.entidades.Estabelecimento;
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
public class ManterEstabelecimentoTest {

    public ManterEstabelecimentoTest() {
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
    public void testListarEstabelecimentos() {
        System.out.println("ListarEstabelecimentos");
        ManterEstabelecimento instance = new ManterEstabelecimento();
        List<Estabelecimento> result = instance.listarEstabelecimentos();
        for (int i=0; i<result.size(); i++) {
            System.out.println(result.get(i).getNomeFantasia());
        }
        assertTrue("Ok", result.size() > 0);
    }

    @Test
    public void testListarEstabelecimento() {
        System.out.println("ListarEstabelecimento");
        ManterEstabelecimento instance = new ManterEstabelecimento();
        Estabelecimento result = instance.listarEstabelecimento(1);
        System.out.println(result.getNomeFantasia());
        assertNotNull(result);
    }

    @Test
    public void testIncluirEstabelecimento() {
        System.out.println("IncluirEstabelecimento");
        ManterCep instanceCep = new ManterCep();
        Cep cep = instanceCep.listarCep(1);
        ManterEstabelecimento instance = new ManterEstabelecimento();
        Estabelecimento estabelecimento = new Estabelecimento();

        estabelecimento.setCep(cep);
        estabelecimento.setCodigoEstabelecimento(10);
        estabelecimento.setEmail("teste@teste.com.br");
        estabelecimento.setEndereco("endereco");
        estabelecimento.setNomeFantasia("Pizzaria do Zé");
        estabelecimento.setNomeRazaoSocial("Pizzaria do Zé Ltda");
        estabelecimento.setNomeResponsavel("Zé");
        estabelecimento.setNumeroCelularResponsavel("(11)3452-9636");
        estabelecimento.setNumeroCnpj("120123240001/99");
        estabelecimento.setNumeroTelefoneFixo("(11)4141-4141");
        estabelecimento.setSlogan("PIZZA É AQUI!!!");
        estabelecimento.setStatus('i');

        Estabelecimento result = instance.incluirEstabelecimento(estabelecimento);
        assertNotNull(result);
    }

    @Test
    public void testAlterarEstabelecimento() {
        System.out.println("AlterarEstabelecimento");
        ManterEstabelecimento instance = new ManterEstabelecimento();
        Estabelecimento estabelecimento = instance.listarEstabelecimento(2);
        estabelecimento.setSlogan("Agora só pizza!!!");
        Estabelecimento result = instance.alterarEstabelecimento(estabelecimento);
        assertNotNull(result);
    }

/*
    @Test
    public void testRemoverEstabelecimento() {
        System.out.println("RemoverEstabelecimento");
        ManterEstabelecimento instance = new ManterEstabelecimento();
        Boolean result = instance.excluirEstabelecimento(3);
        assertNotSame(true,result);
    }
 */
}
