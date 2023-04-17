package com.fabrisio.Lunar.dto;

import com.fabrisio.Lunar.enuns.TypeMovementEnum;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class  StockMovementDTO { 
	
	private UUID id;
		
	private Long amount;
		
	private StockDTO stock;
		
	private TypeMovementEnum type;
		
	private LocalDateTime createAt;
		
	private LocalDateTime updateAt;
		
}
