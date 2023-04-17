package com.fabrisio.Lunar.dto;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class  SaleItemDTO { 
	
	private UUID id;
		
	private ProductDTO product;
		
	private SaleDTO sale;
		
	private Long amount;
		
	private BigDecimal balance;
		
	private Long discount;
		
	private LocalDateTime createAt;
		
	private LocalDateTime updateAt;
		
}
