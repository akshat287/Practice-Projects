package com.techieakshat.webApp.Controller;

import com.techieakshat.webApp.Model.Product;
import com.techieakshat.webApp.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class ProductController {


    @Autowired
    ProductService service;

    @GetMapping("/products")
    public List<Product> getProducts(){
        return service.getProducts();
    }

    @GetMapping("/products/{prodId}")
    public Product getProductById(@PathVariable int prodId){
        return service.getProductById(prodId);
    }

    @PostMapping("/products")
    public void addProduct(@RequestBody Product prod){
        service.addProduct(prod);
    }

    @PutMapping("/products")
    public void updateProd(@RequestBody Product prod){
        service.updateProd(prod);
    }

    @DeleteMapping("/products/{id}")
    public void deleteProd(@PathVariable int id){
        service.deleteProduct(id);
    }
}
