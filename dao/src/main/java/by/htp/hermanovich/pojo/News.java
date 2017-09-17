package by.htp.hermanovich.pojo;

import org.springframework.stereotype.Component;
import javax.persistence.*;
import java.util.Date;

/**
 * @author Hermanovich Yauheni
 */
@Entity
@Table(name = "news")
@Component
public class News {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_news")
    private Integer id;

    @Column(name = "date_of_publication")
    @Temporal(TemporalType.DATE)
    private Date dateOfPublication;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "id_contents")
    private Contents contents;

    public News() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDateOfPublication() {
        return dateOfPublication;
    }

    public void setDateOfPublication(Date dateOfPublication) {
        this.dateOfPublication = dateOfPublication;
    }

    public Contents getContents() {
        return contents;
    }

    public void setContents(Contents contents) {
        this.contents = contents;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        News news = (News) o;

        if (id != null ? !id.equals(news.id) : news.id != null) return false;
        if (dateOfPublication != null ? !dateOfPublication.equals(news.dateOfPublication) : news.dateOfPublication != null)
            return false;
        return contents != null ? contents.equals(news.contents) : news.contents == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (dateOfPublication != null ? dateOfPublication.hashCode() : 0);
        result = 31 * result + (contents != null ? contents.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "News" + id + ":::" + dateOfPublication + ":::" + contents;
    }
}