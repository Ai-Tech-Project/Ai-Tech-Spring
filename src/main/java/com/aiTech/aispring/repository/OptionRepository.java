package com.aiTech.aispring.repository;

import com.aiTech.aispring.entity.Option;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface OptionRepository extends MongoRepository<Option,String> {
}
