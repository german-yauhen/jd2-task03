package by.htp.hermanovich.command;

import by.htp.hermanovich.constant.Constants;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * This class describes action to redirect to the main-page.jsp page automatically.
 * @author Hermanovich Yauheni
 */
@Controller
public class MainPageCommand {

    private static final Logger logger = Logger.getLogger(MainPageCommand.class);

    /**
     * This method describes action to redirect to the main-page.jsp page automatically
     * @param model - an information which will be represented in the browser
     * @return a redirect command represented in the string value
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String redirectToMainPage(Model model) {
        logger.info(Constants.SUCCESS);
        return "main-page";
    }
}