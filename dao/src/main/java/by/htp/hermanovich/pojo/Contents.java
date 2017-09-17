package by.htp.hermanovich.pojo;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by Hermanovich Yauheni
 */
@Entity
@Table(name = "contents")
public class Contents {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_contents")
    private Integer id;

    @NotNull(message = "The field must be filled")
    @Size(min = 1, max = 100, message = "The field must contain")
    @Column(name = "title")
    private String title;

    @NotNull(message = "The field must contain between 1 and 100 characters")
    @Size(min = 1, max = 500, message = "The field must contain between 1 and 500 characters")
    @Column(name = "brief")
    private String brief;

    @NotNull(message = "The field must be filled")
    @Size(min = 1, max = 2048, message = "The field must contain between 1 and 2048 characters")
    @Column(name = "content")
    private String content;

    public Contents() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Contents contents = (Contents) o;

        if (id != null ? !id.equals(contents.id) : contents.id != null) return false;
        if (title != null ? !title.equals(contents.title) : contents.title != null) return false;
        if (brief != null ? !brief.equals(contents.brief) : contents.brief != null) return false;
        return content != null ? content.equals(contents.content) : contents.content == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (brief != null ? brief.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return title + ":::" + brief + ":::" + content;
    }
}