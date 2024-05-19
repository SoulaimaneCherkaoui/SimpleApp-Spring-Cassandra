package cherkaoui.soulaimane.tpcassandraa.entities;

import lombok.*;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.UUID;

@Table("users")
@NoArgsConstructor@AllArgsConstructor@Getter@Setter@ToString
public class Product {
    @PrimaryKey
    private UUID id;
    private String name;
    private double price;
    private int quantiteStock;
}
