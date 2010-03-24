/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fdw.web.provider;

import br.com.fdw.negocio.entidades.Prato;
import com.sun.data.provider.impl.ObjectListDataProvider;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pedro
 */
public class pratoProvider extends ObjectListDataProvider {

    private List<Prato> prato;

    public pratoProvider() {
        prato = new ArrayList<Prato>();
        // a linha abaixo existe apenas para que possamos desenhar a tabela na IDE
        prato.add(new Prato());
        setList(prato);
    }
}
