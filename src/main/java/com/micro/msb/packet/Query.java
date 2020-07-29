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
public class Query {

    private String username;
    private String password;
    private Object item;
    private Object feature;
    private Object identity;
    private Storage storage;
    private Scratchpad scratchpad;
    private X x;
    private Attr attr;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }    
    
    public Item[] getItem() {
        
        Gson gson = new Gson();
        JsonElement element = gson.toJsonTree(item);        
        if(element.isJsonArray()){
            item = gson.fromJson(element,Item[].class);
        }else{
            Item[] items = new Item[1];
            items[0] = gson.fromJson(element,Item.class);
            item = items;
        }
        return (Item[]) item;
    }

    public void setItem(Object item) {
        this.item = item;
    }

    public Feature[] getFeature() {
        Gson gson = new Gson();
        JsonElement element = gson.toJsonTree(feature);
        if(element.isJsonArray()){
            feature = gson.fromJson(element,Feature[].class);
        }else{
            Feature[] features = new Feature[1];
            features[0] = gson.fromJson(element,Feature.class);
            feature = features;
        }        
        return (Feature[]) feature;
    }

    public void setFeature(Object feature) {
        this.feature = feature;
    }

    public Identity[] getIdentity() {
        Gson gson = new Gson();
        JsonElement element = gson.toJsonTree(identity);
        if(element.isJsonArray()){
            identity = gson.fromJson(element,Identity[].class);
        }else{
            Identity[] identities = new Identity[1];
            identities[0] = gson.fromJson(element,Identity.class);
            identity = identities;
        }        
        return (Identity[]) identity;
    }

    public void setIdentity(Object identity) {
        this.identity = identity;
    }

    public Storage getStorage() {
        return storage;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }

    public Scratchpad getScratchpad() {
        return scratchpad;
    }

    public void setScratchpad(Scratchpad scratchpad) {
        this.scratchpad = scratchpad;
    }

    public X getX() {
        return x;
    }

    public void setX(X x) {
        this.x = x;
    }

    public Attr getAttr() {
        return attr;
    }

    public void setAttr(Attr attr) {
        this.attr = attr;
    }

    @Override
    public String toString() {
        return "ClassPojo [attr = " + attr + "]";
    }
}
