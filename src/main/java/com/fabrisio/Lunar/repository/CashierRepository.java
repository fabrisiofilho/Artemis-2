package com.fabrisio.Lunar.repository;

import com.fabrisio.Lunar.entity.CashierEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CashierRepository extends JpaRepository<CashierEntity, UUID>  {
}
