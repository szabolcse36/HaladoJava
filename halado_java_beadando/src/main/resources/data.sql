INSERT INTO people (person_id, name, age) VALUES 
	(1, 'Peter', 25),
	(2, 'John', 30),
	(3, 'Katie', 18);
	
INSERT INTO details (detail_id, person_id, name, level) VALUES
	(1, 1, 'speech', 'BASE'),
	(2, 3, 'speech', 'MEDIUM'),
	(3, 2, 'speech', 'HIGH'),
	(4, 2, 'appearance', 'MEDIUM'),
	(5, 3, 'appearance', 'HIGH');

INSERT INTO events (event_id, location, event_date) VALUES 
	(1, 'Sports Day', '2017-09-20'),
	(2, 'School Opening Ceremony', '2017-05-05'),
	(3, 'City Day','2017-01-04');
	
INSERT INTO people_events (person_id, event_id) VALUES
	(1, 1),
	(1, 2),
	(2, 1),
	(3, 2),
	(2, 3);
	
	