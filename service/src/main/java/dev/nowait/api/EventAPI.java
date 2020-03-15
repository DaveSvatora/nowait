package dev.nowait.api;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.nowait.data.EventDAO;
import dev.nowait.model.Event;
import dev.nowait.model.EventRequest;

@RestController
@RequestMapping
public class EventAPI {
    @Autowired
    private EventDAO dao;

    @GetMapping(value = "/events", produces = {APPLICATION_JSON_VALUE})
    public ResponseEntity<List<Event>> findAll() {
        return new ResponseEntity<List<Event>>(dao.findAll(), HttpStatus.OK);
    }

    @PostMapping(value = "/event", consumes = {APPLICATION_JSON_VALUE}, produces = {APPLICATION_JSON_VALUE})
    public ResponseEntity<Event> createEvent(@RequestBody EventRequest request) {
        return new ResponseEntity<Event>(dao.createEvent(request), HttpStatus.CREATED);
    }

}