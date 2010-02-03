package br.com.fdw.negocio.fachada;

import br.com.fdw.negocio.entidades.FormaPagamento;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class ManterFormaPagamentoTest {

    public ManterFormaPagamentoTest() {
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
        System.out.println("IncluiAlteraRemoveFormaPagamento");
        FormaPagamento retorno = null;
        ManterFormaPagamento instance = new ManterFormaPagamento();
        
        // Testa ListaFormpasPagamento
        List lista = instance.ListarFormasPagamento();

        if (lista.size() >0){

            int codigoFormaPagamento = ((FormaPagamento)lista.get(0)).getCodigoFormaPagamento();

            // Testa listarCardapio
            FormaPagamento result = instance.listarFormaPagamento(codigoFormaPagamento);

            if (result == null) {
                fail ("Obs: listarCardapio nao retornou o cardapio de ID:"
                        +Integer.toString(codigoFormaPagamento) );
            }
            
            FormaPagamento aIncluir = new FormaPagamento();

            aIncluir.setNomeTipoPagamento(result.getNomeTipoPagamento()+"Teste");

            // Testa incluir
            FormaPagamento retorno1 = instance.incluirFormaPagamento(aIncluir);
            if (retorno1 == null) {
                fail ("Obs: Retorno do metodo de inclusao é nulo." );
            }
            if (instance.pesquisarFormaPagamento(
                    result.getNomeTipoPagamento()+"Teste")==null){
                fail ("Obs: A nova forma de pagamento nao foi incluida.");
            }
            retorno1.setNomeTipoPagamento(
                    result.getNomeTipoPagamento()+"TesteAlt");
            // Testa método alterar
            retorno = instance.alterarFormaPagamento(retorno1);
            if (retorno == null) {
                fail ("Obs: Retorno do metodo de alteracao é nulo.");
            }
            if (instance.pesquisarFormaPagamento(
                    result.getNomeTipoPagamento()+"TesteAlt")==null){
                fail ("Obs: A forma de pagamento não foi encontrada.");
            }
             // Testa método excluir
            instance.excluirFormaPagamento(retorno.getCodigoFormaPagamento());
            if (instance.pesquisarFormaPagamento(
                    result.getNomeTipoPagamento()+"TesteAlt")!=null){
                fail ("Obs: Forma de pagamento não foi excluida.");
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
        ManterFormaPagamento instance = new ManterFormaPagamento();
        // Testa listarCardapios
        List lista = instance.ListarFormasPagamento();

        if (lista.size() >0){
            String nomeFormaPagamento = ((FormaPagamento)lista.get(0)).getNomeTipoPagamento();
            FormaPagamento NovaFormaPagamento = new FormaPagamento();
            NovaFormaPagamento.setNomeTipoPagamento(nomeFormaPagamento);
            try{
                instance.incluirFormaPagamento(NovaFormaPagamento);
                fail ("Obs: Falha, inserida forma de pagamento com mesmo " +
                        "nome que o primeiro ou outra falha.");
            }
            catch(RuntimeException ex){
                // se falhou, passou no teste
            }
        }
    }

}