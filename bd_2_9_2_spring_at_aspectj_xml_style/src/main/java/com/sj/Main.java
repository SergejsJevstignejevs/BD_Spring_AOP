package com.sj;

import com.sj.interfaces.impl.ProductShop;
import com.sj.interfaces.impl.QualityProduct;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("config/aop-xml-config.xml");
        ProductShop productShop = context.getBean(ProductShop.class);
		//productShop.executeConsoleUI(context);
        Scanner scanner = new Scanner(System.in);
        int optionNr;
        String productName;
        int productQuality;
        Integer productId;
        while(true){
            System.out.println(
                    "Select option:\n" +
                            "\t1. Add product\n" +
                            "\t2. Delete product by id\n" +
                            "\t3. Show shop inventory\n" +
                            "\t4. Exit");
            System.out.print("Selected option: ");
            optionNr = scanner.nextInt();
            switch (optionNr) {
                case 1 -> {
                    System.out.print("\tProduct name: ");
                    productName = scanner.next();
                    System.out.print("\tProduct quality: ");
                    productQuality = scanner.nextInt();
                    productShop.addProduct(new QualityProduct(productName, productQuality));
                }
                case 2 -> {
                    System.out.print("\tProduct id: ");
                    productId = scanner.nextInt();
                    productShop.deleteProduct(productId);
                }
                case 3 -> {
                    System.out.println(productShop);
                }
                case 4 -> {
                    System.out.println("\tExiting program!");
                    return;
                }
                default -> {
                    System.out.println("\tChoose correct option!");
                }
            }
        }
    }
}