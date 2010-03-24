/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fdw.web.provider;

import br.com.fdw.negocio.entidades.Estabelecimento;
import com.sun.data.provider.impl.ObjectListDataProvider;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pedro
 */
public class estabelecimentoProvider extends ObjectListDataProvider {

    private List<Estabelecimento> estabelecimento;

    public estabelecimentoProvider() {
        estabelecimento = new ArrayList<Estabelecimento>();
        // a linha abaixo existe apenas para que possamos desenhar a tabela na IDE
        estabelecimento.add(new Estabelecimento());
        setList(estabelecimento);
    }
}
