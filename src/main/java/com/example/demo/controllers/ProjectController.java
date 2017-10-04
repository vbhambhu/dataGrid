package com.example.demo.controllers;

import com.example.demo.models.Form;
import com.example.demo.models.Project;
import com.example.demo.repositories.FormRepository;
import com.example.demo.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
public class ProjectController {

    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    FormRepository formRepository;

    @RequestMapping(value = "/projects", method = RequestMethod.GET)
    public String showProjects(Model model){
        model.addAttribute("projects", projectRepository.findAll());
        return "home";
    }

    @RequestMapping(value = "/project", method = RequestMethod.GET)
    public String showProject(Model model, @RequestParam(value = "pid", required = true) String projectId){
        model.addAttribute("project", projectRepository.findById(projectId));
        model.addAttribute("forms", formRepository.findAllByProjectId(projectId));
        return "projects/view";
    }


    @RequestMapping(value = "/form/add", method = RequestMethod.GET)
    public String addProject(Model model, Form form,
             @RequestParam(value = "pid", required = true) String projectId){
        model.addAttribute("projectId", projectId);
        return "projects/addform";
    }

    @RequestMapping(value = "/form/add", method = RequestMethod.POST)
    public String createProject(Model model,@Valid Form form,
                             @RequestParam(value = "pid", required = true) String projectId,
                                BindingResult bindingResult) {

        model.addAttribute("projectId", projectId);



        if (bindingResult.hasErrors()) {
            return "projects/addform";
        } else{
            formRepository.save(form);
            return "redirect:/project?pid="+projectId;
        }

    }



    }
