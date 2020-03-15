package dev.nowait.api;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.nowait.data.EventQueueDAO;
import dev.nowait.model.EventQueue;
import dev.nowait.model.EventQueueRequest;

@RestController
@RequestMapping
public class EventQueueAPI {

    @Autowired
    private EventQueueDAO dao;
    
    @GetMapping(value = "/eventqueue", produces = {APPLICATION_JSON_VALUE})
    public ResponseEntity<List<EventQueue>> findAll() {
        return new ResponseEntity<List<EventQueue>>(dao.findAll(), HttpStatus.OK);
    }

    @PostMapping(value = "/eventqueue", consumes = {APPLICATION_JSON_VALUE}, produces = {APPLICATION_JSON_VALUE})
    public ResponseEntity<EventQueue> createEventQueue(@RequestBody EventQueueRequest request) {
        return new ResponseEntity<EventQueue>(dao.createEventQueue(request), HttpStatus.CREATED);
    }

    @PatchMapping(value = "/eventqueue/nextinline/{servingNum}", produces = {APPLICATION_JSON_VALUE})
    public ResponseEntity<EventQueue> updateNextInLine(@PathVariable int servingNum) {
        return new ResponseEntity<EventQueue>(dao.updateNextInLine(servingNum), HttpStatus.OK);
    }

    @PatchMapping(value = "/eventqueue/served/{servingNum}", produces = {APPLICATION_JSON_VALUE})
    public ResponseEntity<EventQueue> updateServed(@PathVariable int servingNum) {
        return new ResponseEntity<EventQueue>(dao.updateServed(servingNum), HttpStatus.OK);
    }
}