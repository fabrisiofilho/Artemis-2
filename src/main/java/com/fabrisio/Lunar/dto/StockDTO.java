package com.fabrisio.Lunar.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class  StockDTO { 
	
	private UUID id;
		
	private ProductDTO product;
		
	private Long amount;
		
	private LocalDateTime createAt;
		
	private LocalDateTime updateAt;
		
}
