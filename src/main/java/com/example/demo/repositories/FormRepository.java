package com.example.demo.repositories;


import com.example.demo.models.Form;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface FormRepository extends MongoRepository<Form, String> {

    Form findById(String id);

    List<Form> findAll();

    List<Form> findAllByProjectId(String projectId);
}
