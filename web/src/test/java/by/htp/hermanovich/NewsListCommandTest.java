package by.htp.hermanovich;

import by.htp.hermanovich.command.NewsListCommand;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Hermanovich Yauheni
 */
public class NewsListCommandTest {

    @Test
    public void getNewsListTest() {
        String expected = "news-list-page";
        NewsListCommand newsListCommand = new NewsListCommand();
        String actual = newsListCommand.getNewsList(null);
        Assert.assertEquals(expected, actual);
    }
}