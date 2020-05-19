package com.enosh.springdeom.dao;

import com.enosh.springdeom.exceptions.DoesntExistsException;
import com.enosh.springdeom.model.Company;
import com.enosh.springdeom.repository.CompanyRepository;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import static org.apache.commons.codec.digest.DigestUtils.*;

@Component
public class CompanyDbdao implements CompanyDao {

    private final CompanyRepository repository;

    public CompanyDbdao(CompanyRepository repository) {
        this.repository = repository;
    }

    @Override
    public boolean existsByEmailAndPassword(String email, String password) {
        return repository.existsByEmailAndPassword(email, md5Hex(password));
    }

    @Override
    public Company addCompany(Company company) throws IllegalStateException {
        company.setPassword(md5Hex(company.getPassword()));
        return repository.save(company);
    }

    @Override
    public Company updateCompany(Function<Company, Company> mapper, Long id) throws DoesntExistsException, IllegalStateException {
        return findById(id)
                .map(byId -> mapper.andThen(repository::save).apply(byId))
                .orElseThrow(() -> new DoesntExistsException(
                        "Company by the id " + id +
                                "Does not exists in order to update"
                ));
    }

    @Override
    public Company deleteCompany(Long id) throws DoesntExistsException {
        return null;
    }

    @Override
    public List<Company> findAll() {
        List<Company> companies = new ArrayList<>();
        repository.findAll().iterator().forEachRemaining(companies::add);
        return companies;
    }

    @Override
    public Optional<Company> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public boolean existsByName(String name) {
        return false;
    }

    @Override
    public boolean existsByEmail(String email) {
        return false;
    }
}
