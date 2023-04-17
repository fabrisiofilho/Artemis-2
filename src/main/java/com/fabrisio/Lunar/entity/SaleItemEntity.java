package com.fabrisio.Lunar.entity;
	
import lombok.*;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

	
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "sale_item")
public class SaleItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", columnDefinition = "uuid", unique = true, nullable = false, updatable = false)
    private UUID id;
    	
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private ProductEntity product;
    	
    @ManyToOne
    @JoinColumn(name="sale_id", nullable=false)
    private SaleEntity sale;
    	
    @Column(name = "amount")
    private Long amount;
    	
    @Column(name = "balance")
    private BigDecimal balance;
    	
    @Column(name = "discount")
    private Long discount;
    	
    @Column(name = "create_at")
    private LocalDateTime createAt;
    	
    @Column(name = "update_at")
    private LocalDateTime updateAt;
    	
}
