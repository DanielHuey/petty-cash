package org.pahappa.systems.pettycash.config;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class SessionConfiguration {

    private final static SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            AnnotationConfiguration configuration = new AnnotationConfiguration();
            configuration.configure(); // Loads hibernate.cfg.xml configuration

            // Add annotated classes here
//            configuration.addAnnotatedClass(User.class);
//            configuration.addAnnotatedClass(Dependant.class);
            return configuration.buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Failed to create SessionFactory: " + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        getSessionFactory().close();
    }
}
