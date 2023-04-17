package com.fabrisio.Lunar.entity;
	
import com.fabrisio.Lunar.enuns.TypeMovementEnum;
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
@Table(name = "stock_movement")
public class StockMovementEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", columnDefinition = "uuid", unique = true, nullable = false, updatable = false)
    private UUID id;
    	
    @Column(name = "amount")
    private Long amount;
    	
    @ManyToOne
    @JoinColumn(name="stock_id", nullable=false)
    private StockEntity stock;
    	
    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private TypeMovementEnum type;
    	
    @Column(name = "create_at")
    private LocalDateTime createAt;
    	
    @Column(name = "update_at")
    private LocalDateTime updateAt;
    	
}
