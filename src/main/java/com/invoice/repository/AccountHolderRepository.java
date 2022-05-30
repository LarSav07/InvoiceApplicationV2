package com.invoice.repository;

import com.invoice.entity.AccountHolder;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountHolderRepository extends JpaRepository <AccountHolder, Long> {

}
