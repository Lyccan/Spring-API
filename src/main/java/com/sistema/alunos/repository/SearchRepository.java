package com.sistema.alunos.repository;

import com.sistema.alunos.model.Course;

import java.util.List;


public interface SearchRepository {
    List<Course> findByText(String text);
}
