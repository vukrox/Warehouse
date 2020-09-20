package com.braun.units;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Article {

    private int id;
    private String name;
    private String description;
    private LocalDateTime creationDate;
    private int storagePlace;
    private boolean reserved;

    public Article() {
    }

    public Article(int id, String name, String description, LocalDateTime creatioDate, int storagePlace, boolean reserved) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.creationDate = creatioDate;
        this.storagePlace = storagePlace;
        this.reserved = reserved;
    }

    public Article(String name, String description, LocalDateTime creatioDate, int storagePlace, boolean reserved) {
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

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
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
