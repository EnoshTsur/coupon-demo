package com.enosh.springdeom.dao;

import com.enosh.springdeom.exceptions.DoesntExistsException;
import com.enosh.springdeom.model.Company;
import org.springframework.stereotype.Service;

import java.util.function.Function;


@Service
public interface CompanyDao {

    boolean existsByEmailAndPassword(String email, String password);

    Company addCompany(Company company) throws IllegalStateException;

    Company updateCompany(Function<Company, Company> mapper, Long id) throws DoesntExistsException;
}
