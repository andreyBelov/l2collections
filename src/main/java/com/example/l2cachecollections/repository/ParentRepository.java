package com.example.l2cachecollections.repository;

import com.example.l2cachecollections.entity.Parent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParentRepository extends JpaRepository<Parent, Long> {
}
