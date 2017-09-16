package by.htp.hermanovich.pojo;

import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

/**
 * This class describes an entity of News object which is used for UI part of the application
 * The entity of this class is included into jsp page and represented on view part of the page
 * Also the entity of this class is used in registration part
 * @author  Hermanovich Yauheni
 */
@Component
public class NewsView {

    private News newsMessage;
    private List<News> newsList;
    private List<News> taggedNews;
    private List<Integer> taggedIds;

    public NewsView() {
    }

    public static News getNewsInstance() {
        return new News();
    }

    public static List<News> getTaggedNewsInstance() {
        return new ArrayList<News>();
    }

    public static List<Integer> getTaggedIdsInstance() {
        return new ArrayList<Integer>();
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

    public List<News> getTaggedNews() {
        return taggedNews;
    }

    public void setTaggedNews(List<News> taggedNews) {
        this.taggedNews = taggedNews;
    }

    public List<Integer> getTaggedIds() {
        return taggedIds;
    }

    public void setTaggedIds(List<Integer> taggedIds) {
        this.taggedIds = taggedIds;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NewsView newsView = (NewsView) o;

        if (newsMessage != null ? !newsMessage.equals(newsView.newsMessage) : newsView.newsMessage != null)
            return false;
        if (newsList != null ? !newsList.equals(newsView.newsList) : newsView.newsList != null) return false;
        if (taggedNews != null ? !taggedNews.equals(newsView.taggedNews) : newsView.taggedNews != null) return false;
        return taggedIds != null ? taggedIds.equals(newsView.taggedIds) : newsView.taggedIds == null;
    }

    @Override
    public int hashCode() {
        int result = newsMessage != null ? newsMessage.hashCode() : 0;
        result = 31 * result + (newsList != null ? newsList.hashCode() : 0);
        result = 31 * result + (taggedNews != null ? taggedNews.hashCode() : 0);
        result = 31 * result + (taggedIds != null ? taggedIds.hashCode() : 0);
        return result;
    }
}