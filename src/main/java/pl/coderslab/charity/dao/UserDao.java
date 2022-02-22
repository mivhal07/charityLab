package pl.coderslab.charity.dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.charity.entity.Institution;
import pl.coderslab.charity.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class UserDao {
    @PersistenceContext
    EntityManager entityManager;

    public List<User> getUsersName() {
        return entityManager
                .createQuery("select u from User u")
                .getResultList();
    }

//    public List<User> getAdmins(){
//        return entityManager
//                .createQuery("select u from User u JOIN User_Roles ur on u.id = ur.user_id JOIN role r on ur.roles_id = r.id where r.id=1")
//                .getResultList();
//    }
}
