package org.hibernate;

import org.hibernate.config.Jpa;
import jakarta.persistence.EntityManager;
import org.hibernate.dao.UserDao;

public class MainPersistance {
    public static void main(String[] args) {
        User user= new User();
        user.setName("test");
        UserDao userDao = new UserDao();
        userDao.saveUser(user);

    }
}
