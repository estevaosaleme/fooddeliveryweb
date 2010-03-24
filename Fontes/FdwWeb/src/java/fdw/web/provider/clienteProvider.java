/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fdw.web.provider;

import br.com.fdw.negocio.entidades.Cliente;
import com.sun.data.provider.impl.ObjectListDataProvider;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pedro
 */
public class clienteProvider extends ObjectListDataProvider {

    private List<Cliente> cliente;

    public clienteProvider() {
        cliente = new ArrayList<Cliente>();
        // a linha abaixo existe apenas para que possamos desenhar a tabela na IDE
        cliente.add(new Cliente());
        setList(cliente);
    }
}