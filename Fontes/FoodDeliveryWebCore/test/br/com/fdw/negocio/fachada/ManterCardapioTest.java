/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.fdw.negocio.fachada;

import br.com.fdw.negocio.entidades.Cardapio;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author pedro
 */
public class ManterCardapioTest {

    public ManterCardapioTest() {
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
     * Teste com todos os CRUD do MantemCardapio
     */
    @Test
    public void testCRUD() {
        System.out.println("IncluiAlteraeExcluiCardapio");
        Cardapio retorno = null;
        ManterCardapio instance = new ManterCardapio();
        // Testa listarCardapios
        List lista = instance.listarCardapios();
        if (lista.size() >0){
            int codigoCardapio = ((Cardapio)lista.get(0)).getCodigoCardapio();
            // Testa listarCardapio
            Cardapio result = instance.listarCardapio(codigoCardapio);
            if (result == null) {
                fail ("Obs: listarCardapio nao retornou o cardapio de ID:"
                        +Integer.toString(codigoCardapio) );
            }
            Cardapio aIncluir = new Cardapio();
            aIncluir.setNomeCardapio(result.getNomeCardapio()+"Teste");
            aIncluir.setEstabelecimento(result.getEstabelecimento());
            // Testa inclui
            Cardapio retorno1 = instance.incluirCardapio(aIncluir);
            if (retorno1 == null) {
                fail ("Obs: Retorno do metodo de inclusao é nulo." );
            }
            if (instance.pesquisarCardapio(
                    result.getNomeCardapio()+"Teste")==null){
                fail ("Obs: Novo cardapio nao foi incluido.");
            }
            retorno1.setNomeCardapio(
                    result.getNomeCardapio()+"TesteAlt");
            // Testa altera
            retorno = instance.alterarCardapio(retorno1);
            if (retorno == null) {
                fail ("Obs: Retorno do metodo de alteracao é nulo.");
            }
            if (instance.pesquisarCardapio(
                    result.getNomeCardapio()+"TesteAlt")==null){
                fail ("Obs: Cardapio com a alteracao não foi encontrado.");
            }
             // Testa exclui
            instance.excluirCardapio(retorno);
            if (instance.pesquisarCardapio(
                    result.getNomeCardapio()+"TesteAlt")!=null){
                fail ("Obs: Cardapio nao foi excluido.");
            }
        
        }
        else{
            fail ("Obs: Nenhum registro retornado, " +
                    "precisa existir um registro.");
        }
    }

    @Test
    public void testValidacaoIncluirAlterarCardapio(){
        System.out.println("ValidacaoIncluirAlterar");
        ManterCardapio instance = new ManterCardapio();
        // Testa listarCardapios
        List lista = instance.listarCardapios();

        if (lista.size() >0){
            String NomeCardapio = ((Cardapio)lista.get(0)).getNomeCardapio();
            Cardapio NovoCardapio = new Cardapio();
            NovoCardapio.setNomeCardapio(NomeCardapio);
            NovoCardapio.setEstabelecimento(((Cardapio)lista.get(0)).getEstabelecimento());
            try{
                instance.incluirCardapio(NovoCardapio);
                fail ("Obs: Falha, inserido cardapio com mesmo " +
                        "nome que o primeiro ou outra falha.");
            }
            catch(RuntimeException ex){
                // se falhou, passou no teste
            }
        }
    }

}