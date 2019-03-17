package com.jo.cscinfdel.repository;

import com.jo.cscinfdel.model.GrupoFocales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GrupoFocalesRepository extends
        JpaRepository<GrupoFocales, Integer>,
        PagingAndSortingRepository<GrupoFocales, Integer>,
        QuerydslPredicateExecutor<GrupoFocales> {


}
