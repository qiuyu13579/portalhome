package com.ai.portalhome.rest.demo.dto;

/**
 * 
 * Title: Task的dto <br>
 * Description: <br>
 * Date: 2016年10月14日 <br>
 * Copyright (c) 2016 AILK <br>
 * 
 * @author liangyi
 */
public class TaskRepresentation {

    private String id;
    private String name;

    public TaskRepresentation(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
