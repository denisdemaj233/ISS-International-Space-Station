package Hibernate_Utils;


import lombok.Getter;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;

public class Hibernate_Utils {
    @Getter
    private static SessionFactory sessionFactory = createAndGetSessionFactory();
    private static SessionFactory createAndGetSessionFactory() {
        try{

            Properties properties = new Properties();
            properties.load(Hibernate_Utils.class
                    .getClassLoader()
                    .getResourceAsStream("hibernate.properties"));


            Configuration configuration = new Configuration();
            configuration.addProperties(properties);

           // configuration.addAnnotatedClass(Student.class);

            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();


            return configuration.buildSessionFactory(serviceRegistry);
        }catch (Throwable exception){
            throw new RuntimeException(exception);
        }
    }

    public static void setSessionFactory(SessionFactory sessionFactory) {
        Hibernate_Utils.sessionFactory = sessionFactory;
    }
}

