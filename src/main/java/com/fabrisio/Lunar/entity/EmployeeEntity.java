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
@Table(name = "employee")
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", columnDefinition = "uuid", unique = true, nullable = false, updatable = false)
    private UUID id;
    	
    @Column(name = "name")
    private String name;
    	
    @Column(name = "last_name")
    private String lastName;
    	
    @Column(name = "cpf")
    private String cpf;
    	
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "office_id", referencedColumnName = "id")
    private OfficeEntity office;
    	
    @Column(name = "date_birth")
    private LocalDateTime dateBirth;
    	
    @Column(name = "cellphone")
    private String cellphone;
    	
    @Column(name = "email")
    private String email;
    	
    @Column(name = "active")
    private Boolean active;
    	
    @ManyToOne
    @JoinColumn(name="company_id", nullable=false)
    private CompanyEntity company;
    	
    @Column(name = "create_at")
    private LocalDateTime createAt;
    	
    @Column(name = "update_at")
    private LocalDateTime updateAt;
    	
}
