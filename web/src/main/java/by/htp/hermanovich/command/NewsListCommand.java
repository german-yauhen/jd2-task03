package by.htp.hermanovich.command;

import by.htp.hermanovich.constant.Constants;
import by.htp.hermanovich.pojo.NewsView;
import by.htp.hermanovich.service.exception.ServiceException;
import by.htp.hermanovich.service.newsService.NewsService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.List;

/**
 * This class provides and describes actions/methods meant
 * for read all news from the corresponding database table
 * and represent the list into the browser's page.
 * @author Hermanovich Yauheni
 */
@Controller
public class NewsListCommand {

    @Autowired
    private NewsService newsService;

    @Autowired
    private NewsView newsView;

    private static final Logger logger = Logger.getLogger(NewsListCommand.class);

    /**
     * This method describes actions to retrieve a archives of the news,
     * locates it to the model instance as a list and represents it on the corresponding page
     * @param model - information which will be represented in the browser
     * @return a name of view of a page associates with the list of news
     */
    @RequestMapping(value = "/news-list-context", method = RequestMethod.GET)
    public String getNewsList(Model model) {
        try {
            newsView.setNewsList(newsService.getAllNews());
            newsView.setTaggedIds(NewsView.getTaggedIdsInstance());
            model.addAttribute("newsView", newsView);
            logger.info(Constants.SUCCESS);
            return "news-list-page";
        } catch (ServiceException e) {
            logger.error(e);
            return "error-page";
        }
    }

    /**
     * This method describes actions to delete a list of the news has been chosen on the page
     * The method receives a special data transfer object (DTO) received from the request, fetches
     * a list of <i>news</i> objects as a filed of DTO and renders the list to the service module
     * to delete the news from the database table
     * @param model     - information which will be represented in the browser
     * @return          a name of view of a page associates with the list of news
     */
    @RequestMapping(value = "/delete-news-list", method = RequestMethod.GET)
    public String processDeleteNewsList(NewsView newsView, Model model) {
        List<Integer> newsIdsToDelete = newsView.getTaggedIds();
        for (Integer id: newsIdsToDelete) {
            System.out.println(id.getClass() + ":" + id);
        }
        return  "redirect:/news-list-context";
    }
}