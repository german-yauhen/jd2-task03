package by.htp.hermanovich.pojo;

import java.util.List;

/**
 * This class describes an entity of News object which is used for UI part of the application
 * The entity of this class is included into jsp page and represented on view part of the page
 * Also the entity of this class is used in registration part
 * @author  Hermanovich Yauheni
 */
public class NewsView {

    private News newsMessage;
    private List<News> newsList;

    public NewsView() {
    }

    public News getNewsMessage() {
        return newsMessage;
    }

    public void setNewsMessage(News newsMessage) {
        this.newsMessage = newsMessage;
    }

    public List<News> getNewsList() {
        return newsList;
    }

    public void setNewsList(List<News> newsList) {
        this.newsList = newsList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NewsView newsForm = (NewsView) o;

        if (newsMessage != null ? !newsMessage.equals(newsForm.newsMessage) : newsForm.newsMessage != null)
            return false;
        return newsList != null ? newsList.equals(newsForm.newsList) : newsForm.newsList == null;
    }

    @Override
    public int hashCode() {
        int result = newsMessage != null ? newsMessage.hashCode() : 0;
        result = 31 * result + (newsList != null ? newsList.hashCode() : 0);
        return result;
    }
}