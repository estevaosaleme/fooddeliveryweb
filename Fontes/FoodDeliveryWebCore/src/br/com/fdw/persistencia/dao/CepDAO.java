package br.com.fdw.persistencia.dao;

import br.com.fdw.negocio.entidades.Cep;
import br.com.fdw.persistencia.util.ConnFactory;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 * DAOs são responsáveis pelo acesso ao banco
 * A maioria das operações são feitas por métodos herdados
 * Qualquer método extra para acesso ao banco, que não seja genérico, deve estar contido nesta classe
 * Padrão: nomes de métodos em inglês
 */
public class CepDAO extends GenericDAO<Cep> {

    public CepDAO() {
        super(Cep.class);
    }

    public Cep getByNumeroCep(String numeroCep)
    {
        String namedQuery = "Cep.findByNumeroCep";
        Query query = ConnFactory.getEntityManager().createNamedQuery(namedQuery);
        query.setParameter("numeroCep", numeroCep);
        try
        {
            return (Cep)query.getSingleResult();
        }
        catch (NoResultException noResultException)
        {
            return null;
        }
    }
}