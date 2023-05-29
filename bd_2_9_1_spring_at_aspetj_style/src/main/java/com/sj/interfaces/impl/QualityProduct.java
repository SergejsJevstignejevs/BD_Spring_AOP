package com.sj.interfaces.impl;

import com.sj.interfaces.Product;
import org.springframework.stereotype.Component;

@Component
public class QualityProduct implements Product {

    private String name;
    private int quality;

    public QualityProduct(String name, int quality){
        this.name = name;
        this.quality = quality;
    }
    public QualityProduct(){
    }

    @Override
    public String toString() {
        return "[Name: " + this.name + "; Quality: " + this.quality + "]";
    }

    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
