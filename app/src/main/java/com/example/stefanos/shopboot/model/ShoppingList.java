package com.example.stefanos.shopboot.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Stefanos on 4/26/2017.
 */

public class ShoppingList implements Serializable{

    private long id;

    private String name;

    private List<Article> articles;

    private boolean finished;

    private boolean locked;

    private String password;

    public ShoppingList() {
    }

    public ShoppingList(String name, List<Article> articles, boolean finished, boolean locked, String password) {
        this.name = name;
        this.articles = articles;
        this.finished = finished;
        this.locked = locked;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
