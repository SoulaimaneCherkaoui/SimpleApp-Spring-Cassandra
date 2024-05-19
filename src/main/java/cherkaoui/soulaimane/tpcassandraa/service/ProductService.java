package cherkaoui.soulaimane.tpcassandraa.service;

import cherkaoui.soulaimane.tpcassandraa.entities.Product;
import cherkaoui.soulaimane.tpcassandraa.repositories.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
public class ProductService {
    private final ProductRepo productRepository;
    @Autowired
    public ProductService(ProductRepo productRepository) {
        this.productRepository = productRepository;
    }
    public Product createUser(String Fname, double price,int quatite) {
        Product product = new Product();
        product.setId(UUID.randomUUID());
        product.setName(Fname);
        product.setPrice(price);
        product.setQuantiteStock(quatite);


        return productRepository.save(product);
    }
    public Product getUser(UUID id) {
        return productRepository.findById(id).get();
    }
    public List<Product> getAllUsers() {
        return productRepository.findAll();
    }
}
