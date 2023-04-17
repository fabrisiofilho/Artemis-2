package com.fabrisio.Lunar.entity;
	
import lombok.*;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

	
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "cashier")
public class CashierEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", columnDefinition = "uuid", unique = true, nullable = false, updatable = false)
    private UUID id;
    	
    @ManyToOne
    @JoinColumn(name="company_id", nullable=false)
    private CompanyEntity company;
    	
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    private EmployeeEntity employee;
    	
    @Column(name = "open_at")
    private LocalDateTime openAt;

    @Column(name = "close_at")
    private LocalDateTime closeAt;

}
