package ejbpersistance.entities;

import javax.persistence.*;

@Entity(name = "comment")
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="content", unique = true, nullable = false)
    private String content;

    @ManyToOne
    private Article article;

    @ManyToOne
    private User user;

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
}