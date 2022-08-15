package com.cinema.tickets.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Cinema {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title, author, full_text, genre, hour,nameImg;
    private int grade;

    @OneToMany(cascade = CascadeType.ALL,
            orphanRemoval = true,fetch = FetchType.EAGER)
    private List<Ticket> tickets ;

    public Cinema(String title, String author, String full_text, String genre, String hour, String nameImg, int grade) {
        this.title = title;
        this.author = author;
        this.full_text = full_text;
        this.genre = genre;
        this.hour = hour;
        this.nameImg = nameImg;
        this.grade = grade;
        this.tickets=new ArrayList<>();
        for (char i = 'A';i<83;i++){
            for (int j=1;j<19;j++){
                this.tickets.add(new Ticket(i+""+j));
            }
        }


    }
    public Cinema(String title, String author, String full_text, String genre, String hour) {
        this.title = title;
        this.author = author;
        this.full_text = full_text;
        this.genre = genre;
        this.hour = hour;
        this.nameImg = "";
        this.grade = 200;
        this.tickets=new ArrayList<>();
        for (char i = 'A';i<83;i++){
            for (int j=1;j<19;j++){
                this.tickets.add(new Ticket(i+""+j));
            }
        }


    }
    public Cinema(String title, String author, String full_text, String genre, String hour,String nameImg) {
        this.title = title;
        this.author = author;
        this.full_text = full_text;
        this.genre = genre;
        this.hour = hour;
        this.nameImg = "";
        this.grade = 200;
        this.tickets=new ArrayList<>();
        for (char i = 'A';i<83;i++){
            for (int j=1;j<19;j++){
                this.tickets.add(new Ticket(i+""+j));
            }
        }
        this.nameImg = nameImg;


    }
    public Cinema(){}

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getFull_text() {
        return full_text;
    }

    public void setFull_text(String full_text) {
        this.full_text = full_text;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getNameImg() {
        return nameImg;
    }

    public void setNameImg(String nameImg) {
        this.nameImg = nameImg;
    }
}
