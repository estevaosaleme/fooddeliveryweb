
package br.com.fdw.negocio.fachada;

import br.com.fdw.negocio.entidades.Cep;
import br.com.fdw.negocio.processo.CepProcess;
import java.util.List;

/**
 * métodos devem ser públicos
 * na fachada deve conter os casos de uso
 * Padrão: nome dos métodos são os nomes dos casos de uso em português
 */
public class ManterCep {

    private CepProcess cepProcess;

    public ManterCep()
    {
        this.cepProcess = new CepProcess();
    }

    public List<Cep> listarCeps()
    {
        return this.cepProcess.getAll();
    }
    
    public Cep listarCep(int codigoCep)
    {
        return this.cepProcess.getCep(codigoCep);
    }

    public Cep incluirCep(Cep cep)
    {
        return this.cepProcess.setCep(cep);
    }

    public Cep alterarCep(Cep cep)
    {
        return this.cepProcess.updateCep(cep);
    }

    public boolean excluirCep(int codigoCep)
    {
        return this.cepProcess.removeCep(codigoCep);
    }


}
