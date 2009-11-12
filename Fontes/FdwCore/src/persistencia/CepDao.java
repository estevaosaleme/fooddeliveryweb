/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package persistencia;

import negocio.entidades.Cep;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Roberto
 */
public class CepDao {

private EntityManager em;
public CepDao() {
// criação do entity manager
EntityManagerFactory emf = Persistence.createEntityManagerFactory("FdwCorePU");
em = emf.createEntityManager();
}
public void close() {
em.close();
}
public void inserir(Cep cep) {
em.getTransaction().begin(); // abre uma transação
try {
cep = em.merge(cep); // persiste o objeto e devolveo sincronizado
em.getTransaction().commit(); // encerra a transação
em.refresh(cep); // atualiza a referência do objeto

   } catch (Exception e) {
em.getTransaction().rollback(); // desfaz a transação
}
}
public void atualizar(Cep cep) {
em.getTransaction().begin(); // abre uma transação
try {
cep = em.merge(cep); // persiste o objeto e devolveosincronizado
em.getTransaction().commit(); // encerra a transação
em.refresh(cep); // atualiza a referência do objeto
} catch (Exception e) {
em.getTransaction().rollback(); // desfaz a transação
}
}
public List obterTodos() {
Query qry = em.createQuery("select c.* from Cep c");
return qry.getResultList();
}
}

