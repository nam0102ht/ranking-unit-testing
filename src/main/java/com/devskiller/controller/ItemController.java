package com.devskiller.controller;

import com.devskiller.service.ItemService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ItemController {
    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping(value = "/titles")
    @ResponseBody
    public List<String> getTitles(@RequestParam("rating") Double rating) {
        return itemService.getTitlesWithAverageRatingLowerThan(rating);
    }
}
