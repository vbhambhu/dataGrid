package com.example.demo.repositories;

import com.example.demo.models.Project;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ProjectRepository extends MongoRepository<Project, String> {

    Project findById(String id);

    List<Project> findAll();

}
