package com.aiTech.aispring.repository;

import com.aiTech.aispring.entity.Quiz;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface QuizRepository extends MongoRepository<Quiz, String> {
}
