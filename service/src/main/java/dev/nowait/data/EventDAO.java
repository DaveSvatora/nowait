package dev.nowait.data;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import dev.nowait.model.Event;
import dev.nowait.model.EventRequest;

@Repository
public class EventDAO {
    @Autowired
    private NamedParameterJdbcTemplate jdbc;
    @Autowired
    private EventRowMapper rowMapper;

	public List<Event> findAll() {
		return jdbc.query("SELECT * FROM event", rowMapper);
    }
    
    public Event createEvent(EventRequest event) {
        return jdbc.queryForObject("INSERT INTO event (event_name, event_date) VALUES (:eventName, :eventDate) RETURNING *", new BeanPropertySqlParameterSource(event), rowMapper);
    }

}