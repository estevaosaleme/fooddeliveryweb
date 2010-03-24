/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fdw.web.provider;

import br.com.fdw.negocio.entidades.Pedido;
import com.sun.data.provider.impl.ObjectListDataProvider;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pedro
 */
public class pedidoProvider extends ObjectListDataProvider {

    private List<Pedido> pedido;

    public pedidoProvider() {
        pedido = new ArrayList<Pedido>();
        // a linha abaixo existe apenas para que possamos desenhar a tabela na IDE
        pedido.add(new Pedido());
        setList(pedido);
    }
}
