package com.lirik.service;

import com.lirik.database.entity.Company;
import com.lirik.database.repository.CrudRepository;
import com.lirik.database.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final CrudRepository<Integer, Company> companyRepository;
}
