package dev.nowait.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalTime;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import dev.nowait.model.EventQueue;

@Component
public class EventQueueRowMapper implements RowMapper<EventQueue> {

    @Override
    public EventQueue mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new EventQueue(rs.getInt("event_num"), rs.getInt("serving_num"), rs.getString("name"),
                rs.getString("phone_num"), LocalTime.parse(rs.getString("start_time")),
                LocalTime.parse(rs.getString("next_in_line")), LocalTime.parse(rs.getString("end_time")));
    }

}