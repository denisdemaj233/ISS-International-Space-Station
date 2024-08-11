package org.hibernate;

import org.hibernate.dao.UserDao;

public class MainPersistence {
    public static void main(String[] args) {
        User user= new User();
        user.setId(1);
        user.setName("test");

        UserDao userDao = new UserDao();
        userDao.saveUser(user);


    }
}
