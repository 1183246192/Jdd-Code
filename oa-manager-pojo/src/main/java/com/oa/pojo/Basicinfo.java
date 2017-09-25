package com.oa.pojo;

public class Basicinfo {
    private String id;

    private String name;

    private String value;

    private Integer isalive;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value == null ? null : value.trim();
    }

    public Integer getIsalive() {
        return isalive;
    }

    public void setIsalive(Integer isalive) {
        this.isalive = isalive;
    }
}