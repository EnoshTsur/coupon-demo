package com.enosh.springdeom.repository;

import com.enosh.springdeom.model.Category;
import com.enosh.springdeom.model.CategoryType;
import com.enosh.springdeom.model.Company;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {

    Optional<Category> findByType(CategoryType type);
}
