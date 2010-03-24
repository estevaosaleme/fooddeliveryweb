/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fdw.web.provider;

import br.com.fdw.negocio.entidades.Cardapio;
import com.sun.data.provider.impl.ObjectListDataProvider;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pedro
 */
public class cardapioProvider extends ObjectListDataProvider {

    private List<Cardapio> cardapio;

    public cardapioProvider() {
        cardapio = new ArrayList<Cardapio>();
        // a linha abaixo existe apenas para que possamos desenhar a tabela na IDE
        cardapio.add(new Cardapio());
        setList(cardapio);
    }
}
