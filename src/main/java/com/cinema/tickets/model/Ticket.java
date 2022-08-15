package com.cinema.tickets.model;

import javax.persistence.*;

@Entity
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cinema_id")
    private Long id;

    private String number;
    private boolean used;
    
//    private Cinema cinema;


    public Ticket(String number) {
        this.number = number;
        this.used=false;
    }
    public Ticket(){}

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public boolean isUsed() {
        return used;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }
}
