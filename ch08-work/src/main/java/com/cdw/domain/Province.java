package com.cdw.domain;

/**
 * @author: cdw
 * @date: 2021/12/4 21:57
 * @description:
 */
public class Province {
    private Integer id;
    private String name;

    public Province() {
    }

    public Province(String name) {
        this.name = name;
    }

    public Province(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
        return "Province{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
