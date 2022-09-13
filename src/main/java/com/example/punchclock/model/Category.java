package com.example.punchclock.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Category {

    private Long id;
    private String title;

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
