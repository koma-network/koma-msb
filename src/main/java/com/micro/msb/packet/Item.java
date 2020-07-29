/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.micro.msb.packet;

/**
 *
 * @author SENOPATI
 */
public class Item {

    private Attr attr;

    private String group;

    public Attr getAttr() {
        return attr;
    }

    public void setAttr(Attr attr) {
        this.attr = attr;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return "ClassPojo [attr = " + attr + ", group = " + group + "]";
    }
}
