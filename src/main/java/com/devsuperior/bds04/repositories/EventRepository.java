package com.devsuperior.bds04.repositories;

import com.devsuperior.bds04.entities.Event;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

    @Query(value = "SELECT obj FROM Event obj JOIN FETCH obj.city")
    Page<Event> searchAllPaged(Pageable pageable);
}
