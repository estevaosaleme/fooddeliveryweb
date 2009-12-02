
package br.com.fdw.negocio.processo;

import br.com.fdw.negocio.entidades.Cep;
import br.com.fdw.persistencia.dao.CepDAO;
import java.util.List;

/**
 * Os processos devem fazer a ponte entre a fachada e a camada de persistência
 */
public class CepProcess {

    private CepDAO dao;

    public CepProcess()
    {
        this.dao = new CepDAO();
    }


    public List<Cep> getAll() {
        return this.dao.getAll();
    }
}
