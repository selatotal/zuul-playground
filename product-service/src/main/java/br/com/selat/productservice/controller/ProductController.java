package br.com.selat.productservice.controller;

import br.com.selat.productservice.client.UserService;
import br.com.selat.productservice.entities.Product;
import br.com.selat.productservice.entities.User;
import br.com.selat.productservice.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    private final ProductRepository productRepository;
    private final UserService userService;

    @Autowired
    public ProductController(ProductRepository productRepository, UserService userService) {
        this.productRepository = productRepository;
        this.userService = userService;
    }

    @GetMapping("/product")
    public Iterable<Product> getAll(){
        return productRepository.findAll();
    }

    @GetMapping("/product/{id}")
    public Product findById(@PathVariable Long id){

        Product product = productRepository.findById(id).orElse(new Product());
        if (product.getId() != null){
            User user = userService.findById(product.getUserId());
            product.setUser(user);
        }

        return product;
    }
}
