package com.enosh.springdeom.repository;

import com.enosh.springdeom.model.Company;
import com.enosh.springdeom.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {
}
