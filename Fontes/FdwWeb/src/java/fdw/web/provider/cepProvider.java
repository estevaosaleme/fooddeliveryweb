/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fdw.web.provider;

import com.sun.data.provider.impl.ObjectListDataProvider;
import java.util.ArrayList;
import java.util.List;
import br.com.fdw.negocio.entidades.Cep;

/**
 *
 * @author pedro
 */
public class cepProvider extends ObjectListDataProvider {

    private List<Cep> cep;

    public cepProvider() {
        cep = new ArrayList<Cep>();
        // a linha abaixo existe apenas para que possamos desenhar a tabela na IDE
        cep.add(new Cep());
        setList(cep);
    }
}
