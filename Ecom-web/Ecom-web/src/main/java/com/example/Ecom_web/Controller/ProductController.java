package com.example.Ecom_web.Controller;



import com.example.Ecom_web.Model.Product;
import com.example.Ecom_web.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;


@RestController
@CrossOrigin
@RequestMapping("/indokart")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping("/products")
    public List<Product> getProduct(){
        return service.getAllProducts();
    }

//    @PostMapping("/products")
//    public void addProduct(@RequestBody Product prod){
//        service.addProduct(prod);
//    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable int id){
        Product prod=service.getProductById(id);
        if(prod!=null)return new ResponseEntity<>(prod, HttpStatus.OK);
        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/product")
    public ResponseEntity<?> addProduct(@RequestPart Product prod,
                                        @RequestPart MultipartFile img){
        try{
            Product prod1=service.addProduct(prod,img);
            return new ResponseEntity<>(prod1,HttpStatus.CREATED);
        } catch (RuntimeException | IOException e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/product/{id}/image")
    public ResponseEntity<byte[]> getImageById(@PathVariable int id){
        Product prod=service.getProductById(id);
        byte[] img=prod.getImageData();

        return ResponseEntity.ok().contentType(MediaType.valueOf(prod.getImageType())).body(img);
    }

    @PutMapping("/product/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable int id,
                                                @RequestPart Product prod,
                                                @RequestPart MultipartFile img) throws IOException {
        Product prod1=service.updateProduct(id,prod,img);
        if(prod1!=null)return new ResponseEntity<>("updated",HttpStatus.OK);
        else return new ResponseEntity<>("failed to update",HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable int id){
        Product prod=service.getProductById(id);
        if(prod!=null) {
            service.deleteProduct(id);
            return new ResponseEntity<>("Deleted!!",HttpStatus.OK);
        }
        else return new ResponseEntity<>("Erorr: Product not found!!",HttpStatus.NOT_FOUND);
    }

}
