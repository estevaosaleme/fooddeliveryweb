
package br.com.fdw.negocio.processo;

import br.com.fdw.negocio.entidades.Cep;
import br.com.fdw.persistencia.dao.CepDAO;
import java.util.List;

/**
 * Os processos devem fazer a ponte entre a fachada e a camada de persistência
 * São responsáveis pela lógica de negócio (validações, consistências, etc)
 * Padrão: nomes de métodos em inglês
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

    public Cep setCep(Cep cep)
    {
        Cep cepNumeroCep = getByNumeroCep(cep.getNumeroCep());
        if (cepNumeroCep == null)
        {
            return this.dao.save(cep);
        }
        else
        {
            throw new RuntimeException("Já existe um cep cadastrado com este número: "+ cep.getNumeroCep());
        }
    }

    public Cep updateCep(Cep cep)
    {
        Cep cepNumeroCep = getByNumeroCep(cep.getNumeroCep());
        if (cepNumeroCep != null && cep.getCodigoCep() == cepNumeroCep.getCodigoCep())
        {
            return this.dao.save(cep);
        }
        else
        {
            if (cepNumeroCep != null && (!cep.equals(cepNumeroCep) && cepNumeroCep.getCodigoCep() > 0))
            {
                throw new RuntimeException("O número do cep não pode ser alterado pois já existe outro cep com este número.");
            }
            else
            {
                return this.dao.save(cep);
            }
        }
    }

    public Cep getCep(int codigoCep)
    {
        return this.dao.get(codigoCep);
    }

    public boolean removeCep(int codigoCep)
    {
        return this.dao.remove(codigoCep);
    }

    public Cep getByNumeroCep(String numeroCep)
    {
        return this.dao.getByNumeroCep(numeroCep);
    }
}
