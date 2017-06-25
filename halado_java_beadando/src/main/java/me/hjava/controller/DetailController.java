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
import me.hjava.model.Detail;
import me.hjava.repository.DetailRepository;

@RestController
@RequestMapping("/details")
public class DetailController {

	@Autowired
	private DetailRepository detailRepo;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Collection<Detail>> getDetail() {
		return new ResponseEntity<>(detailRepo.findAll(), HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Detail> getDetail(@PathVariable long id) {
		Detail detail = detailRepo.findOne(id);

		if (detail != null) {
			return new ResponseEntity<>(detailRepo.findOne(id), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> addDetail(@RequestBody Detail detail) {
		return new ResponseEntity<>(detailRepo.save(detail), HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteEventn(@PathVariable long id) {
		detailRepo.delete(id);

		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	

}