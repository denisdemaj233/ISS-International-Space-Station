package org.hibernate.config;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;


public class Jpa {
    private static final EntityManagerFactory entityManagerFactory = buildEntityFactoryManager();

    private static EntityManagerFactory buildEntityFactoryManager() {

        try {
            return Persistence.createEntityManagerFactory("pu");
        }catch (Exception e){
           throw new ExceptionInInitializerError(e);
        }

    }

    public static EntityManager getEntityManager(){

        return entityManagerFactory.createEntityManager();

    }

    public static void shutdown(){
        if(entityManagerFactory != null && entityManagerFactory.isOpen()){
                entityManagerFactory.close();
        }
    }


}
