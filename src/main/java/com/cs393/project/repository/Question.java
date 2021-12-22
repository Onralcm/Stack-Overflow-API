package com.cs393.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Question extends JpaRepository<Question, Integer> {
}
