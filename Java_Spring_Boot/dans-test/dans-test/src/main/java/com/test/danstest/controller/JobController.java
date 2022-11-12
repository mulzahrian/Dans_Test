package com.test.danstest.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.test.danstest.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jobs")
public class JobController {

    @Autowired
    JobService jobService;

    @GetMapping
    public ResponseEntity<Object> list() throws UnirestException, JsonProcessingException {
        return jobService.list();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getById(@PathVariable("id") String id) throws UnirestException, JsonProcessingException {
        return jobService.getById(id);
    }
}
