package ru.alex;

import org.hibernate.Session;

import javax.persistence.NoResultException;
import java.util.List;

public class ProductDaoImpl implements ProductDao {
    private SessionFactoryUtils sessionFactoryUtils;

    public ProductDaoImpl(SessionFactoryUtils sessionFactoryUtils) {
        this.sessionFactoryUtils = sessionFactoryUtils;
    }

    @Override
    public Product findById(Long id) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            Product product = session.get(Product.class, id);
            session.getTransaction().commit();
            return product;
        }
    }

    @Override
    public List<Product> findAll() {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            List<Product> products = session.createQuery("select p from Product p", Product.class).getResultList();
            session.getTransaction().commit();
            return products;
        }
    }

    @Override
    public void deleteById(Long id) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            Product product = session.get(Product.class, id);
            session.remove(product);
            session.getTransaction().commit();
        }
    }

    @Override
    public Product saveOrUpdate(Product product) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            try {
                Product oldProduct = session.createQuery("select oldProduct from Product oldProduct where oldProduct.title = :title", Product.class)
                        .setParameter("title", product.getTitle())
                        .getSingleResult();
                oldProduct.setPrice(product.getPrice());
                session.getTransaction().commit();
                return oldProduct;
            } catch (NoResultException e) {
                session.save(product);
                session.getTransaction().commit();
                return product;
            }
        }
    }
}
