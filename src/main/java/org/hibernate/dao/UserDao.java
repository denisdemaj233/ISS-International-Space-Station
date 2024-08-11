package org.hibernate.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.hibernate.User;
import org.hibernate.config.Jpa;

public class UserDao {

        public void saveUser(User user){

            EntityTransaction transaction = null;
            try (EntityManager em = Jpa.getEntityManager()) {
                transaction = em.getTransaction();
                transaction.begin();
                em.persist(user);
                transaction.commit();
            } catch (Exception e) {
                if (transaction != null && transaction.isActive()) {
                  transaction.rollback();
                }
            }
        }

    }

