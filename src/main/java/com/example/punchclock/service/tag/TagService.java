package com.example.punchclock.service.tag;

import com.example.punchclock.model.Tag;
import com.example.punchclock.service.tag.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagService {
    TagRepository tagRepository;

    @Autowired
    public TagService(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    public List<Tag> getTags() {
        return (List<Tag>) tagRepository.findAll();
    }

    public Tag postTag(Tag tag) {
        tagRepository.save(tag);
        return tag;
    }

    public Tag updateTag(Long id, Tag tag) {
        Tag tagToUpdate = tagRepository.findById(id).get();
        tagToUpdate.setTitle(tag.getTitle());
        tagRepository.save(tagToUpdate);
        return tagToUpdate;
    }

    public void deleteTag(Long id) {
        tagRepository.deleteById(id);
    }
}
