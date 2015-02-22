import ejbpersistance.dao.ArticleDao;
import ejbpersistance.dao.CommentDao;
import ejbpersistance.dao.UserDao;
import ejbpersistance.entities.Article;
import ejbpersistance.entities.Comment;
import ejbpersistance.entities.User;

public class Main {
    public static void main(String[] args){
        /*User user = new User();
        user.setId(6);
        user.setEmail("a@a.a");
        user.setPassword("aaa");

        Article article = new Article();
        article.setId(7);
        article.setTitle("title");
        article.setContent("content");*/
    	
    	

        ArticleDao articledao = new ArticleDao();
        UserDao userdao = new UserDao();
        
        User user = userdao.get(6);
        Article article = articledao.get(7);
        
        Comment com = new Comment();
        com.setContent("content2");
        com.setArticle(article);
        com.setUser(user);

        article = articledao.save(article);
        

        CommentDao comdao = new CommentDao();
        com = comdao.get(1);
        comdao.delete(com);
    }
}
