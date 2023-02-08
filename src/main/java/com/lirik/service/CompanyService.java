package com.lirik.service;

import com.lirik.database.entity.Company;
import com.lirik.database.repository.CrudRepository;
import com.lirik.dto.CompanyReadDto;
import com.lirik.listener.entity.AccessType;
import com.lirik.listener.entity.EntityEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CompanyService {

    private final UserService userService;

    private final CrudRepository<Integer, Company> companyRepository;

    private final ApplicationEventPublisher eventPublisher;

    public Optional<CompanyReadDto> findById(Integer id) {
        return companyRepository.findById(id)
                                .map(entity -> {
                                    eventPublisher.publishEvent(new EntityEvent(entity, AccessType.READ));
                                    return new CompanyReadDto(entity.id());
                                });
    }

}
