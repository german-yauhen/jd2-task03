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
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.validation.Valid;

/**
 * This class provides and describes actions/methods meant for processing with
 * an entity of news object
 * @author Hermanovich Yauheni
 */
@Controller
public class AddNewsCommand {

    @Autowired
    private NewsService newsService;

    @Autowired
    private NewsView newsView;

    private static final Logger logger = Logger.getLogger(AddNewsCommand.class);

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
    public String redirectToRegisterNews(Model model) {
        model.addAttribute("flashyNews", NewsView.getNewsInstance());
        return "create-news";
    }

    /**
     * This method describes actions meant for process information about news instance stored
     * into the request object and to insert flashy news into the database table.
     * Also method implements a validation this stored data.
     * @param flashyNews - an actual flashy news which will be stored into the database table
     * @param bindingResult - an object holds the results of validation
     * @param model - information which will be processed and represented in the browser
     * @return a name of view of a page associates with overview of the news
     */
    @RequestMapping(value = "/process-news-form", method = RequestMethod.POST)
    public String processRegisterNewsForm(@Valid @ModelAttribute(value = "flashyNews") News flashyNews,
                                          BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            logger.info(Constants.FORM_FIELDS_ERROR);
            return "create-news";
        }
        try {
            newsService.createNews(flashyNews);
            newsView.setNewsMessage(flashyNews);
            model.addAttribute("newsView", newsView);
        } catch (ServiceException e) {
            logger.error(e);
            return "redirect:/";
        }
        logger.info(Constants.SUCCESS);
        return "news-view";
    }
}