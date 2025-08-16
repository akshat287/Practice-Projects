package com.techieakshat.webApp.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Component
@Entity
public class Product {

    @Id
    private int prodId;
    private String prodName;
    private int prodPrice;

    public Product( int prodId, String prodName, int prodPrice) {
        this.prodName = prodName;
        this.prodId = prodId;
        this.prodPrice = prodPrice;
    }

    public Product() {

    }

    public int getProdId() {
        return prodId;
    }

    public void setProdId(int prodId) {
        this.prodId = prodId;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public int getProdPrice() {
        return prodPrice;
    }

    public void setProdPrice(int prodPrice) {
        this.prodPrice = prodPrice;
    }

    @Override
    public String toString() {
        return "Product{" +
                "prodId=" + prodId +
                ", prodName='" + prodName + '\'' +
                ", prodPrice=" + prodPrice +
                '}';
    }
}
