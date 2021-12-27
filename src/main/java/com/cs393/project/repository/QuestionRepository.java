package com.cs393.project.repository;

import com.cs393.project.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Integer> {
    @Query("select distinct q from Question q inner join q.tags t where t.tag in ?1")
    List<Question> findAllFromTags(List<String> tags);
}
