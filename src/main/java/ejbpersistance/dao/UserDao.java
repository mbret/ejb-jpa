package ejbpersistance.dao;


import ejbpersistance.entities.User;

/**
 * Created by Maxime on 12/30/2014.
 */
public class UserDao extends DaoAbstract<User, Integer>{


    public User findOne(String email, String password){
        
        throw new UnsupportedOperationException();
    }
}
