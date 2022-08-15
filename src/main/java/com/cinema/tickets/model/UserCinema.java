package com.cinema.tickets.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
public class UserCinema {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_cinema_id")
    private Long id;

    private String title;

    @ElementCollection(targetClass = String.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_ticked", joinColumns = @JoinColumn(name = "user_ticket_id"))
    private List<String> tickets = new ArrayList<>();
    public UserCinema(){}




    public UserCinema(String title, List<String> tickets) {
        this.title = title;
        this.tickets = tickets;
    }

    public String getTicketsStr(){
        String ret = "";
        for (String s :tickets) {
            ret+=s+" ";
        }

        return ret;
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

    public List<String> getTickets() {
        return tickets;
    }

    public void setTickets(List<String> tickets) {
        this.tickets = tickets;
    }
}
