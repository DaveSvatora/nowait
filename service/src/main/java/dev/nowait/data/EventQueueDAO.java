package dev.nowait.data;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import dev.nowait.model.EventQueue;
import dev.nowait.model.EventQueueRequest;

@Repository
public class EventQueueDAO {

    @Autowired
    private NamedParameterJdbcTemplate jdbc;
    @Autowired
    private EventQueueRowMapper rowMapper;

    public List<EventQueue> findAll() {
        return jdbc.query("SELECT * FROM event_queue", rowMapper);
    }

	public EventQueue createEventQueue(EventQueueRequest request) {
		return jdbc.queryForObject("INSERT INTO event_queue (event_num, name, phone_num) VALUES (:eventNum, :name, :phoneNum) RETURNING *", new BeanPropertySqlParameterSource(request), rowMapper);
    }
    
    public EventQueue updateNextInLine(int servingNum) {
        return jdbc.queryForObject("UPDATE event_queue SET next_in_line = CURRENT_TIME WHERE serving_num = :servingNum RETURNING *", new MapSqlParameterSource().addValue("servingNum", servingNum), rowMapper);
    }

	public EventQueue updateServed(int servingNum) {
		return jdbc.queryForObject("UPDATE event_queue SET end_time = CURRENT_TIME WHERE serving_num = :servingNum RETURNING *", new MapSqlParameterSource().addValue("servingNum", servingNum), rowMapper);
	}
}