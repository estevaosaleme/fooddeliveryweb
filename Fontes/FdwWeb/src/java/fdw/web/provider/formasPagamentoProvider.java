/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fdw.web.provider;

import br.com.fdw.negocio.entidades.FormaPagamento;
import com.sun.data.provider.impl.ObjectListDataProvider;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pedro
 */
public class formasPagamentoProvider extends ObjectListDataProvider {

    private List<FormaPagamento> formaPagamento;

    public formasPagamentoProvider() {
        formaPagamento = new ArrayList<FormaPagamento>();
        // a linha abaixo existe apenas para que possamos desenhar a tabela na IDE
        formaPagamento.add(new FormaPagamento());
        setList(formaPagamento);
    }
}
