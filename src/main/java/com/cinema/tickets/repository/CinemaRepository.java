package com.cinema.tickets.repository;

import com.cinema.tickets.model.Cinema;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CinemaRepository extends JpaRepository< Cinema,Long> {


}
