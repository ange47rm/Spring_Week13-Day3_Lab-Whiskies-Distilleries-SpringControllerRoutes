package com.codeclan.example.WhiskyTracker.controllers;

import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class WhiskyController {

    @Autowired
    WhiskyRepository whiskyRepository;

    @GetMapping(value= "/whiskies")
    public ResponseEntity<List<Whisky>> getWhiskies(@RequestParam(name="year", required = false) Integer year) {
        if (year != null){
            return new ResponseEntity(whiskyRepository.findWhiskyByYear(year), HttpStatus.OK);
        } else {
        return new ResponseEntity<>(whiskyRepository.findAll(), HttpStatus.OK);
    }
    }

    @GetMapping(value="/whiskies/{id}")
    public ResponseEntity getWhisky(@PathVariable Long id){
        return new ResponseEntity(whiskyRepository.findById(id), HttpStatus.OK);
    }

}
