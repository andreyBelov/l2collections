package com.example.l2cachecollections.repository;

import com.example.l2cachecollections.entity.SimpleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SimpleEntityRepository extends JpaRepository<SimpleEntity, Long> {
}
