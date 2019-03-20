package com.akadamie.cosmitapp.controlers;


import com.akadamie.cosmitapp.Models.dtos.TagDto;
import com.akadamie.cosmitapp.services.TagService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1")
public class TagController {
    private TagService tagService;

    public TagController(TagService tagService) {
        this.tagService = tagService;
    }

    @GetMapping("/dto/tags")
    public List<TagDto> getTags() {
        return tagService.getTags();
    }
}
