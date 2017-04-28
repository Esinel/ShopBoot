package com.example.stefanos.shopboot.model;

import java.io.Serializable;

/**
 * Created by Stefanos on 4/26/2017.
 */

public class Article implements Serializable{

    private String name;

    private boolean done;

    public Article(String name, boolean done) {
        this.name = name;
        this.done = done;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
}
