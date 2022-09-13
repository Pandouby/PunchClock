package com.example.punchclock.service.entry;

import com.example.punchclock.model.Entry;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntityRepository extends CrudRepository<Entry, Long> {

}
