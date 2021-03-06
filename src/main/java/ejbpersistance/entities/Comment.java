package ejbpersistance.entities;

import javax.persistence.*;

import java.io.Serializable;
import java.sql.Timestamp;

@Entity(name = "comment")
@Table(name = "comments")
public class Comment implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="content", unique = true, nullable = false)
    private String content;

    @ManyToOne
    private Article article;

    @ManyToOne
    private User user;

    @Column(name = "date", updatable = false, insertable = false)
    private Timestamp date;
    
    public Comment() {}

    public Comment(String content, Article article, User user) {
        this.content = content;
        this.article = article;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }
}