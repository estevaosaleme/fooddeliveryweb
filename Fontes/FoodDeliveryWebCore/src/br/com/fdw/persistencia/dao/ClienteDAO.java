/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.fdw.persistencia.dao;

import br.com.fdw.negocio.entidades.Cliente;
import br.com.fdw.persistencia.util.ConnFactory;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 *
 * @author Paulo Daniel
 */
public class ClienteDAO extends GenericDAO<Cliente> {

    public ClienteDAO() {
        super(Cliente.class);
    }

    public Cliente getByNumeroCpf(String numeroCpf) {
        String namedQuery = "Cliente.findByNumeroCpf";
        Query query = ConnFactory.getEntityManager().createNamedQuery(namedQuery);
        query.setParameter("numeroCpf", numeroCpf);
        try {
            return (Cliente)query.getSingleResult();
        } catch (NoResultException noResultException) {
            return null;
        }
    }
}
