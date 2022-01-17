package org.example.db;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CountryRepository {
    private static final String PU_NAME = "langDB";
    private static EntityManagerFactory emf = null;
    private static EntityManager em = null;

    private void init() {
        try {
            if (emf == null)
                emf = Persistence.createEntityManagerFactory(PU_NAME);
        } catch (Exception e) {
            throw new DbException("Failed to create EMF", e);
        }

        try {
            if (em == null)
                em = emf.createEntityManager();
        } catch (Exception e) {
            throw new DbException("Failed to create EM", e);
        }
    }

    public void save(CountryEntity country) {
        init();

        try {
            em.getTransaction().begin();
            em.persist(country);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new DbException("Failed to save country", e);
        }
    }
}
