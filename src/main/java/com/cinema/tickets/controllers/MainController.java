package com.cinema.tickets.controllers;

import com.cinema.tickets.model.*;
import com.cinema.tickets.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {


    @Autowired
    private UserRepository userRepository;



    @GetMapping("/")
    public String home(Model model,Principal principal) {
        model.addAttribute("title", "Головна сторінка");
        if (principal!=null) {
            User activeUser = (User) ((Authentication) principal).getPrincipal();
            model.addAttribute("user", activeUser);
        }
            return "hom";

    }




}
