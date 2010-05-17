/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fdw.web.provider;

import com.sun.data.provider.impl.ObjectListDataProvider;
import fdw.web.portal.pratoQuantidade;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pedro
 */
public class pratoQuantidadeProvider extends ObjectListDataProvider {

    private List<pratoQuantidade> pratoQuantidade;

    public pratoQuantidadeProvider() {
        pratoQuantidade = new ArrayList<pratoQuantidade>();
        pratoQuantidade.add(new pratoQuantidade());
        setList(pratoQuantidade);
    }
}