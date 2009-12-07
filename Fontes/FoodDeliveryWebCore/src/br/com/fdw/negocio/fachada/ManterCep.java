
package br.com.fdw.negocio.fachada;

import br.com.fdw.negocio.entidades.Cep;
import br.com.fdw.negocio.processo.CepProcess;
import java.util.List;

/**
 * métodos devem ser públicos
 * na fachada deve conter os casos de uso
 */
public class ManterCep {

    public List<Cep> listarCeps()
    {
        CepProcess cepProcess = new CepProcess();
        return cepProcess.getAll();
    }
}
