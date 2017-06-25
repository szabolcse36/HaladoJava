package me.hjava.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "events")
public class Event {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "event_id")
	private long id;

	private String location;

	@Column(name = "event_date")
	@JsonFormat(pattern = "YYYY-MM-dd")
	private Date date;

	@ManyToMany
	@JoinTable(name = "people_events", 
		joinColumns = @JoinColumn(name = "event_id", referencedColumnName = "event_id"), 
		inverseJoinColumns = @JoinColumn(name = "person_id", referencedColumnName = "person_id"))
	private Set<Person> people = new HashSet<Person>();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Set<Person> getPeople() {
		return people;
	}

	public void setPeople(Set<Person> people) {
		this.people = people;
	}

}