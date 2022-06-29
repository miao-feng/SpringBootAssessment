package org.generation.SpringAssessment.repository.entity;

import org.generation.SpringAssessment.controller.dto.ItemDto;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String description;
    @Temporal(TemporalType.DATE)
    private Date date;

    public Item() {}

    public Item(ItemDto itemDto) {
        this.title = itemDto.getTitle();
        this.description = itemDto.getDescription();
        this.date = itemDto.getDate();
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Item{" + "id=" + id + ", title='" + title + '\''
                + ", description='" + description + '\''  +  ", date='" + date+ '\''  + "}";
    }
}




