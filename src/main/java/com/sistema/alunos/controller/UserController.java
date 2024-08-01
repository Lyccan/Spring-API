package com.sistema.alunos.controller;


import com.sistema.alunos.repository.SearchRepository;
import com.sistema.alunos.repository.UserRepository;
import com.sistema.alunos.model.Course;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;


@RestController
@CrossOrigin(origins={"http://localhost:8080", "http://127.0.0.1:5500"})
public class UserController {
    @Autowired
    UserRepository repository;

    @Autowired
    SearchRepository searchRepository;

    @RequestMapping(value="/createuser")
    public void redirectCreateUser(HttpServletResponse response) throws IOException {
        response.sendRedirect("/users");
    }
    @RequestMapping(value="/")
    public void redirectHome(HttpServletResponse response) throws  IOException {
        response.sendRedirect("/users");

}

    @GetMapping("/users")
    public List<Course> getAllUsers() {
        return repository.findAll();
    }

    @GetMapping("/searchusers/{text}")
    public List<Course> searchUser(@PathVariable("text") String text) {
        return searchRepository.findByText(text);
    }

    @PostMapping("/createuser")
    public Course createUser(@RequestBody Course course) {
        return  repository.save(course);
    }


    @DeleteMapping("/delete/{_id}")
    public ResponseEntity<?> deleteUser(@PathVariable("_id") String _id) {
        repository.deleteById(_id);
        return ResponseEntity.ok().build();
    }
}
