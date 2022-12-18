package ru.alex.repository;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.alex.data.Consumer;
import ru.alex.data.Product;

import java.util.List;

@Component
public class ConsumerDaoImpl implements ConsumerDao {
    private SessionFactoryUtils sessionFactoryUtils;

    @Autowired
    public ConsumerDaoImpl(SessionFactoryUtils sessionFactoryUtils) {
        this.sessionFactoryUtils = sessionFactoryUtils;
    }

    @Override
    public Consumer findConsumerById(Long id) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            Consumer consumer = session.get(Consumer.class, id);
            session.getTransaction().commit();
            return consumer;
        }
    }

    @Override
    public List<Product> getProductsByConsumerId(Long id) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            Consumer consumer = session.get(Consumer.class, id);
            List<Product> products = consumer.getProducts();
            products.size();
            session.getTransaction().commit();
            return products;
        }
    }

    @Override
    public List<Consumer> findAll() {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            List<Consumer> consumers = session.createQuery("from Consumer", Consumer.class).getResultList();
            session.getTransaction().commit();
            return consumers;
        }
    }

    @Override
    public void deleteById(Long id) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            session.createQuery("delete from Consumer consumer where consumer.id = :id")
                    .setParameter("id", id)
                    .executeUpdate();
            session.getTransaction().commit();
        }
    }

    @Override
    public Consumer saveOrUpdate(Consumer consumer) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            session.saveOrUpdate(consumer);
            session.getTransaction().commit();
            return consumer;
        }
    }
}
