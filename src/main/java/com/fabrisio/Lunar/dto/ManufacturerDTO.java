package com.fabrisio.Lunar.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class  ManufacturerDTO { 
	
	private UUID id;
		
	private String name;
		
	private String cnpj;
		
	private LocalDateTime createAt;
		
	private LocalDateTime updateAt;
		
}
