package com.aiTech.aispring.repository;

import com.aiTech.aispring.entity.Question;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface QuestionRepository extends MongoRepository<Question, String> {
}
