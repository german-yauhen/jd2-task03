package by.htp.hermanovich.command;

import by.htp.hermanovich.constant.Constants;
import by.htp.hermanovich.service.exception.ServiceException;
import by.htp.hermanovich.service.newsService.NewsService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private NewsService newsService;

    private static final Logger logger = Logger.getLogger(NewsListCommand.class);

    /**
     * This method describes actions to retrieve a archives of the news,
     * locates it to the model instance as a list and represents it on the corresponding page
     * @param model - information which will be represented in the browser
     * @return a name of view of a page associates with the list of news
     */
    @RequestMapping(value = "/get-news-list", method = RequestMethod.GET)
    public String getNewsList(Model model) {
        String resultPage = null;
        try {
            //TODO change the code
            System.out.println(newsService.getAllNews());
            resultPage = "news-list-page";
            logger.info(Constants.SUCCESS);
        } catch (ServiceException e) {
            logger.error(e);
            // TODO redirect to error.jsp or main-page.jsp
        }
        return resultPage;
    }
}