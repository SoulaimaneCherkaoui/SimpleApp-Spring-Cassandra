## Créer un keyspace ecommerce dans Cassandra et une table products avec les colonnes suivantes:

![image](https://github.com/SoulaimaneCherkaoui/SimpleApp-Spring-Cassandra/assets/133413185/ed4ebbab-7de4-4a6f-bee0-b849d339d7d7)

## Créer une entité Product pour réaliser les opérations d'accès à la base données.


@Table("users")
@NoArgsConstructor@AllArgsConstructor@Getter@Setter@ToString
public class Product {
    @PrimaryKey
    private UUID id;
    private String name;
    private double price;
    private int quantiteStock;
}

## Créer un repository ProductRepository


public interface ProductRepo extends CassandraRepository<Product, UUID> {

}

## Créer un service ProductService qui réalise les opérations CRUD de base et donne la possibilité de chercher des produits par mot clé.


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

## Créer un controller ProductController qui expose les diffirentes fonctionlités de l'application.


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

## Tester les opérations avec un outil comme Postman.
### GET :
![image](https://github.com/SoulaimaneCherkaoui/SimpleApp-Spring-Cassandra/assets/133413185/68ae0ccb-aa42-4f0f-ab06-f8d68db88bd3)
 ### POST :
 ![image](https://github.com/SoulaimaneCherkaoui/SimpleApp-Spring-Cassandra/assets/133413185/1bbc6a6f-7b54-4524-a44c-cf4b11e8b9ac)

By Soulaimane CHERKAOUI
