package by.htp.hermanovich.command;

import by.htp.hermanovich.constant.Constants;
import by.htp.hermanovich.service.exception.ServiceException;
import by.htp.hermanovich.service.newsService.NewsService;
import by.htp.hermanovich.service.newsService.NewsServiceImpl;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * This class provides and describes actions/methods meant
 * for read all news from the corresponding database table
 * and represent the list into the browser's page.
 * @author Hermanovich Yauheni
 */
@Controller
@RequestMapping(value = "/news-list", method = RequestMethod.GET)
public class NewsListCommand {

    // TODO IoC
    private NewsService newsService = new NewsServiceImpl();
    private static final Logger logger = Logger.getLogger(NewsListCommand.class);

    @RequestMapping(value = "/get-news-list", method = RequestMethod.GET)
    public String getNewsList(Model model) {
        String resultPage = null;
        try {
            System.out.println(newsService.getNewsById(1));
        } catch (ServiceException e) {
            logger.error(e);
        }
        logger.info(Constants.SUCCESS);
        resultPage = "news-list-page";
        return resultPage;
    }
}