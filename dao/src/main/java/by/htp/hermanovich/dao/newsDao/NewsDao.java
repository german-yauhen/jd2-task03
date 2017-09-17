package by.htp.hermanovich.dao.newsDao;

import by.htp.hermanovich.dao.exception.DaoException;
import by.htp.hermanovich.pojo.News;
import java.util.List;

/**
 * This interface describes only names of methods meant for taking action on news entity
 * using connections to corresponding database table.
 * @author Hermanovich Yauheni
 */
public interface NewsDao {

    /**
     * This method reads and returns instance of the News object from corresponding database table
     * @param id an unigue identifier of the object
     * @return an instance of News object
     * @throws DaoException
     */
    News getNewsById(Integer id) throws DaoException;

    /**
     * This method saves an instance of the News object to corresponding database table
     * @param news an instance of the News object which will be saved
     * @throws DaoException
     */
    void saveNews(News news) throws DaoException;

    /**
     * This method deletes an instance of the News object from corresponding database table
     * @param newsId an id of the News in the database table object which will be deleted
     * @throws DaoException
     */
    void deleteNews(Integer newsId) throws DaoException;

    /**
     * This method reads all instances of the News objects from corresponding database table
     * @return a collection of instances of the News objects
     * @throws DaoException
     */
    List<News> getAllNews() throws DaoException;
}