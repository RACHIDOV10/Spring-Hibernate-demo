package metier;

import dao.IDao;
import entities.Category;
import entities.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class CategoryDaoImpl implements IDao<Category> {

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    @Transactional
    public boolean create(Category c) {
        Session session = sessionFactory.getCurrentSession();
        session.save(c);
        return true;
    }

    @Override
    @Transactional
    public boolean delete(Category c) {
        sessionFactory.getCurrentSession().delete(c);
        return true;
    }

    @Override
    @Transactional
    public boolean update(Category c) {
        sessionFactory.getCurrentSession().update(c);
        return true;
    }

    @Override
    @Transactional
    public Category findById(int id) {
        return sessionFactory.getCurrentSession().get(Category.class, id);
    }

    @Override
    @Transactional
    public List<Category> findAll() {
        return sessionFactory.getCurrentSession()
                .createQuery("from Product", Category.class)
                .list();
    }
}
