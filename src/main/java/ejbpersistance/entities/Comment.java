package ejbpersistance.entities;

import javax.persistence.*;

@Entity(name = "comment")
@Table(name = "comment")
public class Comment {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="content", unique = true, nullable = false)
    private String content;
    
    @OneToOne
    private Article article;

    public Comment() {}

    public Comment(String content, Article article) {
        this.content = content;
        this.article = article;
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
}
