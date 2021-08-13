package com.wyy.demo;

/**
 * @Date: 2021/8/12
 * @Author: wyy
 */
public class UserDTO {
    private String name;
    private long id;

    @Override
    public String toString() {
        return "UserDTO{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
