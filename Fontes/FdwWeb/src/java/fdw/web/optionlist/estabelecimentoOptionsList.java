/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fdw.web.optionlist;

import br.com.fdw.negocio.entidades.Estabelecimento;
import com.sun.webui.jsf.model.Option;
import com.sun.webui.jsf.model.OptionsList;
import java.util.List;

/**
 *
 * @author pedro
 */
public class estabelecimentoOptionsList extends OptionsList {

    private Option[] opcoes;

    public estabelecimentoOptionsList() {
        Estabelecimento estabelecimento = new Estabelecimento();
        opcoes = new Option[1];
        // a linha abaixo existe apenas para que possamos desenhar a tabela na IDE
        opcoes[0] = new Option(estabelecimento);
        setOptions(opcoes);
    }

    public void setList(List<Estabelecimento> lista) {
        if (lista != null) {
            opcoes = new Option[lista.size() + 1];
            int i = 0;
            opcoes[i++] = new Option(null, "- selecione um estabelecimento -");
            for (Estabelecimento estabelecimento : lista) {
                opcoes[i++] = new Option(estabelecimento.getCodigoEstabelecimento(),estabelecimento.getNomeFantasia());
            }
            setOptions(opcoes);
        } else {
            setOptions(new Option[0]);
        }
        setSelectedValue(this.opcoes[0]);
    }
}
