package com.wyy.testtranaction.model;

import com.baomidou.mybatisplus.annotation.TableName;

/**
 * @Date: 2021/9/2
 * @Author: wyy
 */
@TableName("user")
public class User {
    private long id;
    private String name;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public long getId() {
        return id;
    }

    public User setId(long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }
}
