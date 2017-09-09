package by.htp.hermanovich.pojo;

import javax.persistence.*;

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

    @Column(name = "title")
    private String title;

    @Column(name = "brief")
    private String brief;

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
}