package com.jo.cscinfdel.repository;

import com.jo.cscinfdel.model.MomentoAccidente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MomentoAccidenteRepository extends
        JpaRepository<MomentoAccidente, Integer>,
        PagingAndSortingRepository<MomentoAccidente, Integer>,
        QuerydslPredicateExecutor<MomentoAccidente> {

}
