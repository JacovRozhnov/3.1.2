package ru.itmentor.spring.boot_security.demo.dao;

import org.springframework.stereotype.Repository;
import ru.itmentor.spring.boot_security.demo.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;


@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public List<User> allUsers() {
        return entityManager.createQuery("FROM User", User.class).getResultList();
    }

    @Override
    public void saveUser(User user) {
        entityManager.persist(user);

    }

    @Override
    public User getById(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void update(int id,User updatedUser) {
        User user = getById(id);
        User.setAge(updatedUser.getAge());
        user.setName(updatedUser.getName());
        user.setName(updatedUser.getName());
        user.setEmail(updatedUser.getEmail());
        entityManager.merge(user);

    }

    @Override
    public void delete(int id) {
        entityManager.remove(getById(id));

    }
}
