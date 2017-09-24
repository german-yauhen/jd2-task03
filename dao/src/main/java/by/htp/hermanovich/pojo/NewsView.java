package by.htp.hermanovich.pojo;

import org.springframework.stereotype.Component;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

/**
 * This class describes an entity of NewsView object which is used for UI part of the application
 * The entity of this class doesn't have any behavior and is used to pass data with multiple attributes
 * in one shot from client to server
 * The entity of this class is included into jsp page and represented on view part of the page
 * @see News
 * @author  Hermanovich Yauheni
 */
@Component
public class NewsView {

    @Valid
    private News newsEntity;
    @NotNull(message = "The field must be filled")
    private String stringDateOfPublication;
    private List<Integer> taggedIds;
    private List<News> newsList;

    public NewsView() {
    }

    public static News getNewsInstance() {
        return new News();
    }

    public static List<Integer> getTaggedIdsInstance() {
        return new ArrayList<Integer>();
    }

    public News getNewsEntity() {
        return newsEntity;
    }

    public void setNewsEntity(News newsEntity) {
        this.newsEntity = newsEntity;
    }

    public String getStringDateOfPublication() {
        return stringDateOfPublication;
    }

    public void setStringDateOfPublication(String stringDateOfPublication) {
        this.stringDateOfPublication = stringDateOfPublication;
    }

    public List<Integer> getTaggedIds() {
        return taggedIds;
    }

    public void setTaggedIds(List<Integer> taggedIds) {
        this.taggedIds = taggedIds;
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

        NewsView newsView = (NewsView) o;

        if (newsEntity != null ? !newsEntity.equals(newsView.newsEntity) : newsView.newsEntity != null) return false;
        if (stringDateOfPublication != null ? !stringDateOfPublication.equals(newsView.stringDateOfPublication) : newsView.stringDateOfPublication != null)
            return false;
        if (taggedIds != null ? !taggedIds.equals(newsView.taggedIds) : newsView.taggedIds != null) return false;
        return newsList != null ? newsList.equals(newsView.newsList) : newsView.newsList == null;
    }

    @Override
    public int hashCode() {
        int result = newsEntity != null ? newsEntity.hashCode() : 0;
        result = 31 * result + (stringDateOfPublication != null ? stringDateOfPublication.hashCode() : 0);
        result = 31 * result + (taggedIds != null ? taggedIds.hashCode() : 0);
        result = 31 * result + (newsList != null ? newsList.hashCode() : 0);
        return result;
    }
}