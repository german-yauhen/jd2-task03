package by.htp.hermanovich.pojo;

import org.springframework.stereotype.Component;
import javax.persistence.*;
import java.util.Date;

/**
 * This class describes an entity News object represents as an object of business logic of the application
 * which is processed on service and dao modules. The entities of this class are used by Hibernate framework.
 * The fields of the class annotated according to the corresponding columns in the database table.
 * Attention:   private field <i>dateOfPublication</i> is annotated by @Temporal with the value TemporalType.DATE
 *              it has been done to bind (associate) the java.util.Date on the type java.sql.Date
 *              to provide standard actions on the field <i>dateOfPublication</i>
 * @see Contents
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