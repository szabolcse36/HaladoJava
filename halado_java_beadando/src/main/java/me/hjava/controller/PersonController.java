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
import me.hjava.model.Detail;
import me.hjava.model.Person;
import me.hjava.repository.PersonRepository;


@RestController
@RequestMapping("/people")
public class PersonController {

	@Autowired
	private PersonRepository personRepo;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Collection<Person>> getPeople() {
		return new ResponseEntity<>(personRepo.findAll(), HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Person> getPerson(@PathVariable long id) {
		Person person = personRepo.findOne(id);

		if (person != null) {
			return new ResponseEntity<>(personRepo.findOne(id), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> addPerson(@RequestBody Person person) {
		return new ResponseEntity<>(personRepo.save(person), HttpStatus.CREATED);
	}
	
	

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deletePerson(@PathVariable long id) {
		personRepo.delete(id);
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}/events", method = RequestMethod.GET)
	public ResponseEntity<Collection<Event>> getPersonEvents(@PathVariable long id) {
		Person person = personRepo.findOne(id);

		if (person != null) {
			return new ResponseEntity<>(person.getEvents(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value = "/{id}/details", method = RequestMethod.GET)
	public ResponseEntity<Collection<Detail>> getPersonDetails(@PathVariable long id) {
		Person person = personRepo.findOne(id);

		if (person != null) {
			return new ResponseEntity<>(person.getDetails(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}

}
