package com.enosh.springdeom.repository;

import com.enosh.springdeom.model.Company;
import com.enosh.springdeom.model.Coupon;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CouponRepository extends CrudRepository<Coupon, Long> {
}
