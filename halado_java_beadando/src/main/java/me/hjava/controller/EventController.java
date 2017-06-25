package me.hjava.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import me.hjava.model.Event;
import me.hjava.repository.EventRepository;

@RestController
@RequestMapping("/events")
public class EventController {

	@Autowired
	private EventRepository eventRepo;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Collection<Event>> getEvents() {
		return new ResponseEntity<>(eventRepo.findAll(), HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Event> getEvent(@PathVariable long id) {
		Event event = eventRepo.findOne(id);

		if (event != null) {
			return new ResponseEntity<>(eventRepo.findOne(id), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> addEvent(@RequestBody Event event) {
		return new ResponseEntity<>(eventRepo.save(event), HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteEventn(@PathVariable long id) {
		eventRepo.delete(id);

		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
