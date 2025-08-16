package com.techieakshat.webApp.Service;

import com.techieakshat.webApp.Model.Product;
import com.techieakshat.webApp.Repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductService {

    @Autowired
    ProductRepo repo;

//    List<Product> products=new ArrayList<>(Arrays.asList(
//            new Product(01,"Samsung ka phone",80000),
//            new Product(02,"Jio-Phone",1500),
//            new Product(03,"Iphone",120000)
//    ));

    public List<Product> getProducts(){
        return repo.findAll();
    }

//    public List<Product> getProducts(){
//        return products;
//    }

    public Product getProductById(int proId){
        return repo.findById(proId).orElse(new Product());
    }

//    public Product getProductById(int prodId) {
//        return products.stream().filter(p->p.getProdId()==prodId).findFirst().orElse(new Product(00,"Null",0));
//    }

    public void addProduct(Product prod){
        repo.save(prod);
    }

//    public void addProduct(Product prod){
//        products.add(prod);
//    }

    public void updateProd(Product prod){
        repo.save(prod);
    }

//    public void updateProd(Product prod) {
//        int index=0;
//        for(int i=0;i<products.size();i++)
//            if(products.get(i).getProdId()==prod.getProdId())index=i;
//        products.set(index,prod);
//    }

    public void deleteProduct(int id){
        repo.deleteById(id);
    }

//    public void deleteProduct(int id) {
//        int index=0;
//        for(int i=0;i<products.size();i++)
//            if(products.get(i).getProdId()==id)index=i;
//        products.remove(index);
//    }
}
