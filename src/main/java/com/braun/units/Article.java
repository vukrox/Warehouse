package com.braun.units;

import java.util.Calendar;

public class Article {

    private int id;
    private String name;
    private String description;
    private Calendar creatioDate;
    private int storagePlace;
    private boolean reserved;

    public Article(int id, String name, String description, Calendar creatioDate, int storagePlace, boolean reserved) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.creatioDate = creatioDate;
        this.storagePlace = storagePlace;
        this.reserved = reserved;
    }

    public Article(String name, String description, Calendar creatioDate, int storagePlace, boolean reserved) {
        this.name = name;
        this.description = description;
        this.creatioDate = creatioDate;
        this.storagePlace = storagePlace;
        this.reserved = reserved;
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

    public Calendar getCreatioDate() {
        return creatioDate;
    }

    public void setCreatioDate(Calendar creatioDate) {
        this.creatioDate = creatioDate;
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
