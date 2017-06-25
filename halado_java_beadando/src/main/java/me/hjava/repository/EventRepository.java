package me.hjava.repository;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import me.hjava.model.Event;

@Repository
public interface EventRepository extends CrudRepository<Event, Long> {
	
	Collection<Event> findAll();

}
