package by.htp.hermanovich.command;

import by.htp.hermanovich.pojo.NewsView;
import by.htp.hermanovich.service.exception.ServiceException;
import by.htp.hermanovich.service.newsService.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.HttpServletRequest;

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

    /**
     * This method describes actions to retrieve a archives of the news,
     * locates it to the model instance as a list and represents it on the corresponding page
     * @param model - information which will be represented in the browser
     * @return a name of view of a page associates with the list of news
     */
    @RequestMapping(value = "/news-list-context", method = RequestMethod.GET)
    public String getNewsList(Model model, HttpServletRequest request) {
        try {
            newsView.setNewsList(newsService.getAllNews());
            newsView.setTaggedIds(NewsView.getTaggedIdsInstance());
            model.addAttribute("newsView", newsView);
            return "news-list-page";
        } catch (ServiceException e) {
            return "error-page";
        }
    }

    /**
     * This method describes actions to delete a list of the news has been chosen on the page
     * The method receives a special data transfer object (DTO) received from the request, fetches
     * a list of <i>news</i> objects as a filed of DTO and renders the list to the service module
     * to delete the news from the database table
     * @param newsView - an entity of DTO which contains all necessary information
     * @return          a name of view of a page associates with the list of news
     */
    @RequestMapping(value = "/delete-news-list", method = RequestMethod.POST)
    public String processDeleteNewsList(NewsView newsView, HttpServletRequest request) {
        try {
            for (Integer newsId : newsView.getTaggedIds()) {
                newsService.deleteNews(newsService.getNewsById(newsId));
            }
            return  "redirect:/news-list-context";
        } catch (ServiceException e) {
            return "error-page";
        }
    }
}