package com.example.l2cachecollections.service;

import com.example.l2cachecollections.entity.SimpleEntity;
import com.example.l2cachecollections.repository.SimpleEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SimpleEntityService {

    private final SimpleEntityRepository simpleEntityRepository;

    @Transactional
    public SimpleEntity save(SimpleEntity simpleEntity) {
        return simpleEntityRepository.save(simpleEntity);
    }

    @Transactional(readOnly = true)
    public Optional<SimpleEntity> findById(Long simpleEntityId) {
        return simpleEntityRepository.findById(simpleEntityId);
    }
}
