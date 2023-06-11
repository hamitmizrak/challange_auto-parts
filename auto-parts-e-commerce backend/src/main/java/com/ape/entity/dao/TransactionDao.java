package com.ape.entity.dao;

import com.ape.entity.concrete.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionDao extends JpaRepository<TransactionEntity,Long> {
}
