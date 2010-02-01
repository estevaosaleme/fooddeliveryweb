/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.fdw.persistencia.dao;

import br.com.fdw.negocio.entidades.Estabelecimento;
import br.com.fdw.persistencia.util.ConnFactory;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 *
 * @author Paulo Daniel
 */
public class EstabelecimentoDAO extends GenericDAO<Estabelecimento>{

    public EstabelecimentoDAO() {
        super(Estabelecimento.class);
    }

    public Estabelecimento getByNumeroCnpj(String numeroCnpj) {
        String namedQuery = "Estabelecimento.findByNumeroCnpj";
        Query query = ConnFactory.getEntityManager().createNamedQuery(namedQuery);
        query.setParameter("numeroCnpj", numeroCnpj);
        try {
            return (Estabelecimento)query.getSingleResult();
        } catch (NoResultException noResultException) {
            return null;
        }
    }
}
