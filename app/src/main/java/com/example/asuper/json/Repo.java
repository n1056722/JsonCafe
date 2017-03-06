package com.example.asuper.json;

/**
 * Created by bvxcx on 2017/3/6.
 */

public class Repo {
    private int id;
    private String name;

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

    @Override
    public String toString() {
        return "Repo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
