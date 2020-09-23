package com.braun.units;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

/*
 * POJO Core-Class describing the main behaviour.
 */
public class Article {

    private int id;
    private String name;
    private String description;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate creationDate;
    private int storagePlace;
    private boolean reserved;

    public Article() {
    }

    public Article(int id, String name, String description, LocalDate creatioDate, int storagePlace, boolean reserved) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.creationDate = creatioDate;
        this.storagePlace = storagePlace;
        this.reserved = reserved;
    }

    public Article(String name, String description, LocalDate creatioDate, int storagePlace, boolean reserved) {
        this.name = name;
        this.description = description;
        this.creationDate = creatioDate;
        this.storagePlace = storagePlace;
        this.reserved = reserved;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", creationDate=" + creationDate +
                ", storagePlace=" + storagePlace +
                ", reserved=" + reserved +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public int getStoragePlace() {
        return storagePlace;
    }

    public void setStoragePlace(int storagePlace) {
        this.storagePlace = storagePlace;
    }

    public boolean isReserved() {
        return reserved;
    }

    public void setReserved(boolean reserved) {
        this.reserved = reserved;
    }
}
