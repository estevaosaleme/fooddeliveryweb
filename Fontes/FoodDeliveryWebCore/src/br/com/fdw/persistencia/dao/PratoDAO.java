package br.com.fdw.persistencia.dao;

import br.com.fdw.negocio.entidades.Prato;
import br.com.fdw.persistencia.util.ConnFactory;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.NoResultException;

public class PratoDAO extends GenericDAO<Prato> {

    public PratoDAO() {
        super(Prato.class);
    }

    public Prato getByNomeECardapio(String nomePrato, int codigoCardapio)
    {
        String namedQuery = "Prato.findByNomeECardapio";
        Query query = ConnFactory.getEntityManager().createNamedQuery(namedQuery);
        query.setParameter("nomePrato", nomePrato);
        query.setParameter("codigoCardapio", codigoCardapio);
        try{

            List<Prato> listaPrato = (List<Prato>)query.getResultList();
            if (listaPrato.size() == 1)
                return listaPrato.get(0);
            else if (listaPrato.size() > 0)
                throw new RuntimeException("Mais de um mesmo nome de prato no mesmo cardapio no banco");
            else
                return null;
        }
        catch (NoResultException noResultException){
            return null;
        }
    }

    public List<Prato> listarByCodigoCardapio(int codigoCardapio) {
        String namedQuery = "Prato.listByCodigoCardapio";
        Query query = ConnFactory.getEntityManager().createNamedQuery(namedQuery);
        query.setParameter("cardapio", codigoCardapio);
        try {
            return (List<Prato>)query.getResultList();
        } catch (NoResultException noResultException) {
            return null;
        }
    }
}
