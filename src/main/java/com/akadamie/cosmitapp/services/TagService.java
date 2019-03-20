package com.akadamie.cosmitapp.services;


import com.akadamie.cosmitapp.Models.dtos.TagDto;
import com.akadamie.cosmitapp.mappers.TagMapper;
import com.akadamie.cosmitapp.repositories.TagRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TagService {

    private TagRepository tagRepository;
    private TagMapper tagMapper;

    public TagService(TagRepository tagRepository, TagMapper tagMapper) {
        this.tagRepository = tagRepository;
        this.tagMapper = tagMapper;
    }

    public List<TagDto> getTags() {
        return tagRepository
                .findAll()
                .stream()
                .map(tagMapper::map)
                .collect(Collectors.toList());
    }
}
