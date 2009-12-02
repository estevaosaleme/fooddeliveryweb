
package br.com.fdw.persistencia.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class ConnFactory {

    private static EntityManagerFactory emf;
    private static EntityManager em;

    private static EntityManagerFactory getEntityManagerFactory()
    {
        if(ConnFactory.emf == null)
        {
            ConnFactory.emf = javax.persistence.Persistence.createEntityManagerFactory("FoodDeliveryWebCorePU");
        }

        return ConnFactory.emf;
    }

    public static EntityManager getEntityManager()
    {
        if(ConnFactory.em == null)
        {
            ConnFactory.em = ConnFactory.getEntityManagerFactory().createEntityManager();
        }

        return ConnFactory.em;
    }
}
