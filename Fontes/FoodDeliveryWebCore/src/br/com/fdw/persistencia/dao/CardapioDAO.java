package br.com.fdw.persistencia.dao;

import br.com.fdw.negocio.entidades.Cardapio;
import br.com.fdw.persistencia.util.ConnFactory;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;

public class CardapioDAO extends GenericDAO<Cardapio> {

    public CardapioDAO() {
        super(Cardapio.class);
    }

    public Cardapio getByNomeCardapio(String nomeCardapio){
        String namedQuery = "Cardapio.findByNomeCardapio";
        Query query = ConnFactory.getEntityManager().createNamedQuery(namedQuery);
        query.setParameter("nomeCardapio", nomeCardapio);
        try{
            
            List<Cardapio> listaCar = (List<Cardapio>)query.getResultList();
            if (listaCar.size() == 1)
                return listaCar.get(0);
            else if (listaCar.size() > 0)
                throw new RuntimeException("Mais de um mesmo nome de cardapio no banco");
            else
                return null;
        }
        catch (NoResultException noResultException){
            return null;
        }
    }

    public List<Cardapio> listarByCodigoEstabelecimento(int codigoEstabelecimento) {
        String namedQuery = "Cardapio.listByCodigoEstabelecimento";
        Query query = ConnFactory.getEntityManager().createNamedQuery(namedQuery);
        query.setParameter("codigoEstabelecimento", codigoEstabelecimento);
        try {
            return (List<Cardapio>)query.getResultList();
        } catch (NoResultException noResultException) {
            return null;
        }
    }
}
