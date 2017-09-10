package by.htp.hermanovich;

import by.htp.hermanovich.command.MainPageCommand;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Hermanovich Yauheni
 */
public class MainPageCommandTest {
    @Test
    public void redirectToMainPageTest() {
        String expected = "main-page";
        MainPageCommand mainPageCommand = new MainPageCommand();
        String actual = mainPageCommand.redirectToMainPage(null);
        Assert.assertEquals(expected, actual);
    }
}