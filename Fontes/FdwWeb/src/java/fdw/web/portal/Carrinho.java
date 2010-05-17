/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fdw.web.portal;

import br.com.fdw.negocio.entidades.Prato;
import br.com.fdw.negocio.fachada.ManterFormaPagamento;
import com.sun.webui.jsf.model.Option;
import com.sun.webui.jsf.model.OptionsList;
import fdw.web.provider.pratoQuantidadeProvider;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author pedro
 */
public class Carrinho {

    private HashMap<Integer, pratoQuantidade> produtos;
    private int idEstabelecimento;
    private pratoQuantidadeProvider produtosProvider;
    private OptionsList formaPagamentoOptionsList;


    public Carrinho()
    {
        produtos = new HashMap<Integer, pratoQuantidade>();
        this.setProdutosProvider(new pratoQuantidadeProvider());
        this.setFormaPagamentoOptionsList(new OptionsList());
    }

    public void limpa()
    {
        this.produtos.clear();
        this.AjustaProvider();
        setIdEstabelecimento(0);
    }

    public String Inclui(Prato prato)
    {
        if (produtos.containsKey(prato.getCodigoPrato()))
            return "Produto já está no carrinho";

       int idEstabelecimentoPrato = prato.getCardapio().getEstabelecimento().getCodigoEstabelecimento();
       if (getIdEstabelecimento() != 0 && this.getIdEstabelecimento() != idEstabelecimentoPrato)
            return "Carrinho só pode conter produtos de um estabelecimento";

        produtos.put(prato.getCodigoPrato(), new pratoQuantidade(prato, 1));
        setIdEstabelecimento(idEstabelecimentoPrato);
        this.AjustaProvider();
        return "Produto incluido no carrinho";
    }

    public String Exclui(int codigoPrato)
    {
        if (!produtos.containsKey(codigoPrato))
            return "Produto não está carrinho";

        produtos.remove(codigoPrato);
        if (produtos.size() == 0)
            limpa();
        else
            this.AjustaProvider();
        return "Produto excluido do carrinho";
    }

    public String AlteraQuantidade(int codigoPrato, int quantidade)
    {
        if (!produtos.containsKey(codigoPrato))
            return "Produto não está carrinho";

            produtos.get(codigoPrato).setQuantidade(quantidade);
            this.AjustaProvider();
            return "Quantidade alterada";
    }

    private void AjustaProvider()
    {
        if (this.produtosProvider.getList() != null)
            this.produtosProvider.getList().clear();
        List<pratoQuantidade> pq = new ArrayList<pratoQuantidade>();
        for (pratoQuantidade pratQ : produtos.values()) {
            pq.add(pratQ);
        }
        this.produtosProvider.setList(pq);
    }

    public int QuantidadeItens(){
        return produtos.size();
    }
    /**
     * @return the idEstabelecimento
     */
    public int getIdEstabelecimento() {
        return idEstabelecimento;
    }

    /**
     * @param idEstabelecimento the idEstabelecimento to set
     */
    public void setIdEstabelecimento(int idEstabelecimento) {
        this.idEstabelecimento = idEstabelecimento;
        if (this.idEstabelecimento !=0)
        {
            ManterFormaPagamento facadeForma = new ManterFormaPagamento();
            // fazer pegar a forma.....
            Option[] lstFormaPagamento = {new Option("-- Escolha a forma de pagamento --"), new Option("Dinheiro")};
            getFormaPagamentoOptionsList().setOptions(lstFormaPagamento);
        }
    }

    /**
     * @return the produtosProvider
     */
    public pratoQuantidadeProvider getProdutosProvider() {
        return this.produtosProvider;
    }

    /**
     * @param produtosProvider the produtosProvider to set
     */
    public void setProdutosProvider(pratoQuantidadeProvider produtosProvider) {
        this.produtosProvider = produtosProvider;
    }

        /**
     * @return the fromaPagamentoOptionsList
     */
    public OptionsList getFormaPagamentoOptionsList() {
        return formaPagamentoOptionsList;
    }

    /**
     * @param fromaPagamentoOptionsList the fromaPagamentoOptionsList to set
     */
    public void setFormaPagamentoOptionsList(OptionsList fromaPagamentoOptionsList) {
        this.formaPagamentoOptionsList = fromaPagamentoOptionsList;
    }

}