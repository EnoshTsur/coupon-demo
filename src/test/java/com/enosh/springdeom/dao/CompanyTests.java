package com.enosh.springdeom.dao;

import com.enosh.springdeom.exceptions.DoesntExistsException;
import com.enosh.springdeom.model.Company;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.function.Function;
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
                "Clalit",
                "cla@lit",
                "2345213"
        );

        Company afterSave = companyDao.addCompany(company);
        System.out.println(afterSave);
    }

    @Test
    void update() {


    }

}


