package com.sistema.alunos.repository;

import com.sistema.alunos.model.Course;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<Course, String> {

}
