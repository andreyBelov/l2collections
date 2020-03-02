package com.example.l2cachecollections.service;

import com.example.l2cachecollections.entity.Parent;
import com.example.l2cachecollections.repository.ParentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ParentService {

    private final ParentRepository parentRepository;

    @Transactional
    public Parent save(Parent parent) {
        return parentRepository.save(parent);
    }

    @Transactional(readOnly = true)
    public Optional<Parent> findById(Long parentId) {
        return parentRepository.findById(parentId);
    }
}
