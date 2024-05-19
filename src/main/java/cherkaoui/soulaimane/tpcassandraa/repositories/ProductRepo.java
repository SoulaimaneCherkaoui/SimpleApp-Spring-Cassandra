package cherkaoui.soulaimane.tpcassandraa.repositories;

import cherkaoui.soulaimane.tpcassandraa.entities.Product;
import org.springframework.data.cassandra.repository.CassandraRepository;

import java.util.UUID;

public interface ProductRepo extends CassandraRepository<Product, UUID> {

}
