package com.singapure.app.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Prueba {

    private int id;
    private String content;
    
    public Prueba(int id, String content) {
    	this.id = id;
    	this.content = content;
    }

}