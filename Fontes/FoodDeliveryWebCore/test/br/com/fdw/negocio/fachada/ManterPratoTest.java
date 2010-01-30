package br.com.fdw.negocio.fachada;

import br.com.fdw.negocio.entidades.Prato;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class ManterPratoTest {

    public ManterPratoTest() {
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
    public void testCRUD() {
        System.out.println("IncluiAlteraeExcluiPrato");
        Prato retorno = null;
        ManterPrato instance = new ManterPrato();
        // Testa listarPratos
        List lista = instance.listarPratos();
        if (lista.size() >0){
            int codigoPrato = ((Prato)lista.get(0)).getCodigoPrato();
            // Testa listarPrato
            Prato result = instance.consultarPrato(codigoPrato);
            if (result == null) {
                fail ("Obs: listarPrato nao retornou o prato de ID:"
                        +Integer.toString(codigoPrato) );
            }
            Prato aIncluir = new Prato();
            aIncluir.setNomePrato(result.getNomePrato()+"Teste");
            aIncluir.setCardapio(result.getCardapio());
            aIncluir.setDescricaoPrato(result.getDescricaoPrato());
            aIncluir.setTamanho(result.getTamanho());
            aIncluir.setValorUnitario(result.getValorUnitario());

            // Testa inclui
            Prato retorno1 = instance.incluirPrato(aIncluir);
            if (retorno1 == null) {
                fail ("Obs: Retorno do metodo de inclusao é nulo." );
            }
            // Testa pesquisa por nome e cardapio
            if (instance.pesquisarPrato(
                    result.getNomePrato()+"Teste",
                    result.getCardapio().getCodigoCardapio())==null){
                fail ("Obs: Novo prato nao foi incluido.");
            }
            retorno1.setNomePrato(
                    result.getNomePrato()+"TesteAlt");
            // Testa altera
            retorno = instance.atualizarPrato(retorno1);
            if (retorno == null) {
                fail ("Obs: Retorno do metodo de alteracao é nulo.");
            }
            if (instance.pesquisarPrato(
                    result.getNomePrato()+"TesteAlt",
                    result.getCardapio().getCodigoCardapio())==null){
                fail ("Obs: Prato com a alteracao não foi encontrado.");
            }
             // Testa exclui
            instance.excluirPrato(retorno.getCodigoPrato());
            if (instance.pesquisarPrato(
                    result.getNomePrato()+"TesteAlt",
                    result.getCardapio().getCodigoCardapio())!=null){
                fail ("Obs: Prato nao foi excluido.");
            }

        }
        else{
            fail ("Obs: Nenhum registro retornado, " +
                    "precisa existir um registro.");
        }
    }

    @Test
    public void testValidacaoIncluirAlterarPrato(){
        System.out.println("ValidacaoIncluirAlterar");
        ManterPrato instance = new ManterPrato();
        // Testa listarPratos
        List lista = instance.listarPratos();

        if (lista.size() >0){
            Prato NovoPrato = new Prato();
            NovoPrato.setNomePrato(((Prato)lista.get(0)).getNomePrato());
            NovoPrato.setCardapio(((Prato)lista.get(0)).getCardapio());
            try{
                instance.incluirPrato(NovoPrato);
                fail ("Obs: Falha, inserido prato com mesmo " +
                        "nome e cardapio que o primeiro, ou outra falha.");
            }
            catch(RuntimeException ex){
                // se falhou, passou no teste
            }
        }
        else{
            fail ("Obs: Nenhum registro retornado, " +
                    "precisa existir um registro.");
        }
    }
}