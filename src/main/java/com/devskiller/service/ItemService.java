package com.devskiller.service;

import com.devskiller.dao.ItemRepository;
import com.devskiller.model.Item;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ItemService {

    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<String> getTitlesWithAverageRatingLowerThan(Double rating) {
        return itemRepository.findItemsWithAverageRatingLowerThan(rating)
                .stream().map(Item::getTitle).collect(Collectors.toList());
    }

}
