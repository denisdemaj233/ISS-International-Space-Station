package org.hibernate.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.hibernate.config.Jpa;
import org.hibernate.model.SpaceResponse;

public class SpaceDao {
    public void saveSpace(SpaceResponse spaceResponse){

        EntityTransaction transaction = null;
        try (EntityManager em = Jpa.getEntityManager()) {
            transaction = em.getTransaction();
            transaction.begin();
            em.persist(spaceResponse);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
        }
    }
}
