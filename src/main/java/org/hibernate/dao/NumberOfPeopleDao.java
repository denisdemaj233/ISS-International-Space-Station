package org.hibernate.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.hibernate.config.Jpa;
import org.hibernate.model.NumberOfPeople;

public class NumberOfPeopleDao {

    public void savePeopleInSpace(NumberOfPeople numberOfPeople) {

        EntityTransaction transaction= null;

        try (EntityManager em= Jpa.getEntityManager()){

            transaction = em.getTransaction();
            transaction.begin();
            em.persist(numberOfPeople);
            transaction.commit();

        } catch (Exception e) {

            if (transaction != null && transaction.isActive()){
                transaction.rollback();
            }
        }
    }
}
