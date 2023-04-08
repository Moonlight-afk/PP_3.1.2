package web.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.models.Users;

import java.util.List;

@Repository
@Transactional
public class UserRepositoryImpl implements UserRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Users> getAllUsers() {
        return entityManager.createQuery("from Users", Users.class).getResultList();
    }

    @Override
    public void createUser(Users person) {
        entityManager.persist(person);
    }

    @Override
    public void updateUser(Users user) {
        entityManager.merge(user);
    }

    @Override
    public Users readUser(int id) {
        return entityManager.find(Users.class, id);
    }

    @Override
    public void deleteUser(int id) {
        Users user = readUser(id);
        entityManager.remove(user);
    }
}
