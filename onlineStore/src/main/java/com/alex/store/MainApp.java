package com.alex.store;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("com.alex.store");
        Cart cart = context.getBean(Cart.class);
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Добавьте товар в корзину при помощи команды 'add' указав его id или удалите при помощи команды 'remove' так же указав его id");
            String in = sc.nextLine();
            String[] token = in.split(" ");
            if (token[0].equals("add")) {
                cart.addProductCartById(Integer.parseInt(token[1].trim()));
                System.out.println(cart);
            }
            if (token[0].equals("remove")) {
                cart.removeProductCartById(Integer.parseInt(token[1].trim()));
                System.out.println(cart);
            }
            if (token[0].equals("exit")) break;
        }
    }
}