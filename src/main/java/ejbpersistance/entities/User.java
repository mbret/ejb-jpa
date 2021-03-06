
package ejbpersistance.entities;

import java.io.Serializable;

import javax.persistence.*;

@Entity(name = "user")
@Table(name = "users")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="email", unique = true, nullable = false)
    private String email;

    @Column(name="password", unique = false, nullable = false)
    private String password;

    @Column(name="subscriber", unique = false, nullable = false)
    private Boolean subscriber;
    
    public User(){

    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getSubscriber() {
        return subscriber;
    }

    public void setSubscriber(boolean s) {
        this.subscriber=s;
    }

}
