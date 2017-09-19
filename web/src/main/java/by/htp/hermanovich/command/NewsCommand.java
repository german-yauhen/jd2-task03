package by.htp.hermanovich.command;

import by.htp.hermanovich.constant.Constants;
import by.htp.hermanovich.pojo.News;
import by.htp.hermanovich.pojo.NewsView;
import by.htp.hermanovich.service.exception.ServiceException;
import by.htp.hermanovich.service.newsService.NewsService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.sql.Date;

/**
 * This class provides and describes actions/methods meant for processing with
 * an entity of news object
 * @author Hermanovich Yauheni
 */
@Controller
public class NewsCommand {

    @Autowired
    private NewsService newsService;

    @Autowired
    private NewsView newsView;

    private static final Logger logger = Logger.getLogger(NewsCommand.class);

    /**
     * The method is used for populating command and form object
     * arguments of annotated handler methods.
     * @param dataBinder - special object for data binding from web request parameters
     */
    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    /**
     * This method describes action meant for prepare a summary object of flashy news
     * and return a name of view (*.jsp page) associates with the form of publication
     * the actual flashy news
     * @param model - information which will be represented in the browser
     * @return a name of view of a page associates with the form of publication
     */
    @RequestMapping(value = "/add-news-context", method = RequestMethod.GET)
    public String redirectToCreateNews(Model model) {
        newsView.setNewsEntity(NewsView.getNewsInstance());
        newsView.setStringDateOfPublication(null);
        model.addAttribute("newsView", newsView);
        logger.info(Constants.SUCCESS);
        return "create-news";
    }

    /**
     * This method describes actions meant for process information about news instance stored
     * into the request object and to insert flashy news into the database table.
     * Also method implements a validation this stored data.
     * @param newsView - an entity of DTO which contains all necessary information
     * @param bindingResult - an object holds the results of validation
     * @return a name of view of a page associates with overview of the news
     * @return
     */
    @RequestMapping(value = "/process-news-form", method = RequestMethod.POST)
    public String processCreateNews(@Valid @ModelAttribute("newsView") NewsView newsView,
                                          BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            logger.info(Constants.FORM_FIELDS_ERROR);
            return "create-news";
        }
        try {
            News actualNews = newsView.getNewsEntity();
            actualNews.setDateOfPublication(Date.valueOf(newsView.getStringDateOfPublication()));
            newsService.createNews(actualNews);
            newsView.setNewsEntity(actualNews);
            logger.info(Constants.SUCCESS);
            return "news-view";
        } catch (ServiceException e) {
            logger.error(e);
            return "error-page";
        }
    }

    @RequestMapping(value = "/view-news", method = RequestMethod.GET)
    public String processViewNews(@RequestParam("newsId") Integer newsId, Model model) {
        try {
            newsView.setNewsEntity(newsService.getNewsById(newsId));
            newsView.setStringDateOfPublication(String.valueOf(newsView.getNewsEntity().getDateOfPublication()));
            model.addAttribute("newsView", newsView);
            logger.info(Constants.SUCCESS);
            return "news-view";
        } catch (ServiceException e) {
            logger.error(e);
            return "error-page";
        }
    }

    @RequestMapping(value = "/delete-news", method = RequestMethod.POST)
    public String processDeleteNews(@RequestParam("newsId") Integer newsId) {
        System.out.println("News to delete " + newsId);
        try {
            newsService.deleteNews(newsService.getNewsById(newsId));
            logger.info(Constants.SUCCESS);
            return "redirect:/news-list-context";
        } catch (ServiceException e) {
            logger.error(e);
            return "error-page";
        }
    }

    @RequestMapping(value = "/edit-news", method = RequestMethod.GET)
    public String redirectToEditNews(@RequestParam("newsId") Integer newsId, Model model) {
        try {
            newsView.setNewsEntity(newsService.getNewsById(newsId));
            newsView.setStringDateOfPublication(String.valueOf(newsView.getNewsEntity().getDateOfPublication()));
            model.addAttribute("newsViewToEdit", newsView);
            logger.info(Constants.SUCCESS);
            return "edit-news";
        } catch (ServiceException e) {
            logger.error(e);
            return "error-page";
        }
    }

    @RequestMapping(value = "/process-news-edit-form", method = RequestMethod.POST)
    public String processeEditNews(@Valid @ModelAttribute("newsViewToEdit") NewsView newsView, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            logger.info(Constants.FORM_FIELDS_ERROR);
            return "edit-news";
        }
        try {
            News updatedNews = newsView.getNewsEntity();
            updatedNews.setDateOfPublication(Date.valueOf(newsView.getStringDateOfPublication()));
            newsService.updateNews(updatedNews);
            model.addAttribute("newsView", newsView);
            logger.info(Constants.SUCCESS);
            return "news-view";
        } catch (ServiceException e) {
            logger.error(e);
            return "error-page";
        }
    }
}