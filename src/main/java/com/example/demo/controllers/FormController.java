package com.example.demo.controllers;

import com.example.demo.models.Form;
import com.example.demo.repositories.FormRepository;
import com.example.demo.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class FormController {

    @Autowired
    FormRepository formRepository;

    public String projectForms(Model model,
                               @RequestParam(value = "pid", required = true) String projectId){

        List<Form> formList = formRepository.findAllByProjectId(projectId);
        model.addAttribute("forms", formList);
        return "project/listforms";

    }
}
