package ru.alex;

import org.springframework.context.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.alex.data.Consumer;
import ru.alex.data.Product;
import ru.alex.repository.ConsumerDao;
import ru.alex.repository.ConsumerDaoImpl;
import ru.alex.repository.ProductDao;
import ru.alex.repository.ProductDaoImpl;

import java.util.List;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("ru.alex");
        ProductDao productDao = context.getBean(ProductDaoImpl.class);
        ConsumerDao consumerDao = context.getBean(ConsumerDaoImpl.class);
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("введите команду");
            String in = sc.nextLine();
            String[] token = in.split(" ");
            if (token[0].equals("getProduct")) {
                Product product = productDao.findById((long) Integer.parseInt(token[1].trim()));
                System.out.println(product);
            }
            if (token[0].equals("getConsumer")) {
                Consumer consumer = consumerDao.findConsumerById((long) Integer.parseInt(token[1].trim()));
                System.out.println(consumer);
            }
            if (token[0].equals("getProductsByConsumerId")) {
                List<Product> products = consumerDao.getProductsByConsumerId((long) Integer.parseInt(token[1].trim()));
                System.out.println(products);
            }
            if (token[0].equals("getConsumersByProductsId")) {
                List<Consumer> consumers = productDao.getConsumersByProductsId((long) Integer.parseInt(token[1].trim()));
                System.out.println(consumers);
            }
            if (token[0].equals("exit")) break;
        }
    }
}

