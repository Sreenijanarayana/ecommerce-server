package com.sree.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sree.model.Address;



public interface AddressRepository extends JpaRepository<Address, Long> {

}
