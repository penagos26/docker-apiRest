package com.uptc.frw.lafabrica.repository;

import com.uptc.frw.lafabrica.model.BookMy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookMyRepository extends JpaRepository<BookMy, Long> {
}
