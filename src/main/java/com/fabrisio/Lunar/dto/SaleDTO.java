package com.fabrisio.Lunar.dto;

import com.fabrisio.Lunar.enuns.FormPaymentEnum;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class  SaleDTO { 
	
	private UUID id;
		
	private CashierDTO cashier;
		
	private EmployeeDTO employee;
		
	private ClientDTO client;
		
	private SaleItemDTO saleItem;
		
	private BigDecimal balance;
		
	private Boolean active;
		
	private FormPaymentEnum formPayment;
		
	private LocalDateTime createAt;
		
	private LocalDateTime updateAt;
		
}
