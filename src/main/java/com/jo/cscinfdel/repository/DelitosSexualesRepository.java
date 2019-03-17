package com.jo.cscinfdel.repository;

import com.jo.cscinfdel.model.DelitosSexuales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DelitosSexualesRepository extends
        JpaRepository<DelitosSexuales, Integer>,
        PagingAndSortingRepository<DelitosSexuales, Integer>,
        QuerydslPredicateExecutor<DelitosSexuales> {


}
