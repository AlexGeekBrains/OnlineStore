package ru.alex;

import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        SessionFactoryUtils sessionFactoryUtils = new SessionFactoryUtils();
        sessionFactoryUtils.init();
        try {
            ProductDao productDao = new ProductDaoImpl(sessionFactoryUtils);
            List<Product> productList = productDao.findAll();
            System.out.println(productList);
            Product milk = new Product("Milk", 20);
            Product wine = new Product("Wine", 400);
            System.out.println(productDao.saveOrUpdate(milk)); //молоко уже есть, обновится цена
            System.out.println(productDao.saveOrUpdate(wine)); // вина нет, добавится
            Product pancake = productDao.findById(4l);
            System.out.println(pancake);
            productDao.deleteById(4l);
            List<Product> products = productDao.findAll();
            System.out.println(products);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sessionFactoryUtils.shutdown();
        }
    }
}
