package by.htp.hermanovich.dao.newsDao;

import by.htp.hermanovich.constant.Constants;
import by.htp.hermanovich.dao.exception.DaoException;
import by.htp.hermanovich.pojo.News;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * This class describes implementation of the methods from NewsDao interface meant for taking action on news entity
 * using connections to corresponding database table. All method of this class transmitted from the service module and
 * corresponding classes and methods. All methods provides execution with transaction support.
 * @author Hermanovich Yauheni
 */
@Repository("newsDao")
public class NewsDaoImpl implements NewsDao {

    private static final Logger logger = Logger.getLogger(NewsDaoImpl.class);

    @Autowired
    SessionFactory sessionFactory;

    /**
     This method reads and returns instance of the News object from corresponding database table
     * @param id an unigue identifier of the object
     * @return an instance of News object
     * @throws DaoException
     */
    @Override
    public News getNewsById(Integer id) throws DaoException {
        Session session = null;
        News news = null;
        try {
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            news = session.get(News.class, id);
            session.getTransaction().commit();
        } catch (Exception e) {
            logger.error(Constants.EXECUTE_QUERY_TO_DB_ERROR + e);
            session.getTransaction().rollback();
            throw new DaoException(Constants.EXECUTE_QUERY_TO_DB_ERROR, e);
        }
        logger.info(Constants.SUCCESS);
        return news;
    }

    /**
     * This method saves an instance of the News object to corresponding database table
     * @param news an instance of the News object which will be saved
     * @throws DaoException
     */
    @Override
    public void saveNews(News news) throws DaoException {
        Session session = null;
        try {
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            session.save(news);
            session.getTransaction().commit();
        } catch (Exception e) {
            logger.error(Constants.EXECUTE_QUERY_TO_DB_ERROR + e);
            session.getTransaction().rollback();
            throw new DaoException(Constants.EXECUTE_QUERY_TO_DB_ERROR, e);
        }
        logger.info(Constants.SUCCESS);
    }

    /**
     * This method deletes an instance of the News object from corresponding database table
     * @param news an instance of the News object which will be deleted
     * @throws DaoException
     */
    @Override
    public void deleteNews(News news) throws DaoException {
        Session session = null;
        try {
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            session.delete(news);
            session.getTransaction().commit();
        } catch (Exception e) {
            logger.error(Constants.EXECUTE_QUERY_TO_DB_ERROR + e);
            session.getTransaction().rollback();
            throw new DaoException(Constants.EXECUTE_QUERY_TO_DB_ERROR, e);
        }
        logger.info(Constants.SUCCESS);
    }

    /**
     * This method reads all instances of the News objects from corresponding database table
     * @return a collection of instances of the News objects
     * @throws DaoException
     */
    @Override
    public List<News> getAllNews() throws DaoException {
        Session session = null;
        List<News> newsList = null;
        try {
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            newsList = session.createQuery("from News order by dateOfPublication").getResultList();
            session.getTransaction().commit();
        } catch (Exception e) {
            logger.error(Constants.EXECUTE_QUERY_TO_DB_ERROR + e);
            session.getTransaction().rollback();
            throw new DaoException(Constants.EXECUTE_QUERY_TO_DB_ERROR, e);
        }
        logger.info(Constants.SUCCESS);
        return newsList;
    }

    /**
     * This method updates an instance of the News object in corresponding database table
     * @param news an instance of the News object which will be updated
     * @throws DaoException
     */
    @Override
    public void updateNews(News news) throws DaoException {
        Session session = null;
        try {
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            session.saveOrUpdate(news);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e);
            logger.error(Constants.EXECUTE_QUERY_TO_DB_ERROR + e);
            session.getTransaction().rollback();
            throw new DaoException(Constants.EXECUTE_QUERY_TO_DB_ERROR, e);
        }
        logger.info(Constants.SUCCESS);
    }
}