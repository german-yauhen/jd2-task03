package by.htp.hermanovich.command;

import by.htp.hermanovich.pojo.News;
import by.htp.hermanovich.pojo.NewsView;
import by.htp.hermanovich.service.exception.ServiceException;
import by.htp.hermanovich.service.newsService.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.RequestContextUtils;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
     * This method describes actions meant for change the display language of the page.
     * Update action with required language will be executed as a result of method execution.
     * @param language      parameter corresponding to the required page display language
     * @param request       an instance of HttpServletRequest
     * @param response      an instance of HttpServletResponse
     * @return              a string value of the required page,
     *                      in this case the redirect command will be executed
     */
    @RequestMapping(value = "/language", method = RequestMethod.POST)
    public String changeLanguage(@RequestParam("language") String language,
                                 HttpServletRequest request, HttpServletResponse response) {
        RequestContextUtils.getLocaleResolver(request)
                .setLocale(request, response, StringUtils.parseLocaleString(language));
        return "redirect:" + request.getHeader("Referer");
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
        return "create-news";
    }

    /**
     * This method describes actions meant for process information about news instance stored
     * into the request object and to insert flashy news into the database table.
     * Also method implements a validation this stored data.
     * The method uses Post-Get-Redirect pattern approach to protect from the re-sending the form.
     * @param newsView          an entity of DTO which contains all necessary information
     * @param bindingResult     an object holds the results of validation
     * @return                  a name of view of a page associates with overview of the create-news form
     */
    @RequestMapping(value = "/process-create-news", method = RequestMethod.POST)
    public String processCreateNews(@Valid @ModelAttribute("newsView") NewsView newsView, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "create-news";
        }
        try {
            News actualNews = newsView.getNewsEntity();
            actualNews.setDateOfPublication(Date.valueOf(newsView.getStringDateOfPublication()));
            newsService.createNews(actualNews);
            newsView.setNewsEntity(actualNews);
            System.out.println(actualNews);
            return "redirect:/view-news?newsId=" + actualNews.getId();
        } catch (ServiceException e) {
            return "error-page";
        }
    }

    /**
     * This method describes actions meant for view news from database table using the Id of the news.
     * The method receives an id of a news from the request object as an argument of the method, transmits
     * the id value to service module where corresponding news object will be requested according
     * to the id value. The news object is transmitted into the NewsView object in the Model.
     * @param newsId    a news Id which will be transmitted to service module to proceed delete operation
     * @param model     information which will be represented in the browser
     * @return          a string value of the required page associates with overview the current news
     */
    @RequestMapping(value = "/view-news", method = RequestMethod.GET)
    public String processViewNews(@RequestParam("newsId") Integer newsId, Model model) {
        try {
            newsView.setNewsEntity(newsService.getNewsById(newsId));
            newsView.setStringDateOfPublication(String.valueOf(newsView.getNewsEntity().getDateOfPublication()));
            model.addAttribute("newsView", newsView);
            return "news-view";
        } catch (ServiceException e) {
            return "error-page";
        }
    }

    /**
     * This method describes actions meant for delete news from database table using the Id of the news.
     * The method receives an id of a news from the request object as an argument of the method.
     * @param newsId    a news Id which will be transmitted to service module to proceed delete operation
     * @return          a string value of the required page associates with overview the news list
     */
    @RequestMapping(value = "/delete-news", method = RequestMethod.POST)
    public String processDeleteNews(@RequestParam("newsId") Integer newsId) {
        try {
            newsService.deleteNews(newsService.getNewsById(newsId));
            return "redirect:/news-list-context";
        } catch (ServiceException e) {
            return "error-page";
        }
    }

    /**
     * This method describes actions meant for prepare a summary object of current news to update
     * and return a name of view (*.jsp page) associates with the update/edit form of the current news
     * @param newsId    a news Id which will be transmitted to service module to proceed delete operation
     * @param model     information which will be represented in the browser
     * @return          a string value of the required page associates with the edit-news form
     */
    @RequestMapping(value = "/edit-news", method = RequestMethod.GET)
    public String redirectToEditNews(@RequestParam("newsId") Integer newsId, Model model) {
        try {
            newsView.setNewsEntity(newsService.getNewsById(newsId));
            newsView.setStringDateOfPublication(String.valueOf(newsView.getNewsEntity().getDateOfPublication()));
            model.addAttribute("newsViewToEdit", newsView);
            return "edit-news";
        } catch (ServiceException e) {
            return "error-page";
        }
    }

    /**
     * This method describes actions meant for edit news of the application and updates the corresponding object
     * in the database table, using the Id of the news.
     * The method receives an id of a news from the request object as an argument of the method, transmits
     * the id value to service module where corresponding news object will be requested according
     * to the id value. The news object is transmitted into the NewsView object in the Model.
     * The method uses Post-Get-Redirect pattern approach to protect from the re-sending the form.
     * @param newsView          an entity of DTO which contains all necessary information
     * @param bindingResult     an object holds the results of validation
     * @param model             information which will be represented in the browser
     * @return                  a name of view of a page associates with overview the current news
     */
    @RequestMapping(value = "/process-news-edit-form", method = RequestMethod.POST)
    public String processEditNews(@Valid @ModelAttribute("newsViewToEdit") NewsView newsView,
                                  BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "edit-news";
        }
        try {
            News updatedNews = newsView.getNewsEntity();
            updatedNews.setDateOfPublication(Date.valueOf(newsView.getStringDateOfPublication()));
            newsService.updateNews(updatedNews);
            model.addAttribute("newsView", newsView);
            return "redirect:/view-news?newsId=" + updatedNews.getId();
        } catch (ServiceException e) {
            return "error-page";
        }
    }
}