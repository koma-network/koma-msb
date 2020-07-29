/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.micro.msb.packet;

import com.google.gson.Gson;
import com.google.gson.JsonElement;

/**
 *
 * @author SENOPATI
 */
public class X {

    private String offline;
    private String composing;
    private String instructions;
    private String title;
    private Attr attr;    
    private Object field;

    public String getOffline() {
        return offline;
    }

    public void setOffline(String offline) {
        this.offline = offline;
    }

    public Attr getAttr() {
        return attr;
    }

    public void setAttr(Attr attr) {
        this.attr = attr;
    }

    public String getComposing() {
        return composing;
    }

    public void setComposing(String composing) {
        this.composing = composing;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Field[] getField() {
        Gson gson = new Gson();
        JsonElement element = gson.toJsonTree(field);        
        if(element.isJsonArray()){
            field = gson.fromJson(element,Field[].class);
        }else{
            Field[] fields = new Field[1];
            fields[0] = gson.fromJson(element,Field.class);
            field = fields;
        }
        return (Field[]) field;
    }

    public void setField(Object field) {
        this.field = field;
    }

    @Override
    public String toString() {
        return "ClassPojo [offline = " + offline + ", attr = " + attr + ", composing = " + composing + "]";
    }
}
