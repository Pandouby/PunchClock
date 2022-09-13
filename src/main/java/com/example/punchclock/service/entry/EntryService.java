package com.example.punchclock.service.entry;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.example.punchclock.model.Entry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntryService {

    EntityRepository entityRepository;

    @Autowired
    public EntryService(EntityRepository entityRepository) {
        this.entityRepository = entityRepository;
    }

    public List<Entry> findAll() {
        return (List<Entry>) entityRepository.findAll();
    }

    public Entry createEntry(Entry entry, String token) {
        entityRepository.save(entry);
        return entry;
    }

    public Entry update(Long id, Entry entry) {
        Entry entryToUpdate = entityRepository.findById(id).get();
        entryToUpdate.setCheckIn(entry.getCheckIn());
        entryToUpdate.setCheckOut(entry.getCheckOut());
        entityRepository.save(entryToUpdate);
        return entryToUpdate;
    }

    public void delete(long id) {
        entityRepository.deleteById(id);
    }

    public void isTokenValid(String token) {
        try {
            JWT.require(Algorithm.HMAC256("123@abc")).build().verify(token);
        } catch (JWTVerificationException e){

        }

    }
 }
