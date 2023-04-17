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
@Table(name = "company")
public class CompanyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", columnDefinition = "uuid", unique = true, nullable = false, updatable = false)
    private UUID id;
    	
    @Column(name = "name")
    private String name;
    	
    @Column(name = "cnpj")
    private String cnpj;
    	
    @Column(name = "logo_url")
    private String logoUrl;
    	
    @Column(name = "create_at")
    private LocalDateTime createAt;
    	
    @Column(name = "update_at")
    private LocalDateTime updateAt;
    	
}
