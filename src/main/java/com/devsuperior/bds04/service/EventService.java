package com.devsuperior.bds04.service;

import com.devsuperior.bds04.dto.EventDTO;
import com.devsuperior.bds04.entities.City;
import com.devsuperior.bds04.entities.Event;
import com.devsuperior.bds04.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class EventService {

    @Autowired
    private EventRepository repository;


    @Transactional(readOnly = true)
    public Page<EventDTO> searchAllPaged(Pageable pageable){
        return repository.searchAllPaged(pageable).map(x -> new EventDTO(x));
    }

    @Transactional
    public EventDTO insert(EventDTO dto){
        Event entity = new Event();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setDate(dto.getDate());
        entity.setUrl(dto.getUrl());
        entity.setCity(new City(dto.getCityId(), null));

        entity = repository.save(entity);
        return new EventDTO(entity);

    }
}
