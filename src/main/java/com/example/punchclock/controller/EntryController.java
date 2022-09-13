package com.example.punchclock.controller;

import com.example.punchclock.model.Entry;
import com.example.punchclock.service.entry.EntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EntryController {

    @Autowired
    EntryService entryService;

    @GetMapping("/entries")
    public List<Entry> get() {
        return entryService.findAll();
    }

    @PostMapping("/entries")
    public ResponseEntity create(@RequestBody Entry entry, @RequestHeader ("Authorization") String token) {
        if(entry.getCheckIn().isBefore(entry.getCheckOut())) {
            entryService.createEntry(entry, token);
            return new ResponseEntity(entry, HttpStatus.OK);
        } else {
            return new ResponseEntity("CheckOut time has to be bevor checkIn time", HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/entries/{id}")
    public ResponseEntity update(@RequestBody Entry entry, @PathVariable Long id) {
        if(entry.getCheckIn().isBefore(entry.getCheckOut())) {
            entryService.update(id, entry);
            entry.setId(id);
            return new ResponseEntity(entry, HttpStatus.OK);
        } else {
            return new ResponseEntity("CheckOut time has to be bevor checkIn time", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/entries/{id}")
    public void delete(@PathVariable Long id) {
        entryService.delete(id);
    }
}
