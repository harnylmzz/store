package com.store.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.store.store.model.Address;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Integer> {

    List<Address> findByCountry(String country);

    List<Address> findByCity(String city);

    List<Address> findByCountryAndCity(String country, String city);

    List<Address> findByZipCode(String zipCode);

    List<Address> findByCountryStartingWith(String country);

    List<Address> findByCityStartingWith(String city);

    List<Address> findByCountryEndingWith(String country);

    List<Address> findByCityEndingWith(String city);

    List<Address> findByCountryContaining(String country);

    List<Address> findByCityContaining(String city);

    List<Address> findByCountryAndCityContaining(String country, String city);

    List<Address> findByCountryAndCityContainingStartingWith(String country, String city);

    List<Address> findByCountryAndCityContainingEndingWith(String country, String city);

}
