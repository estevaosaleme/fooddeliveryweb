

package br.com.fdw.persistencia.dao;

import br.com.fdw.negocio.entidades.FormaPagamento;
import br.com.fdw.persistencia.util.ConnFactory;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.NoResultException;


public class FormaPagamentoDAO extends GenericDAO<FormaPagamento> {

    public FormaPagamentoDAO() {
        super(FormaPagamento.class);
    }

    public FormaPagamento getByNomeFormaPagamento(String nomeFormaPagamento){
        String namedQuery = "FormaPagamento.findByNomeFormaPagamento";
        Query query = ConnFactory.getEntityManager().createNamedQuery(namedQuery);
        query.setParameter("nomeFormaPagamento", nomeFormaPagamento);
        try{

            List<FormaPagamento> listaCar = (List<FormaPagamento>)query.getResultList();
            if (listaCar.size() == 1)
                return listaCar.get(0);
            else if (listaCar.size() > 0)
                throw new RuntimeException("Mais de um mesmo nome de forma de pagamento no banco");
            else
                return null;
        }
        catch (NoResultException noResultException){
            return null;
        }
    }

}
