package com.store.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.store.store.model.Address;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Integer> {


}
