package com.fabrisio.Lunar.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class  CashierDTO { 
	
	private UUID id;
		
	private CompanyDTO company;
		
	private EmployeeDTO employee;
		
	private LocalDateTime openAt;
		
	private LocalDateTime closeAt;
		
}
