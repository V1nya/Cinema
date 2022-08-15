package com.cinema.tickets.repository;

import com.cinema.tickets.model.UserCinema;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserCinemaRepository extends JpaRepository<UserCinema, Long> {
}
