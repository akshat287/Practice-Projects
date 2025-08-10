package com.example.Ecom_web.Service;

import com.example.Ecom_web.Model.Product;
import com.example.Ecom_web.Repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepo repo;

    public List<Product> getAllProducts(){
        return repo.findAll();
    }

    public Product addProduct(Product prod, MultipartFile img) throws IOException {
        prod.setImageName(img.getOriginalFilename());
        prod.setImageType(img.getContentType());
        prod.setImageData(img.getBytes());
        return repo.save(prod);
    }

    public Product getProductById(int id) {
        return repo.findById(id).orElse(new Product());
    }

    public Product updateProduct(int id, Product prod, MultipartFile img) throws IOException {
        prod.setImageData(img. getBytes());
        prod.setImageName(img.getOriginalFilename());
        prod.setImageType(img.getContentType());
        return repo.save(prod);

    }

    public void deleteProduct(int id) {
        repo.deleteById(id);
    }

//    public void addProduct(Product prod) {
//        repo.save(prod);
//    }
}
