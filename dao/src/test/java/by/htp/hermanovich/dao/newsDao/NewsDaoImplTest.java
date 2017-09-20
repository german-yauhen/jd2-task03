package by.htp.hermanovich.dao.newsDao;

import by.htp.hermanovich.dao.exception.DaoException;
import by.htp.hermanovich.dao.newsDao.NewsDaoImpl;
import by.htp.hermanovich.pojo.Contents;
import by.htp.hermanovich.pojo.News;
import org.junit.*;
import java.sql.Date;
import java.util.List;

/**
 * This class describes action to test execution of the methods from dao module
 * @author  Hermanovich Yauheni
 */
public class NewsDaoImplTest {

    private NewsDaoImpl newsDao;
    private News newsExpected;
    private News newsActual;
    private Contents contentsExpected;
    private List<News> newsList;

    @Before
    public void init() {
        newsDao = new NewsDaoImpl();
        contentsExpected = new Contents();
        contentsExpected.setTitle("TestNews");
        contentsExpected.setBrief("TestNewsBrief");
        contentsExpected.setContent("TestNewsContent");
        newsExpected = new News();
        newsExpected.setDateOfPublication(Date.valueOf("2017-09-20"));
        newsExpected.setContents(contentsExpected);
    }

    @Test
    public void saveNewsTest() throws DaoException {
        newsDao.saveNews(newsExpected);
        newsList = newsDao.getAllNews();
        newsActual = newsList.get(newsList.size()-1);
        Assert.assertEquals(newsExpected, newsActual);
    }

    @Test
    public void deleteNewsTest() throws DaoException {
        newsList = newsDao.getAllNews();
        newsActual = newsList.get(newsList.size()-1);
        Integer tempNewsId = newsActual.getId();
        newsDao.deleteNews(newsActual);
        Assert.assertNull(newsDao.getNewsById(tempNewsId));
    }

    @Test(expected = DaoException.class)
    public void exceptionTest() throws DaoException {
        newsExpected.getContents().setTitle(null);
        newsExpected.setDateOfPublication(null);
        newsDao.saveNews(newsExpected);
    }
}