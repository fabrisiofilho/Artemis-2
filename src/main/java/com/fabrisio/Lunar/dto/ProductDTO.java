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
public class  ProductDTO { 
	
	private UUID id;
		
	private String name;
		
	private BigDecimal value;
		
	private LocalDateTime createAt;
		
	private LocalDateTime updateAt;
		
}
