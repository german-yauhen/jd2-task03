package by.htp.hermanovich.service.newsService;

import by.htp.hermanovich.pojo.News;
import by.htp.hermanovich.service.exception.ServiceException;
import java.util.List;

/**
 * This interface describes only names of methods meant for invocation corresponding methods from Dao module.
 * @author Hermanovich Yauheni
 */
public interface NewsService {

    /**
     * This method returns instance of the News object as a result of execution method from Dao module
     * @param id an unigue identifier of the object
     * @return an instance of News object
     * @throws ServiceException
     */
    News getNewsById(Integer id) throws ServiceException;

    /**
     * This method accepts instance of the News object and transmits it to method from Dao module
     * to save it to the corresponding database table
     * @param news an instance of the News object which will be created
     * @throws ServiceException
     */
    void createNews(News news) throws ServiceException;

    /**
     * This method accepts instance of the News object and transmits it to method from Dao module
     * to delete it from the corresponding database table
     * @param news an instance of the News object which will be deleted
     * @throws ServiceException
     */
    void deleteNews(News news) throws ServiceException;

    /**
     * This method invokes corresponding method from Dao module to get a collection of the news
     * @return a collection of instances of the News objects
     * @throws ServiceException
     */
    List<News> getAllNews() throws ServiceException;

    /**
     * This method accepts instance of the News object and transmits it to method from Dao module
     * to update it in the corresponding database table
     * @param news an instance of the News object which will be updated
     * @throws ServiceException
     */
    void updateNews(News news) throws ServiceException;
}