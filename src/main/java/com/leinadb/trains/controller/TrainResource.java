package com.leinadb.trains.controller;

import com.leinadb.trains.model.TrainData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TrainResource {
    private final SimpMessagingTemplate template;

    public TrainResource(SimpMessagingTemplate template) {
        this.template = template;
    }

    @PutMapping("/trains/{id}/location")
    public HttpEntity trainLocation(@PathVariable String id, @RequestBody TrainData data) {
        this.template.convertAndSend("/topic/trains", data);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
