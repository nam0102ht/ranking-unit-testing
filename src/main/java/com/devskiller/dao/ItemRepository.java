package com.devskiller.dao;

import com.devskiller.model.Item;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ItemRepository extends CrudRepository<Item, Long> {

    @Query("SELECT i FROM Item i JOIN i.reviews r WHERE r.rating < :rate GROUP BY i.id")
    List<Item> findItemsWithAverageRatingLowerThan(@Param("rate") Double rating);
}
