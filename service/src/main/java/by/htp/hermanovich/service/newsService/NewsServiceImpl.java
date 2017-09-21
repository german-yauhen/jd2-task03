package by.htp.hermanovich.service.newsService;

import by.htp.hermanovich.constant.Constants;
import by.htp.hermanovich.dao.exception.DaoException;
import by.htp.hermanovich.dao.newsDao.NewsDao;
import by.htp.hermanovich.pojo.News;
import by.htp.hermanovich.service.exception.ServiceException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
 * This class describes implementation of the methods from NewsService interface meant for execution
 * corresponding methods from Dao module
 * @author Hermanovich Yauheni
 */
@Service("newsService")
public class NewsServiceImpl implements NewsService {

    @Autowired
    private NewsDao newsDao;

    private static final Logger logger = Logger.getLogger(NewsServiceImpl.class);

    /**
     * This method returns instance of the News object as a result of execution method from Dao module
     * @param id an unigue identifier of the object
     * @return an instance of News object
     * @throws ServiceException
     */
    @Override
    public News getNewsById(Integer id) throws ServiceException {
        try {
            return newsDao.getNewsById(id);
        } catch (DaoException e) {
            logger.error(e);
            throw new ServiceException(Constants.SERVICE_DAO_ERROR, e);
        }
    }

    /**
     * This method accepts instance of the News object and transmits it to method from Dao module
     * to save it to the corresponding database table
     * @param news an instance of the News object which will be created
     * @throws ServiceException
     */
    @Override
    public void createNews(News news) throws ServiceException {
        try {
            newsDao.saveNews(news);
        } catch (DaoException e) {
            logger.error(e);
            throw new ServiceException(Constants.SERVICE_DAO_ERROR, e);
        }
    }

    /**
     * This method accepts instance of the News object and transmits it to method from Dao module
     * to delete it from the corresponding database table
     * @param news an instance of the News object which will be deleted
     * @throws ServiceException
     */
    @Override
    public void deleteNews(News news) throws ServiceException {
        try {
            newsDao.deleteNews(news);
        } catch (DaoException e) {
            logger.error(e);
            throw new ServiceException(Constants.SERVICE_DAO_ERROR, e);
        }
    }

    /**
     * This method invokes corresponding method from Dao module to get a collection of the news
     * @return a collection of instances of the News objects
     * @throws ServiceException
     */
    @Override
    @Transactional(readOnly = true)
    public List<News> getAllNews() throws ServiceException {
        try {
            return newsDao.getAllNews();
        } catch (DaoException e) {
            logger.error(e);
            throw new ServiceException(Constants.SERVICE_DAO_ERROR, e);
        }
    }

    /**
     * This method accepts instance of the News object and transmits it to method from Dao module
     * to update it in the corresponding database table
     * @param news an instance of the News object which will be updated
     * @throws ServiceException
     */
    @Override
    public void updateNews(News news) throws ServiceException {
        try {
            newsDao.updateNews(news);
        } catch (DaoException e) {
            logger.error(e);
            throw new ServiceException(Constants.SERVICE_DAO_ERROR, e);
        }
    }
}