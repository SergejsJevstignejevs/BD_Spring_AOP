package com.sj.interfaces.impl;

import com.sj.interfaces.Product;
import com.sj.interfaces.Shop;
import org.springframework.context.ApplicationContext;

public class ProductShop implements Shop {

    ProductInventory productInventory = new ProductInventory();

    public ProductShop(ProductInventory productInventory){

        this.productInventory = productInventory;

    }

    public ProductShop(){
    }

    public void addProduct(Product product){

        productInventory.addProduct(product);

    }

    public void deleteProduct(Integer productId){

        productInventory.deleteProductById(productId);

    }

    @Override
    public String toString() {

        return productInventory.toString();

    }

    public ProductInventory getProductInventory() {
        return productInventory;
    }

    public void setProductInventory(ProductInventory productInventory) {
        this.productInventory = productInventory;
    }

//    public void executeConsoleUI(ApplicationContext context){
//
//        ProductShop productShopProxy = context.getBean(ProductShop.class);
//
//        Scanner scanner = new Scanner(System.in);
//        int optionNr;
//        String productName;
//        int productQuality;
//        Integer productId;
//        while(true){
//            System.out.println(
//                    "Select option:\n" +
//                            "\t1. Add product\n" +
//                            "\t2. Delete product by id\n" +
//                            "\t3. Show shop inventory\n" +
//                            "\t4. Exit");
//            System.out.print("Selected option: ");
//            optionNr = scanner.nextInt();
//            switch (optionNr) {
//                case 1 -> {
//                    System.out.print("\tProduct name: ");
//                    productName = scanner.next();
//                    System.out.print("\tProduct quality: ");
//                    productQuality = scanner.nextInt();
//                    productShopProxy.addProduct(new QualityProduct(productName, productQuality));
//                }
//                case 2 -> {
//                    System.out.print("\tProduct id: ");
//                    productId = scanner.nextInt();
//                    productShopProxy.deleteProduct(productId);
//                }
//                case 3 -> {
//                    System.out.println(productShopProxy);
//                }
//                case 4 -> {
//                    System.out.println("\tExiting program!");
//                    return;
//                }
//                default -> {
//                    System.out.println("\tChoose correct option!");
//                }
//            }
//        }
//    }

}
