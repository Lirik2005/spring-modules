package com.lirik.database.repository;

import com.lirik.bpp.Auditing;
import com.lirik.bpp.Transaction;
import com.lirik.database.entity.Company;
import com.lirik.database.pool.ConnectionPool;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;

@Slf4j
@Repository
@Transaction
@Auditing
@RequiredArgsConstructor
public class CompanyRepository implements CrudRepository<Integer, Company> {

    private final ConnectionPool pool1;

    private final List<ConnectionPool> pools;

    @Value("${db.pool.size}")
    private final Integer poolSize;

    @PostConstruct
    private void init() {
        log.warn("init company repository");
    }

    @Override
    public Optional<Company> findById(Integer id) {
        System.out.println("find by id...");
        return Optional.of(new Company(id));
    }

    @Override
    public void delete(Company entity) {
        System.out.println("delete");

    }
}
