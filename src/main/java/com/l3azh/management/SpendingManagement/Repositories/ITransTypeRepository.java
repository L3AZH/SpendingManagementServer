package com.l3azh.management.SpendingManagement.Repositories;

import com.l3azh.management.SpendingManagement.Entities.TransTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ITransTypeRepository extends JpaRepository<TransTypeEntity, UUID>{

    @Query(
            nativeQuery = true,
            value = "SELECT * FROM transtype tt WHERE tt.Name = :nameTransType"
    )
    Optional<List<TransTypeEntity>> getListTransTypeByName(String nameTransType);
}
