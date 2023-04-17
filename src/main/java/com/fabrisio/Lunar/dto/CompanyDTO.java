package com.fabrisio.Lunar.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class  CompanyDTO { 
	
	private UUID id;
		
	private String name;
		
	private String cnpj;
		
	private String logoUrl;
		
	private LocalDateTime createAt;
		
	private LocalDateTime updateAt;
		
}
