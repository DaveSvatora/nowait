package dev.nowait.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import dev.nowait.model.Event;

@Component
public class EventRowMapper implements RowMapper<Event> {

    @Override
    public Event mapRow(ResultSet rs, int arg1) throws SQLException {
        return new Event(rs.getInt("event_num"), rs.getString("event_name"), LocalDate.parse(rs.getString("event_date")));
    }
    
}