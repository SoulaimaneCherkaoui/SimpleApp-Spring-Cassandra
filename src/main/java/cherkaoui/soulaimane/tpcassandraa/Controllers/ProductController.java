package cherkaoui.soulaimane.tpcassandraa.Controllers;

import cherkaoui.soulaimane.tpcassandraa.entities.Product;
import cherkaoui.soulaimane.tpcassandraa.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @PostMapping
    public Product addUser(@RequestParam String fName, @RequestParam double price, @RequestParam int quantite) {
        return productService.createUser(fName, price,quantite);
    }
    @GetMapping("/{id}")
    public Product getUser(@PathVariable UUID id) {
        return productService.getUser(id);
    }
    @GetMapping
    public List<Product> getAllUsers() {
        return productService.getAllUsers();
    }
}

