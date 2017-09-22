package by.htp.hermanovich.command;

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

    /**
     * This method describes action to redirect to the main-page.jsp page automatically
     * @param model - an information which will be represented in the browser
     * @return a redirect command represented in the string value
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String redirectToMainPage(Model model) {
        return "main-page";
    }
}