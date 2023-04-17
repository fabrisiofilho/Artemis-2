package com.fabrisio.Lunar.entity;
	
import lombok.*;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

	
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "stock")
public class StockEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", columnDefinition = "uuid", unique = true, nullable = false, updatable = false)
    private UUID id;
    	
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private ProductEntity product;
    	
    @Column(name = "amount")
    private Long amount;
    	
    @Column(name = "create_at")
    private LocalDateTime createAt;
    	
    @Column(name = "update_at")
    private LocalDateTime updateAt;
    	
}
