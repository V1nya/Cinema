package com.cinema.tickets.controllers;

import com.cinema.tickets.model.Cinema;
import com.cinema.tickets.model.User;
import com.cinema.tickets.repository.CinemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller

@PreAuthorize("hasAuthority('Admin')")
public class AdminController {
    @Autowired
    CinemaRepository cinemaRepository;


//    @GetMapping("/admin")
//    public String admin(Model model) {
//
//        return "admin-main";
//    }

    @GetMapping("/addFilm")
    public String addf(Principal principal,Model model) {
        model.addAttribute("user",(User) ((Authentication) principal).getPrincipal());

        return "addFilm";
    }

    @PostMapping("/addFilm")
    public String add_film(@RequestParam(value = "title") String tile,
                           @RequestParam(value = "genre") String genre,
                           @RequestParam(value = "author") String author,
                           @RequestParam(value = "hour") String hour,
                           @RequestParam(value = "full_text") String full_text,
                           Principal principal
            , Model model) {
        cinemaRepository.save(new Cinema(tile, author, full_text, genre, hour));
        model.addAttribute("user",(User) ((Authentication) principal).getPrincipal());
        return "addFilm";
    }

    @GetMapping("/deleteFilm")
    public  String delFil(Principal principal,Model model){
        model.addAttribute("user",(User) ((Authentication) principal).getPrincipal());
        model.addAttribute("cinemas",cinemaRepository.findAll());
        return "deleteFilm";
    }
    @PostMapping("/deleteFilm")
    public  String delF(Principal principal,Model model,@RequestParam(value = "cinema_id") long id){
        cinemaRepository.delete(cinemaRepository.getById(id));
        model.addAttribute("user",(User) ((Authentication) principal).getPrincipal());
        model.addAttribute("cinemas",cinemaRepository.findAll());
        return "deleteFilm";
    }

//    @GetMapping("/films{id}")
//    public String filmDetails(@PathVariable(value = "id") long id, Model model) {
//        model.addAttribute("title", "Головна сторінка");
//        return "films";
//    }
}
