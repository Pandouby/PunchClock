package com.example.punchclock.controller;

import com.example.punchclock.model.Tag;
import com.example.punchclock.service.tag.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class TagController {

    TagService tagService;

    @Autowired
    public TagController(TagService tagService) {
        this.tagService = tagService;
    }


    @GetMapping("/tags")
    public void getTags() {
        tagService.getTags();
    }

    @PostMapping("/tag")
    public ResponseEntity postTag(@RequestBody Tag tag) {
        tagService.postTag(tag);
        return new ResponseEntity(tag, HttpStatus.OK);
    }

    @PutMapping("/tag/{id}")
    public ResponseEntity putTag(@PathVariable Long id, @RequestBody Tag tag) {
        tagService.updateTag(id, tag);
        return new ResponseEntity(tag, HttpStatus.OK);

    }

    @DeleteMapping("/tag/{id}")
    public void deleteTag(@PathVariable Long id) {
        tagService.deleteTag(id);
    }
}
