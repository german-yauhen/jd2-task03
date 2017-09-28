package by.htp.hermanovich.util;

import by.htp.hermanovich.constant.Constants;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * This class describes actions to create the Hibernate session factory instance.
 * The factory provides creation hibernate-sessions. Session Factory is the thread-save
 * object that needs to create in a single instance. Session Factory is initialized in the static block.
 * Configuration class is used to load Hibernate configuration from hibernate.cfg.xml file.
 * @author Hermanovich Yauheni
 */
public class HibernateUtil {

    private static final Logger logger = Logger.getLogger(HibernateUtil.class);
    private static final SessionFactory sessionFactory;

    static {
        try {
            sessionFactory = new Configuration().configure("/hibernate.cfg.xml").buildSessionFactory();
        } catch (Throwable exc) {
            logger.error(Constants.INIT_SESSION_FACTORY_ERROR + Constants.HIBERNATE_EXCEPTION + exc);
            throw new ExceptionInInitializerError(exc);
        }
    }

    /**
     * This method gets Hibernate session factory that was initialized at application startup.
     * @return Hibernate session factory
     */
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}