package me.hjava.repository;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import me.hjava.model.Detail;

@Repository
public interface DetailRepository extends CrudRepository<Detail, Long> {
	
	Collection<Detail> findAll();

}
