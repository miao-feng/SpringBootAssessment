package org.generation.SpringAssessment.controller;

import org.generation.SpringAssessment.controller.dto.ItemDto;
import org.generation.SpringAssessment.repository.entity.Item;
import org.generation.SpringAssessment.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;


@RestController
@RequestMapping("/item")
public class ItemController {
    final ItemService itemService;
    public ItemController(@Autowired ItemService itemService) {
        this.itemService = itemService;
    }

    @CrossOrigin
    @GetMapping("/all")
    public Iterable<Item> getItems() {
        return itemService.all();
    }

    @CrossOrigin
    @GetMapping("/{id}")
    public Item findItemById(@PathVariable Integer id) {
        return itemService.findById(id);
    }

    @CrossOrigin
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        itemService.delete(id);
    }

    @CrossOrigin
    @PostMapping("/add")
    public void save(@RequestParam (name = "title", required = true) String title,
                     @RequestParam (name = "description", required = false) String description,
                     @RequestParam (name = "date", required = true) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date date
                     ) {
        ItemDto itemDto = new ItemDto(title, description, date);
        itemService.save(new Item(itemDto));
    }



}
