package com.ape.entity.dao;

import com.ape.entity.concrete.CategoryEntity;
import com.ape.entity.enums.CategoryStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface CategoryDao extends JpaRepository<CategoryEntity,Long> {

    Boolean existsByTitle(String title);

    @Query("SELECT c from CategoryEntity c WHERE c.status=:status and c.id=:id")
    Optional<CategoryEntity> getCategoryByStatusPublishedAndId(@Param("status") CategoryStatus status, @Param("id") Long id);

}
