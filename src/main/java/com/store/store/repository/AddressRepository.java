package com.store.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.store.store.model.Address;

public interface AddressRepository extends JpaRepository<Address, Integer> {
    
}
