package com.fabrisio.Lunar.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class  EmployeeDTO { 
	
	private UUID id;
		
	private String name;
		
	private String lastName;
		
	private String cpf;
		
	private OfficeDTO office;
		
	private LocalDateTime dateBirth;
		
	private String cellphone;
		
	private String email;
		
	private Boolean active;
		
	private CompanyDTO company;
		
	private LocalDateTime createAt;
		
	private LocalDateTime updateAt;
		
}
