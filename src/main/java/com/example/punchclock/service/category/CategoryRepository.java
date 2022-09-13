package com.example.punchclock.service.category;

import com.example.punchclock.model.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {
}
