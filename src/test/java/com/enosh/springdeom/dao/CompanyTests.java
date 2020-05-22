package com.enosh.springdeom.dao;

import com.enosh.springdeom.exceptions.DoesntExistsException;
import com.enosh.springdeom.model.Company;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootTest
class CompanyTests {

    @Autowired
    private CompanyDao companyDao;

    @Test
    void contextLoads() {
    }

    @Test
    void add() {
        Company company = new Company(
                "",
                "l",
                "2345213"
        );

        Company afterSave = companyDao.addCompany(company);
        System.out.println(afterSave);
    }

    @Test
    void findById() {
        companyDao.findById(5L).ifPresent(System.out::println);
    }

    @Test
    void existsByEmailAndPassword() {

        System.out.println(
                companyDao.existsByEmailAndPassword("leu@mir", "2345213")
        );

    }

    @Test
    void update() {

        try {

            Company updated = companyDao.updateCompany(
                    company -> {
                        company.setEmail("lofo@folo");
                        return company;
                    },
                    50L
            );
            System.out.println(updated);

        } catch (DoesntExistsException e) {
            System.out.println(e.getMessage());
        }

    }

}

