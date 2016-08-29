package com.example.rest;

import java.util.Collection;

import com.example.domain.Stuff;
import com.example.persist.StuffPersistenceService;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author voor
 */
@RestController
@Slf4j
public class BasicRestController {

    private final StuffPersistenceService stuffPersistenceService;

    @Autowired
    public BasicRestController(StuffPersistenceService stuffPersistenceService) {

        this.stuffPersistenceService = stuffPersistenceService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Collection<Stuff> getStuff() {

        return this.stuffPersistenceService.getStuff();

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addStuff(@RequestBody Stuff stuff) {

        // Send the stuff down for persistence (storage).
        stuffPersistenceService.addStuff(stuff);
    }

}
