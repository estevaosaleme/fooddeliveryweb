
package br.com.fdw.persistencia.dao;

import br.com.fdw.negocio.entidades.PersistentObject;
import br.com.fdw.persistencia.util.ConnFactory;
import java.util.List;
import javax.persistence.EntityManager;

public abstract class GenericDAO<T extends PersistentObject> {

    private Class<T> clazz;

    public GenericDAO(Class<T> clazz) {
        this.clazz = clazz;
    }

    private Class<T> getClazz() {
        return this.clazz;
    }

    private Class<T> getMyClass() {
        return this.getClazz();
    }

    public T get(Object pk) {
        return ConnFactory.getEntityManager().getReference(this.getMyClass(), pk);
    }

    public T save(T obj) {

        EntityManager em = ConnFactory.getEntityManager();
        em.getTransaction().begin();

        try {
            obj = em.merge(obj);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
            obj = null;
            throw  new Exception("Falha ao salvar "+e.getMessage());
        } finally {
            return obj;
        }
    }

    public boolean remove(Object pk) {
        return this.removeObject(this.get(pk));
    }

    public boolean removeObject(T obj) {
        boolean retorno = false;
        EntityManager em = ConnFactory.getEntityManager();
        em.getTransaction().begin();

        try {
            em.remove(obj);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
            throw  new Exception("Falha ao salvar "+e.getMessage());
        } finally {
            return retorno;
        }
    }

    public List<T> getAll() {
        final Class<T> myClass = this.getMyClass();

        String namedQuery = myClass.getSimpleName() + ".findAll";
        List<T> lista = ConnFactory.getEntityManager().createNamedQuery(namedQuery).getResultList();
        return lista;
    }
}