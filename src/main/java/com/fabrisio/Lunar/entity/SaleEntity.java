package com.fabrisio.Lunar.entity;

import com.fabrisio.Lunar.enuns.FormPaymentEnum;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

	
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "sale")
public class SaleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", columnDefinition = "uuid", unique = true, nullable = false, updatable = false)
    private UUID id;
    	
    @ManyToOne
    @JoinColumn(name="cashier_id", nullable=false)
    private CashierEntity cashier;
    	
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    private EmployeeEntity employee;
    	
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    private ClientEntity client;
    	
    @OneToMany(mappedBy = "sale", cascade = CascadeType.ALL)
    private List<SaleItemEntity> saleItem;
    	
    @Column(name = "balance")
    private BigDecimal balance;
    	
    @Column(name = "active")
    private Boolean active;
    	
    @Column(name = "form_payment")
    @Enumerated(EnumType.STRING)
    private FormPaymentEnum formPayment;
    	
    @Column(name = "create_at")
    private LocalDateTime createAt;
    	
    @Column(name = "update_at")
    private LocalDateTime updateAt;
    	
}
