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
        Stream.of(
                new Company(
                        "rainbow",
                        "rainbow@com",
                        "l2323"
                ), new Company(
                        "yes",
                        "yes@gm",
                        "223354"
                ), new Company(
                        "bug",
                        "2njk@jkj",
                        "545454"
                ), new Company(
                        "sports",
                        "sp@hopj",
                        "443219"
                )).map(companyDao::addCompany)
                .forEach(System.out::println);
    }

    @Test
    void update() {

        try {

            Function<Company, Company> mapper = company -> {
                company.setName("Yoshi");
                return company;
            };

            Company updated = companyDao.updateCompany(mapper, 2L);
            System.out.println(updated);

        } catch (IllegalStateException | DoesntExistsException e) {
            System.out.println(e.getMessage());
        }
    }

}


