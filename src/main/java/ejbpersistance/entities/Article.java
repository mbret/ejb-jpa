
package ejbpersistance.entities;

import javax.persistence.*;

import java.sql.Timestamp;

@Entity(name = "article")
@Table(name = "article")
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title", unique = true, nullable = false)
    private String title;

    @Column(name = "content", unique = true, nullable = false)
    private String content;

    @Column(name = "date")
    private Timestamp date;
    
    @ManyToOne
    private User auteur;
    
    public Article() {}

    public Article(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

	public User getAuteur() {
		return auteur;
	}
	
	public void setAuteur (User u ){
		this.auteur = u;
	}
}

