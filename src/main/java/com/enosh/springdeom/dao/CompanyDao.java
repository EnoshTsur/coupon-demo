package com.enosh.springdeom.dao;

import com.enosh.springdeom.exceptions.DoesntExistsException;
import com.enosh.springdeom.model.Company;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;


@Service
public interface CompanyDao {

    boolean existsByEmailAndPassword(String email, String password);

    Company addCompany(Company company) throws IllegalStateException;

    Company updateCompany(Function<Company, Company> mapper, Long id)
            throws DoesntExistsException, IllegalStateException;

    Company deleteCompany(Long id) throws DoesntExistsException;

    List<Company> findAll();

    Optional<Company> findById(Long id);

    boolean existsByName(String name);

    boolean existsByEmail(String email);
}
