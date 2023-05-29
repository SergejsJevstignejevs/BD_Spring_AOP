package com.sj.interfaces.impl;

import com.sj.interfaces.Inventory;
import com.sj.interfaces.Product;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class ProductInventory implements Inventory {

    Map<Integer, Product> products = new HashMap<>();
    Integer newProductId = 0;

    public void addProduct(Product product){

        products.put(newProductId++, product);

    }

    public void deleteProductById(Integer productId){

        products.remove(productId);

    }

    @Override
    public String toString() {
        String resultString = "";
        for(Map.Entry<Integer, Product> entry : products.entrySet()){

            Integer key = entry.getKey();
            Product value = entry.getValue();
            resultString += "\t[ID: " + key + "]" + value.toString() + "\n";

        }

        return resultString;
    }
}
